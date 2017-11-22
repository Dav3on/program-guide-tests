package configuration

import clients.epg.MegogoEpgFeignClient
import operations.epg.MegogoEpgOperations
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OperationsConfiguration {

    @Bean
        MegogoEpgOperations megogoEpgOperations(MegogoEpgFeignClient megogoEpgFeignClient) {
            new MegogoEpgOperations(megogoEpgFeignClient)
    }
}
