package com.example.demo

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.support.converter.MappingJackson2MessageConverter
import org.springframework.jms.support.converter.MessageType

@Configuration
class JmsConfiguration {
    @Bean
    fun messageConverter(): MappingJackson2MessageConverter {
        val converter = MappingJackson2MessageConverter()
        converter.setTargetType(MessageType.TEXT)
        converter.setTypeIdPropertyName("_type")
        converter.setObjectMapper(jacksonObjectMapper())
        return converter
    }
}