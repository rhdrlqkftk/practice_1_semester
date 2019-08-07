package com.ssafy.edu.j001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

// Chart 4와 연관
public class Client4Thread extends Thread {

	Socket s = null; 
	BufferedReader  sbr= null;
	public  Client4Thread (Socket s)
	{
		this.s = s;
		try {
			sbr = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public void run()
	{
		try {
			String msg= " ";
			while( (msg= sbr.readLine())!=null)
			{
				// 클라이언트로 보낸다. 
				System.out.println(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
	}
}
