package com.collect.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import net.sf.json.JSONObject;

/*该注解用来指定一个URI，客户端可以通过这个URI来连接到WebSocket。
类似Servlet的注解mapping。无需在web.xml中配置。*/

@ServerEndpoint("/websocket/{id}")
public class WebSocketChat {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");    // 日期格式化
	// 静态变量，用来记录当前在线连接数。
	private static int ONLIN_COUNT = 0;
    // concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<WebSocketChat> webSocketSet = new CopyOnWriteArraySet<WebSocketChat>();
    
    //id
    private String id = null;
    
	
    private Session session;
    /*
     *使用@Onopen注解的表示当客户端链接成功后的回掉。参数Session是可选参数
     *这个Session是WebSocket规范中的会话，表示一次会话。并非HttpSession
     */
	@OnOpen
	public void open(@PathParam("id") String id,Session session)
	{
		System.out.println(id);
		this.session = session;
		this.id=id;
		addOnlineCount();
		webSocketSet.add(this);
		System.out.println("开始监听！");
	}
	
	@OnMessage
	public void OnMessage(@PathParam("id") String id,String message,Session session)
	{

		JSONObject json = JSONObject.fromObject(message);

		json.put("data", DATE_FORMAT.format(new Date()));
		json.put("number", ONLIN_COUNT);
		
		//群发消息
		for(WebSocketChat WebChat:webSocketSet)
		{
			System.out.println(message);
			json.put("isSelf", WebChat.session.equals(session));

			WebChat.session.getAsyncRemote().sendText(json.toString());
		}
	}
	
	@OnClose
	public void OnClose()
	{
		//关闭聊天
		webSocketSet.remove(this);
		subOnlineCount();
		System.out.println("关闭聊天");
	}
	
	@OnError
	public void OnError(Throwable t)
	{
		//抛出错误信息
	}
	
    public static synchronized void addOnlineCount() {  
    	WebSocketChat.ONLIN_COUNT++;  
    }  
  
    public static synchronized void subOnlineCount() {  
    	WebSocketChat.ONLIN_COUNT--;  
    }
}
