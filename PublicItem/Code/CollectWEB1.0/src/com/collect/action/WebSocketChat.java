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

/*��ע������ָ��һ��URI���ͻ��˿���ͨ�����URI�����ӵ�WebSocket��
����Servlet��ע��mapping��������web.xml�����á�*/

@ServerEndpoint("/websocket/{id}")
public class WebSocketChat {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");    // ���ڸ�ʽ��
	// ��̬������������¼��ǰ������������
	private static int ONLIN_COUNT = 0;
    // concurrent�����̰߳�ȫSet���������ÿ���ͻ��˶�Ӧ��MyWebSocket������Ҫʵ�ַ�����뵥һ�ͻ���ͨ�ŵĻ�������ʹ��Map����ţ�����Key����Ϊ�û���ʶ
    private static CopyOnWriteArraySet<WebSocketChat> webSocketSet = new CopyOnWriteArraySet<WebSocketChat>();
    
    //id
    private String id = null;
    
	
    private Session session;
    /*
     *ʹ��@Onopenע��ı�ʾ���ͻ������ӳɹ���Ļص�������Session�ǿ�ѡ����
     *���Session��WebSocket�淶�еĻỰ����ʾһ�λỰ������HttpSession
     */
	@OnOpen
	public void open(@PathParam("id") String id,Session session)
	{
		System.out.println(id);
		this.session = session;
		this.id=id;
		addOnlineCount();
		webSocketSet.add(this);
		System.out.println("��ʼ������");
	}
	
	@OnMessage
	public void OnMessage(@PathParam("id") String id,String message,Session session)
	{

		JSONObject json = JSONObject.fromObject(message);

		json.put("data", DATE_FORMAT.format(new Date()));
		json.put("number", ONLIN_COUNT);
		
		//Ⱥ����Ϣ
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
		//�ر�����
		webSocketSet.remove(this);
		subOnlineCount();
		System.out.println("�ر�����");
	}
	
	@OnError
	public void OnError(Throwable t)
	{
		//�׳�������Ϣ
	}
	
    public static synchronized void addOnlineCount() {  
    	WebSocketChat.ONLIN_COUNT++;  
    }  
  
    public static synchronized void subOnlineCount() {  
    	WebSocketChat.ONLIN_COUNT--;  
    }
}
