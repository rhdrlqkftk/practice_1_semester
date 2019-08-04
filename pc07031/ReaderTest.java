package com.ssafy.edu.f002;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class ReaderTest {

	public static void main(String[] args) {
		BufferedReader br=null;
		PrintWriter pw=null;
		String fname="joo.txt";
		String msg="";
		
		try {
			br=new BufferedReader(new InputStreamReader(System.in, 
					"UTF-8"));
			pw=new PrintWriter(new FileWriter(fname,true)
					,true);
			while((msg=br.readLine())!=null) { //EOF ->ctrl+c =>ctrl+z
				//System.out.println(msg);
				pw.println(msg);
			}
		}catch (UnsupportedEncodingException e) {
			System.out.println(e);
		}catch (IOException e) {
			System.out.println(e);
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			if(pw!=null)pw.close();
			System.out.println("End~~~");
		}

	}

}
