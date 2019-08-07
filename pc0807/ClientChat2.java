package com.ssafy.edu.j001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//Client는 키보드로 부터 인풋과 소켓으로의 아웃풋이 필요하다. 

public class ClientChat2 {

	public static void main(String[] args) {
		ClientChat2 client = new ClientChat2 (); 
		client.go();
	}
	static String ip = "127.0.0.1";
	static int port = 9576;
	Socket s; 
	BufferedReader  br;
	public void go() 
	{
		// 멤버는 반드시 초기화해야한다. 
		Socket s = null; 
		BufferedReader  br= null;
		BufferedReader  sbr= null;
		PrintWriter pw= null; 
		try 
		{
			s= new Socket(ip, port); // server에서는 이게 어셉트 
			br = new BufferedReader(new InputStreamReader(System.in));
			sbr = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter( 
					new OutputStreamWriter(s.getOutputStream()), true);
			String msg= "";
			while((msg= br.readLine()) != null)
			{			
				pw.println(msg);
				System.out.println(sbr.readLine());
			}
		}
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) {
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

}
