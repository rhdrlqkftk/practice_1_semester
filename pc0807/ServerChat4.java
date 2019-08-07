package com.ssafy.edu.j001;
import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

import javax.print.attribute.standard.PrinterResolution;
//3단계 작업장( Thread)를 만들어서 보내고 받음.
public class ServerChat4 {

	public static void main(String[] args) {
		ServerChat4 server = new ServerChat4(); 
		server.go();
	}
	static String ip = "127.0.0.1"; // 자기 자신 
	static int port = 9576;
	ServerSocket ss; 
	Vector<ServerChatThread> room = new Vector<>(); 
//	List<ServerChatThread> room = Collections.synchronizedList(new ArrayList<ServerChatThread>());
	// 벡터 . 어레이 리스트보다 6배 느리다. 
	// 벡터 < 어레이 리스트 < 링크드 리스트 ( 가장 빠름 ) 
	public synchronized void add(ServerChatThread t)
	{
		room.add(t);
	}
	public synchronized void remove(ServerChatThread t)
	{
		room.remove(t);
	}
	// 다른 일 못하게 묶었다 . 
	public synchronized void broadcast(String msg)
	{
		for( ServerChatThread st : room)
		{
			st.sendMessaage(msg);
		}
	}
	public void go()
	{
		try
		{
			ss = new ServerSocket(port);
			ss.setReuseAddress(true);
			System.out.println("1. Ready Server Socket");
			while(true)
			{
				Socket s = ss.accept(); 
				ServerChatThread ct = new ServerChatThread(this, s);
				ct.start(); 
				add(ct);
			}
		}
		catch( IOException e)
		{
			System.out.println(e);
		}
		finally
		{
		
			if( ss != null)
			{
				try {
					ss.close(); // 이거는 왜 예외가 뜨는거지? 
					System.out.println("socket end");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

