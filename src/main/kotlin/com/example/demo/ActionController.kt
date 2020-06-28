package com.example.demo

import com.example.demo.dto.Message
import org.slf4j.LoggerFactory
import org.springframework.jms.core.JmsTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class ActionController(
    val jmsTemplate: JmsTemplate
) {
    @PostMapping("/")
    fun sendMessage() {
        val message = Message(Random.nextInt())
        jmsTemplate.convertAndSend("test", message)
        LoggerFactory.getLogger(this::class.java).warn("전송했다!! : $message")
    }
}