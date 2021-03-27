package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class Server extends Thread{
	
	private Main ref;
	
	public void run () {
		
			try {
				ServerSocket server = new ServerSocket(5000);
				System.out.println("Esperando cliente...");
				Socket socket = server.accept();
				System.out.println("Cliente esta conectado");

				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader breader = new BufferedReader(isr);

				while (true) {
					
					System.out.println("Esperando mensaje...");
					String mensajeRecibido = breader.readLine();
					System.out.println(mensajeRecibido);
					
					//se hace la deserializacion del mensaje recibido
					
					Gson gson = new Gson();
					
					Recordatorio mensajeEnviado = gson.fromJson(mensajeRecibido, Recordatorio.class);
					//para diferenciar cuando el usuario mando vista o confirmacion
					if(mensajeEnviado.getConfirmacion().contentEquals("vista")) {
					ref.addVista(mensajeEnviado);
					}
					if(mensajeEnviado.getConfirmacion().contentEquals("confirmar")) {
						ref.addMensaje(mensajeEnviado);
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	public void setMain(Main main) {
		this.ref =  main;
		
	}
	
}