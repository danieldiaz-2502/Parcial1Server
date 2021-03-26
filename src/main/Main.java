package main;

import java.util.ArrayList;

import processing.core.PApplet;

public class Main extends PApplet {
	int posX, posY;
	String importancia, mensaje, confirmacion;
	ArrayList<Recordatorio> userMensajes;
	private Server conexion;
	boolean llegoMensaje;
	Recordatorio reco;
	PApplet app;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("main.Main");
	}

	public void settings() {
		size(700, 500);
	}

	public void setup() {

		conexion = new Server();
		conexion.setMain(this);
		conexion.start();
		
		userMensajes = new ArrayList<Recordatorio>();
		
		}

	public void addMensaje(Recordatorio mensajeEnviado) {
		
		System.out.println(mensajeEnviado.getMensaje());

		posX = mensajeEnviado.getPosx();
		posY = mensajeEnviado.getPosy();
		mensaje = mensajeEnviado.getMensaje();
		importancia = mensajeEnviado.getImportancia();
		confirmacion = mensajeEnviado.getConfirmacion();
		if(confirmacion == "confirmar") {
		userMensajes.add(new Recordatorio(posX,posY,mensaje,importancia,confirmacion));
		llegoMensaje= true;
		}

	}

	public void draw() {

		background(255, 255, 255);
			for (int i = 0; i < userMensajes.size(); i++) {
				
				//i = userMensajes[i];
				int posicionx = userMensajes.get(i).getPosx();
				int posiciony = userMensajes.get(i).getPosy();
				String mensaje = userMensajes.get(i).getMensaje();
				String importancia = userMensajes.get(i).getImportancia();
				
				switch(importancia) {
				case "verde":
					fill(0,255,0);
					ellipse(posicionx,posiciony,20,20);
					fill(0,0,0);
					text(mensaje,posicionx-20,posiciony+20);
					break;
				case "amarillo":
					fill(255,255,0);
					ellipse(posicionx,posiciony,20,20);
					fill(0,0,0);
					text(mensaje,posicionx-20,posiciony+20);
					break;
				case "rojo":
					fill(255,0,0);
					ellipse(posicionx,posiciony,20,20);
					fill(0,0,0);
					text(mensaje,posicionx-20,posiciony+20);
					break;
				}
	}
	}
}
