package com.ssafy.edu.j001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChatThread extends Thread {

	ServerChat4 serverChat4;
	Socket s; 
	BufferedReader br= null; 
	PrintWriter pw = null; 
	public ServerChatThread(ServerChat4 serverChat4, Socket s) {
		this.serverChat4 = serverChat4;
		this.s =s; 
		
	}
	@Override
	public void run() {
		
		String msg= " ";
		try {
			while( (msg= br.readLine())!=null)
			{
				// 클라이언트로 보낸다. 
				serverChat4.broadcast(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(s.getInetAddress()+"가 종료되었습니다");
			e.printStackTrace();
		}
		finally
		{
			
			if( pw!=null)
			{
				pw.close();
			}
			if( s!=null)
			{
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void sendMessaage(String msg) {
		
		
		pw.println("[ "+ msg + "]");
	}

}
