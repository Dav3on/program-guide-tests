package operations.epg

import clients.epg.MegogoEpgFeignClient
import groovy.util.logging.Slf4j
import model.megogo.ProgramGuideResponse
import org.springframework.stereotype.Component

@Slf4j
@Component
class MegogoEpgOperations {
    private MegogoEpgFeignClient megogoEpgFeignClient

    MegogoEpgOperations(MegogoEpgFeignClient megogoEpgFeignClient) {
        this.megogoEpgFeignClient = megogoEpgFeignClient
    }

    ProgramGuideResponse getProgramGuideByChanelId(long chanelId) {
        log.info("Trying to get program guide by chanel id: $chanelId")
        megogoEpgFeignClient.getProgramGuideById(chanelId)
    }
}
