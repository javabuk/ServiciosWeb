package org.ws;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService
@HandlerChain(file = "handlers.xml")
public class HandlerChainWS implements IHandlerChainWS {

	@Override
	public String devolverTexto(String texto) {
		return "Prueba Handler Chain " + texto;
	}

}
