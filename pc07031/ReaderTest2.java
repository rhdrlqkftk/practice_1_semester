package com.ssafy.edu.f002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UTFDataFormatException;
import java.util.Base64.Encoder;

public class ReaderTest2 {

	public static void main(String[] args) {
		BufferedReader br=null;
		br=new BufferedReader(new InputStreamReader(System.in));
		String msg="";
		try {
			while((msg=br.readLine())!=null) { //EOF ->ctrl+c =>ctrl+z
				System.out.println(msg);
			}
		}catch (IOException e) {
			System.out.println(e);
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("End~~~");
		}
	}

}
