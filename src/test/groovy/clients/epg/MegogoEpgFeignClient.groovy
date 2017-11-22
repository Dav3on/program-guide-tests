package clients.epg

import model.megogo.ProgramGuideResponse
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient("megogo")
interface MegogoEpgFeignClient {

    @GetMapping(value =  "/channel", produces = MediaType.APPLICATION_JSON_VALUE)
    ProgramGuideResponse getProgramGuideById(@RequestParam("external_id") long externalId)
}
