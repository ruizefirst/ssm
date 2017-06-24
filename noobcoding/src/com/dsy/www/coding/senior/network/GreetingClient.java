package com.dsy.www.coding.senior.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 13, 2017 4:56:43 PM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @parameter
 * @since  
 * @return
 * 
 **/
public class GreetingClient {
	public static void main(String args[]){
		//String serverName = args[0];
		//int port = Integer.parseInt(args[1]);
		String serverName = "localhost";
	    int port = Integer.parseInt("6066");
		try{
			System.out.println("Connecting to "+serverName+"on port "+port);
			Socket client =	new Socket(serverName,port);
			System.out.println("Just connected to"+client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF("Hello from "+client.getLocalSocketAddress());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			System.out.println("Server says "+in.readUTF());
			client.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}

