package main;

import java.util.ArrayList;

import processing.core.PApplet;

public class Main extends PApplet {
	int posX = -1000, posY = -1000;
	String importancia = "verde", mensaje= "hola", confirmacion="vista";
	ArrayList<Recordatorio> userMensajes;
	private Server conexion;
	boolean llegoMensaje;
	boolean llegoMensajeView;
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
		//aquí se hace la conexion con el cliente
		conexion = new Server();
		conexion.setMain(this);
		conexion.start();
		//un arreglo para los mensajes que agrega el usuario con "confirmar"
		userMensajes = new ArrayList<Recordatorio>();
		
		}

	public void addVista(Recordatorio mensajeEnviado) {
		
		System.out.println(mensajeEnviado.getMensaje());

		posX = mensajeEnviado.getPosx();
		posY = mensajeEnviado.getPosy();
		mensaje = mensajeEnviado.getMensaje();
		importancia = mensajeEnviado.getImportancia();
		confirmacion = mensajeEnviado.getConfirmacion();
		/*if(confirmacion == "vista") {
			llegoMensajeView = false;
			System.out.println("holi");
		}*/
		llegoMensajeView = true;
		System.out.println(confirmacion);

	}
 public void addMensaje(Recordatorio mensajeEnviado) {
		
		System.out.println(mensajeEnviado.getMensaje());

		posX = mensajeEnviado.getPosx();
		posY = mensajeEnviado.getPosy();
		mensaje = mensajeEnviado.getMensaje();
		importancia = mensajeEnviado.getImportancia();
		confirmacion = mensajeEnviado.getConfirmacion();
		//aqui se agrega un mensaje cada que el usuario oprima confirmar
		userMensajes.add(new Recordatorio(posX,posY,mensaje,importancia,confirmacion));
		llegoMensaje = true;
		System.out.println(confirmacion);

	}

	public void draw() {

		background(255, 255, 255);
		//esto es en caso de que el string recibido sea "vista"
		if(llegoMensajeView == true) {
			
			switch(importancia) {
			case "verde":
				fill(0,255,0);
				ellipse(posX,posY,20,20);
				fill(0,0,0);
				text(mensaje,posX-20,posY+20);
				break;
			case "amarillo":
				fill(255,255,0);
				ellipse(posX,posY,20,20);
				fill(0,0,0);
				text(mensaje,posX-20,posY+20);
				break;
			case "rojo":
				fill(255,0,0);
				ellipse(posX,posY,20,20);
				fill(0,0,0);
				text(mensaje,posX-20,posY+20);
				break;
			}
		}
			
			//este es en caso de que el string recibido sea "confirmar"
			if(llegoMensaje == true) {
				for (int i = 0; i < userMensajes.size(); i++) {
					//i = userMensajes[i];
					posX = userMensajes.get(i).getPosx();
					posY = userMensajes.get(i).getPosy();
					mensaje = userMensajes.get(i).getMensaje();
					importancia = userMensajes.get(i).getImportancia();
					//aquí se diferencia el color que oprimió el usuario para su recordatorio
					switch(importancia) {
					case "verde":
						fill(0,255,0);
						ellipse(posX,posY,20,20);
						fill(0,0,0);
						text(mensaje,posX-20,posY+20);
						break;
					case "amarillo":
						fill(255,255,0);
						ellipse(posX,posY,20,20);
						fill(0,0,0);
						text(mensaje,posX-20,posY+20);
						break;
					case "rojo":
						fill(255,0,0);
						ellipse(posX,posY,20,20);
						fill(0,0,0);
						text(mensaje,posX-20,posY+20);
						break;
					}
				}
		}
	}
}
