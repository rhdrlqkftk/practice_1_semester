package com.ssafy.edu.j001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//Client는 키보드로 부터 인풋과 소켓으로의 아웃풋이 필요하다. 

public class ClientChat {

	public static void main(String[] args) {
		ClientChat client = new ClientChat (); 
		client.go();
	}
	static String ip = "192.168.208.51";
	static int port = 9575;
	Socket s; 
	BufferedReader  br;
	public void go() 
	{
		// 멤버는 반드시 초기화해야한다. 
		Socket s = null; 
		BufferedReader  br= null;
		PrintWriter pw= null; 
		try 
		{
			s= new Socket(ip, port); // server에서는 이게 어셉트 
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter( 
					new OutputStreamWriter(s.getOutputStream()), true);
			String msg= "";
			while((msg= br.readLine()) != null)
			{
				System.out.println(msg);
				pw.println(msg);
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
