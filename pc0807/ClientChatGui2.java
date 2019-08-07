package com.ssafy.edu.j001;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class ClientChatGui2 extends JFrame 
{
	class MyWindow extends WindowAdapter// 구현 안하면 추상이 됨, 추상은 객체를 못만든다 주의
	{

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	public ClientChatGui2()
	{
		jinit(); 
		jevent();
		jcomponent(); 
	}
	JPanel cp = new JPanel();
	JPanel ccp = new JPanel();
	JTextArea ta = new JTextArea("");
	JPanel csp= new JPanel();
	JPanel csp1= new JPanel();
	JPanel csp2= new JPanel();
	JTextField tf = new JTextField("");
	JButton sb= new JButton("send"); 
	JButton cb= new JButton("clear");
	private void jcomponent() {
		cp = (JPanel)this.getContentPane(); // 벽에 포스트잇 
		cp.setLayout(new BorderLayout());
		cp.add(ccp);
		cp.add(ccp, BorderLayout.CENTER);
		ccp.setLayout(new BorderLayout());
		ccp.add( ta, BorderLayout.CENTER);
		ta.setBackground(new Color(250,223,212));
		ta.setEditable(true);
		//this.add(cp, BorderLayout.CENTER);
		cp.add(csp, BorderLayout.SOUTH);
		csp.setLayout(new GridLayout(2,1,5,5)); //2줄에 1칼람 
		csp.add(csp1);
		csp.add(csp2);
		csp1.setLayout(new BorderLayout());
		csp1.add(tf); 
		csp2.add(sb);
		csp2.add(cb);
	}
	private void jinit()
	{
		this.setTitle("A-Hyeon Chat ver0.1 made by Oppa.");
		this.setSize(600, 700);
		this.setVisible(true);
		
	}
	//귀를 달자. 
	private void clear()
	{
		this.tf.setText("");
		this.tf.requestFocus();
	}
	private void send()
	{
	
		
	}
	private void shows()
	{
		String s = ta.getText(); 
		String t = tf.getText();
		ta.setText("");
		ta.append( t+ "\n" + s); 
		clear();
	}

	private void jevent() 
	{
		//두개를 동시에 죽여.  // 핸들러를 만드는 방법은 7가지가 있다. 
		this.addWindowListener(new MyWindow()); // X-> closing
		this.cb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// cb가 눌리면 클리어 해준다.
				clear();
			}
		});
		this.sb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// cb가 눌리면 클리어 해준다.
				shows();
			}
		});
		// 패턴 배웠다.
	}	
	public static void main(String[] args) 
	{
		ClientChatGui2 gui = new ClientChatGui2(); 
		
	}
	
	
}
