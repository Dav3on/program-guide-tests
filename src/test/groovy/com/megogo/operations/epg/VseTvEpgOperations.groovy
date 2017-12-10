package com.megogo.operations.epg

import com.megogo.clients.epg.VseTvEpgFeignClient
import com.megogo.model.vsetv.VseTvProgramGuide
import com.megogo.operations.common.SessionAttributes
import com.megogo.utils.XmlDeserializationUtil
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

@Slf4j
@Component
class VseTvEpgOperations {
    private VseTvEpgFeignClient vseTvEpgFeignClient
    private SessionAttributes sessionAttributes

    VseTvEpgOperations(VseTvEpgFeignClient vseTvEpgFeignClient,
                       SessionAttributes sessionAttributes) {
        this.vseTvEpgFeignClient = vseTvEpgFeignClient
        this.sessionAttributes = sessionAttributes
    }

    VseTvProgramGuide getProgramGuideByChannelId(long channelId) {
        log.info("Trying to get program guide by channel id: $channelId")
        String response = vseTvEpgFeignClient.getProgramGuideById(channelId)
        assert response : "Response is empty!"

        VseTvProgramGuide programGuide = XmlDeserializationUtil.deserializeXml(response, VseTvProgramGuide)
        sessionAttributes.addVseTvEpg(programGuide)
        programGuide
    }
}
