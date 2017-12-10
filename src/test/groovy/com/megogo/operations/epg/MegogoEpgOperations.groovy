package com.megogo.operations.epg

import com.megogo.clients.epg.MegogoEpgFeignClient
import com.megogo.enums.MegogoResponseStatus
import com.megogo.model.megogo.MegogoProgramGuide
import com.megogo.model.megogo.MegogoProgram
import com.megogo.model.vsetv.VseTvProgram
import com.megogo.model.vsetv.VseTvProgramGuide
import com.megogo.operations.common.SessionAttributes
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

@Slf4j
@Component
class MegogoEpgOperations {
    private MegogoEpgFeignClient megogoEpgFeignClient
    private SessionAttributes sessionAttributes

    MegogoEpgOperations(MegogoEpgFeignClient megogoEpgFeignClient,
                        SessionAttributes sessionAttributes) {
        this.megogoEpgFeignClient = megogoEpgFeignClient
        this.sessionAttributes = sessionAttributes
    }

    MegogoProgramGuide getProgramGuideByChannelId(long channelId) {
        log.info("Trying to get program guide by channel id: $channelId")
        MegogoProgramGuide response = megogoEpgFeignClient.getProgramGuideById(channelId)
        sessionAttributes.addMegogoEpg(response)
        response
    }

    void verifyMegogoProgramsAreEqualToVseTv(MegogoProgramGuide megogoProgramGuide = sessionAttributes.getMegogoEpg(),
                                             VseTvProgramGuide vseTvProgramGuide = sessionAttributes.getVseTvEpg()) {
        assert megogoProgramGuide.result == MegogoResponseStatus.OK.status

        List<MegogoProgram> megogoPrograms = megogoProgramGuide.programGuides.first().programs
        List<MegogoProgram> sortedMegogoPrograms = sortMegogoProgramsByStartDate(megogoPrograms)

        Date megogoStart = sortedMegogoPrograms.first().start
        Date megogoEnd = sortedMegogoPrograms.last().start
        assert megogoEnd.date > megogoStart.date : "endDate should be greater then startDate at least for 1 day"
        List<VseTvProgram> vseTvProgramsByTimeRange = vseTvProgramGuide.findProgramsInTimerange(megogoStart, megogoEnd)

        assert vseTvProgramsByTimeRange.size() == sortedMegogoPrograms.size()
        validateMegogoProgramsBasedOnVseTv(sortedMegogoPrograms, vseTvProgramsByTimeRange)
    }

    @SuppressWarnings("GrMethodMayBeStatic")
    private List<MegogoProgram> sortMegogoProgramsByStartDate(List<MegogoProgram> megogoPrograms) {
        megogoPrograms.sort { p1, p2 -> p1.start <=> p2.start }
    }

    @SuppressWarnings("GrMethodMayBeStatic")
    private void validateMegogoProgramsBasedOnVseTv(List<MegogoProgram> megogoPrograms, List<VseTvProgram> vseTvPrograms) {
        log.info("VseTv programs: $vseTvPrograms")
        vseTvPrograms.each { vseTvProgram ->
            assert megogoPrograms.find { megogoProgram ->
                vseTvProgram.start == megogoProgram.start &&
                vseTvProgram.stop == megogoProgram.end &&
                vseTvProgram.title.text == megogoProgram.title
            }: "VseTv program with start time: ${vseTvProgram.start}, end time: ${vseTvProgram.stop} and " +
                    "title text: ${vseTvProgram.title} not found in Megogo programms: \n ${megogoPrograms}"
        }
    }
}
