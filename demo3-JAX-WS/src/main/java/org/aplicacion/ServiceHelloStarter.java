package org.aplicacion;

import javax.xml.ws.Endpoint;

import org.ws.HandlerChainWS;
import org.ws.HelloImpl;

public class ServiceHelloStarter {
	final static String URL_HELLO = "http://localhost:8001/hello";
	final static String URL_HANDLER_CHAIN = "http://localhost:8001/Handler";

	public static void main(String[] args) {
		Endpoint.publish(URL_HELLO, new HelloImpl());
		Endpoint.publish(URL_HANDLER_CHAIN, new HandlerChainWS());
		System.out.println("Service web démarre url " + URL_HELLO);
	}
}
