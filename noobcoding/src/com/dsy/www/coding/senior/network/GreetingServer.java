package com.dsy.www.coding.senior.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 13, 2017 5:05:59 PM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @parameter
 * @since  
 * @return
 * 
 **/
public class GreetingServer extends Thread{
	private ServerSocket serverSocket;
	public GreetingServer(int port) throws IOException {
		serverSocket  = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}
	
	public void run(){
		while(true){
			try{
				System.out.println("Waiting for client on port "+serverSocket.getLocalPort()+"...");
				Socket server = serverSocket.accept();
				System.out.println("Just connected to "+server.getRemoteSocketAddress());
				DataInputStream  in = new DataInputStream(server.getInputStream());
				System.out.println(in.readUTF());
				DataOutputStream  out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("Thank you for connecting to "+server.getLocalSocketAddress()+"\nGoodbye");
				server.close();
			}catch(SocketTimeoutException e){
				System.out.println("Socket times out!");
				break;
			}catch(IOException e){
				e.printStackTrace();
				break;
			}
		}
	}
	
	public static void main(String[] args){
		int port  = Integer.parseInt("6066");
		try{
			Thread t = new GreetingServer(port);
			t.start();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}

