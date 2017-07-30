package org.aplicacion;

import javax.xml.ws.Endpoint;

import org.ws.HelloImpl;

public class ServiceHelloStarter {
	final static String URL_HELLO = "http://localhost:8001/hello";

	public static void main(String[] args) {
		Endpoint.publish(URL_HELLO, new HelloImpl());
		System.out.println("Service web démarre url " + URL_HELLO);
	}
}
