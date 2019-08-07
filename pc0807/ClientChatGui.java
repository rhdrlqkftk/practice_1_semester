package com.ssafy.edu.j001;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
public class ClientChatGui extends JFrame 
{
	class MyWindow implements WindowListener  // 구현 안하면 추상이 됨, 추상은 객체를 못만든다 주의
	{

		@Override
		public void windowOpened(WindowEvent e) {
		
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public ClientChatGui()
	{
		jinit(); 
		jevent();
	}
	private void jinit()
	{
		this.setTitle("A-Hyeon Chat ver0.1 made by Oppa.");
		this.setSize(600, 700);
		this.setVisible(true);
		
	}
	private void jevent()
	{
		//두개를 동시에 죽여.  // 핸들러를 만드는 방법은 7가지가 있다. 
		this.addWindowListener(new MyWindow()); // X-> closing
		// 패턴 배웠다. 
	}	
	public static void main(String[] args) 
	{
		ClientChatGui gui = new ClientChatGui(); 
		
	}
	
	
}
