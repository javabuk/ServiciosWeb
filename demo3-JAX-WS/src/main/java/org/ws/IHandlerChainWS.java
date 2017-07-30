package org.ws;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(portName = "PortNameChandlerChain")
@SOAPBinding(style = Style.DOCUMENT)
public interface IHandlerChainWS {

	public String devolverTexto(String texto);

}
