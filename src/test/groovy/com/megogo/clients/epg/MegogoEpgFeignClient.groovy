package com.megogo.clients.epg

import com.megogo.model.megogo.MegogoProgramGuide
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient("megogo")
interface MegogoEpgFeignClient {

    @GetMapping(value =  "/channel", produces = MediaType.APPLICATION_JSON_VALUE)
    MegogoProgramGuide getProgramGuideById(@RequestParam("external_id") long externalId)
}
