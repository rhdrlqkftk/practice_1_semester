package com.ssafy.edu.j001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

//서버챗 3번
public class ServerThread extends Thread {

	Socket s; 
	BufferedReader br= null; 
	PrintWriter pw = null; 
	
	public ServerThread ( Socket s)
	{
		this.s = s; 		
		System.out.println("2. "+ s.getRemoteSocketAddress()+ "Accept! ");
		// 소켓을 읽어온다. 
		
		try {
			br = new BufferedReader
					(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if( pw != null)
			{
				pw.close();
			}
			if(s!=null)
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
	
	@Override
	public void run() {

		String msg= " ";
		try {
			while( (msg= br.readLine())!=null)
			{
				// 클라이언트로 보낸다. 
				System.out.println(msg);
				pw.println("[ "+ msg + "]");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
