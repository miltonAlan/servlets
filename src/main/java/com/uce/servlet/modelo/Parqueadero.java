package com.uce.servlet.modelo;

import java.io.Serializable;

public class Parqueadero implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre_usuario;
	private String tipo_vehiculo;
	private String tiempo;
	private String placa;
	private String color;
	private String marca;
	private String descripcion_adicional;

	public String getDescripcion_adicional() {
		return this.descripcion_adicional;
	}

	public void setDescripcion_adicional(String descripcion_adicional) {
		this.descripcion_adicional = descripcion_adicional;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getTipo_vehiculo() {
		return tipo_vehiculo;
	}

	public void setTipo_vehiculo(String tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	
}