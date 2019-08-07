package com.ssafy.edu.j001;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

import javax.print.attribute.standard.PrinterResolution;
//3단계 작업장( Thread)를 만들어서 보내고 받음.
public class ServerChat3 {

	public static void main(String[] args) {
		ServerChat3 server = new ServerChat3(); 
		server.go();
	}
	static String ip = "127.0.0.1"; // 자기 자신 
	static int port = 9576;
	ServerSocket ss; 
	
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
				ServerThread ct= new ServerThread(s);
				ct.start(); 
				
			
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

