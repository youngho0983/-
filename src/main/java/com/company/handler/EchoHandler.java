package com.company.handler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@RequestMapping("/echo")
public class EchoHandler extends TextWebSocketHandler {
    //세션 리스트
    private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

    private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);

    List abuses;
    {
        abuses=new ArrayList();
        abuses.add("나쁜말");
        abuses.add("매우나쁜말");
    }

    //클라이언트가 연결 되었을 때 실행
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionList.add(session);

        logger.info("{} 연결됨", session.getId());
    }

    //클라이언트가 웹소켓 서버로 메시지를 전송했을 때 실행
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("{}로 부터 {} 받음", session.getId(), message.getPayload());
        //모든 유저에게 메세지 출력
        for (WebSocketSession sess : sessionList) {
            String temp=message.getPayload();
            int index=temp.indexOf("&massage=");
            String content=temp.substring(index+9);
            for(int i=0;i<abuses.size();i++){
                String tem=(String)abuses.get(i);
                content=content.replace(tem,"욕설필터");
                System.out.println(content);
            }
            String id=temp.substring(3,index);

//            String content=temp.substring(index);

            if(sess.equals(session)){
                sess.sendMessage(new TextMessage(content));
            }else{
                sess.sendMessage(new TextMessage(id+":"+content));

            }

//            message.getPayload()
        }
    }

    //클라이언트 연결을 끊었을 때 실행
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionList.remove(session);
        logger.info("{} 연결 끊김.", session.getId());
    }
}