package com.megogo.clients.epg

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "vsetv", path = "/export/megogo")
interface VseTvEpgFeignClient {

    //TODO define type after https://github.com/FasterXML/jackson-module-kotlin/issues/91 is done
    @GetMapping(value =  "/epg/{chanelId}.xml", produces = MediaType.APPLICATION_XML_VALUE)
    String getProgramGuideById(@PathVariable("chanelId") long chanelId)
}