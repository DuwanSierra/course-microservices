package com.jeffdev.microservicegatewayserver.filters.factory;

public final class Configuration {
	
	private String mensaje;
	private String cookieValor;
	private String cookieNombre;
	
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getCookieValor() {
		return cookieValor;
	}
	public void setCookieValor(String cookieValor) {
		this.cookieValor = cookieValor;
	}
	public String getCookieNombre() {
		return cookieNombre;
	}
	public void setCookieNombre(String cookieNombre) {
		this.cookieNombre = cookieNombre;
	}
	
	
}
