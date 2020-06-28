package com.example.demo

import com.example.demo.dto.Message
import org.slf4j.LoggerFactory
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Controller

@Controller
class EventController {
    @JmsListener(destination = "test")
    fun test(message: Message) {
        LoggerFactory.getLogger(this::class.java).warn("잘받았다 메세지 : $message")
    }
}