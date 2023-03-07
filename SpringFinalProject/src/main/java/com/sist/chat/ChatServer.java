package com.sist.chat;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@ServerEndpoint("/site/chat/chat-ws") //Tiles 사용하지 않는다 ViewResolver꺼 사용 중 , 프로토콜이 달라서 타일즈에서 인식 못해 tiles는 http/ chat은 websocket
public class ChatServer {
   private static List<Session> users=new ArrayList<Session>();
   //클라이언트가 접속을 했을 때 처리하는 부분
   @OnOpen
   public void onOpen(Session session)
   {
      //HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
      //HttpSession se=request.getSession();
      users.add(session);
      System.out.println("클라이언트 접속..."+session.getId());
   }
   //클라이언트가 퇴장을 했을 때 처리하는 부분
   @OnClose
   public void onClose(Session session)
   {
      //HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
      //HttpSession se=request.getSession();
      users.remove(session);
      System.out.println("클라이언트 퇴장..."+session.getId());
   }
   //클라이언트가 채팅 문자열을 전송했을 때
   @OnMessage
   public void onMessage(String message,Session session) throws Exception
               //    채팅 문자열         누가 메세지 보냈는지
   {
      System.out.println("수신 메세지:"+message);
      //HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
      //HttpSession se=request.getSession();
      //String name=(String)se.getAttribute("name");
      Iterator<Session> iterator=users.iterator();
      System.out.println("채팅 인원:"+users.size());
      while(iterator.hasNext())
      {
         iterator.next().getBasicRemote().sendText(message);// //접속한 모든 사람한테 sendText
      }
   }
}