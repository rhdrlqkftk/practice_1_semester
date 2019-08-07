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

public class ServerChat {

	public static void main(String[] args) {
		ServerChat server = new ServerChat(); 
		server.go();
	}
	static String ip = "127.0.0.1"; // 자기 자신 
	static int port = 9576;
	ServerSocket ss; 
	
	public void go()
	{
		BufferedReader br= null; 
		try
		{
			ss = new ServerSocket(port);
			ss.setReuseAddress(true);
			System.out.println("1. Ready Server Socket");
			while(true)
			{
				Socket s = ss.accept(); 
				System.out.println("2. "+ s.getRemoteSocketAddress()+ "Accept! ");
				// 소켓을 읽어온다. 
				
				br = new BufferedReader
						(new InputStreamReader(s.getInputStream()));
				// stream을 er로 
				String msg= " ";
				while( (msg= br.readLine())!=null)
				{
					System.out.println(msg);
				}
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

