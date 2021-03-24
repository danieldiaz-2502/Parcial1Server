package main;

import processing.core.PApplet;

public class Mensaje{
	int posX, posY;
	String importancia, mensaje,confirmacion;
	PApplet app;
	
	public Mensaje (int posX, int posY, String mensaje, String importancia, String confirmacion, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.mensaje = mensaje;
		this.importancia = importancia;
		this.confirmacion = confirmacion;
		this.app = app;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public String getImportancia() {
		return importancia;
	}

	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(String confirmacion) {
		this.confirmacion = confirmacion;
	}
	
	
	
	
	
}