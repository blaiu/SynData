/**
 * 
 */
package com.jd.syn.service.utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

import javax.annotation.Resource;

import com.jd.syn.service.mysql.MySQLApplier;

/**
 * @author bailu
 *
 */
public class SocketServer {

	ServerSocket server;
	int port;
	
	@Resource
	private MySQLApplier<Object> mySQLApplier;
	
	public ServerSocket getServer() {
		return server;
	}


	public void setServer(ServerSocket server) {
		this.server = server;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	public void init () {
		 if (null == server) {
			 try {
				server = new ServerSocket(port);
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
	}
	
	
	public void accept () {
		while (true) {  
	         try {
	        	 Socket socket = server.accept();  
				 handleSocket(socket);
				 Writer writer = new OutputStreamWriter(socket.getOutputStream());  
		         writer.write("Hello Client.");  
		         writer.write("eof\n");  
		         writer.flush();  
		         writer.close();  
		         socket.close();
	         } catch (Exception e) {
				e.printStackTrace();
	         }  
	    }
	}
	
	private void handleSocket(Socket socket) {
		
		ObjectInputStream oin = null;
		try {
			oin = new ObjectInputStream(socket.getInputStream());
			mySQLApplier.receiveBeanLog(oin.readObject());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
         
     }  
	
	
}
