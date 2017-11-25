package com.megogo.configuration

import com.megogo.clients.epg.MegogoEpgFeignClient
import com.megogo.clients.epg.VseTvEpgFeignClient
import com.megogo.operations.epg.MegogoEpgOperations
import com.megogo.operations.common.SessionAttributes
import com.megogo.operations.epg.VseTvEpgOperations
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OperationsConfiguration {

    @Bean
    SessionAttributes sessionAttributes() {
        new SessionAttributes()
    }

    @Bean
    MegogoEpgOperations megogoEpgOperations(MegogoEpgFeignClient megogoEpgFeignClient,
                                            SessionAttributes sessionAttributes) {
        new MegogoEpgOperations(megogoEpgFeignClient, sessionAttributes)
    }

    @Bean
    VseTvEpgOperations vseTvEpgOperations(VseTvEpgFeignClient vseTvEpgFeignClient,
                                          SessionAttributes sessionAttributes) {
        new VseTvEpgOperations(vseTvEpgFeignClient, sessionAttributes)
    }
}
