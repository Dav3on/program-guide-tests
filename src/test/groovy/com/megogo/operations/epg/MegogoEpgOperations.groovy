package com.megogo.operations.epg

import com.megogo.clients.epg.MegogoEpgFeignClient
import com.megogo.enums.MegogoResponseStatus
import com.megogo.model.megogo.MegogoProgramGuide
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

    void verifyAllProgramsPresentInVseTvResponse(MegogoProgramGuide megogoProgramGuide = sessionAttributes.getMegogoEpg(),
                                                 VseTvProgramGuide vseTvProgramGuide = sessionAttributes.getVseTvEpg()) {
        assert megogoProgramGuide.result == MegogoResponseStatus.OK.status

        //TODO need to refactor this!
        log.info("VseTv programs list: ${vseTvProgramGuide}")
        megogoProgramGuide.programGuides[0].programs.each { megogoProgram ->
            assert vseTvProgramGuide.programs.find { vseTvProgram ->
                vseTvProgram.start == megogoProgram.start
                vseTvProgram.stop == megogoProgram.end
                vseTvProgram.title.title == megogoProgram.title
            } : "Program with start time: ${megogoProgram.start}, end time: ${megogoProgram.end} and title: ${megogoProgram.title} not found in VseTv response"
        }
    }
}
