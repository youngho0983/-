package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/chat")
@Controller
public class ChatController {

    @RequestMapping("")
    public String goChatlist(){
        System.out.println("go chatlist");

        return "/chat/chatRoomList";
    }

    @RequestMapping("/basic1")
    public String goChatRoom1(){
        System.out.println("fo ChatRoom1");

        return "/chat/room1";
    }
}
