package main;

import java.util.ArrayList;

import processing.core.PApplet;

public class Main extends PApplet{
	int posX;
	int posY;
	String importancia, mensaje,confirmacion;
	ArrayList<Mensaje> userMensajes = new ArrayList();
	private Server conexion;
	PApplet app;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("main.Main");
	}
	
	public void settings() {
		size(700,500);
	}
	
	public void setup() {
		
		conexion = new Server();
		conexion.setMain(this);
		conexion.start();
	}
	
	public void addMensaje(Mensaje mensajeEnviado) {
		
		posX = mensajeEnviado.getPosX();
		posY = mensajeEnviado.getPosY();
		mensaje = mensajeEnviado.getMensaje();
		importancia = mensajeEnviado.getImportancia();
		confirmacion = mensajeEnviado.getConfirmacion();
		
	}

	public void draw() {
		
		background(255, 255, 255);
		
		if(confirmacion == "confirmar") {
		for(int i = 0; i < userMensajes.size(); i++) {
			
		}
		}
	}
	

}
