package com.megogo.configuration

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@EnableFeignClients("com.megogo.clients")
class CloudConfiguration {
}
