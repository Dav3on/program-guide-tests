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

    MegogoProgramGuide getProgramGuideByChanelId(long chanelId) {
        log.info("Trying to get program guide by chanel id: $chanelId")
        MegogoProgramGuide response = megogoEpgFeignClient.getProgramGuideById(chanelId)
        sessionAttributes.addMegogoEpg(response)
        response
    }

    void verifyMegogoProgramsAreEqualToVseTv(MegogoProgramGuide megogoProgramGuide = sessionAttributes.getMegogoEpg(),
                                             VseTvProgramGuide vseTvProgramGuide = sessionAttributes.getVseTvEpg()) {
        assert megogoProgramGuide.result == MegogoResponseStatus.OK.status

        List<MegogoProgram> megogoPrograms = megogoProgramGuide.programGuides.first().programs
        List<MegogoProgram> sortedMegogoPrograms = sortMegogoProgramsByStartDate(megogoPrograms)
        Date megogoStart = sortedMegogoPrograms[0].start
        Date megogoEnd = sortedMegogoPrograms[-1].start
        List<VseTvProgram> vseTvProgramsByTimeRange = vseTvProgramGuide.programs.findAll { program ->
            program.start >= megogoStart  && program.start <= megogoEnd }

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
            }: "Megogo program with start time: ${vseTvProgram.start}, end time: ${vseTvProgram.end} and " +
                    "title text: ${vseTvProgram.title} not found in VseTv programms"
        }
    }
}
