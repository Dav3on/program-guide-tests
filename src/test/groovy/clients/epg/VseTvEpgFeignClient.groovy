package clients.epg

import model.vsetv.ProgramGuideResponse
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "vsetv", path = "/export/megogo")
interface VseTvEpgFeignClient {

    @GetMapping(value =  "/epg/{chanelId}.xml", produces = MediaType.APPLICATION_XML_VALUE)
    ProgramGuideResponse getProgramGuideById(@PathVariable("external_id") long chanelId)
}