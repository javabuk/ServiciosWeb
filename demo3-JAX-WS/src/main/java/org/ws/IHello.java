package org.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(portName = "PortNameInterface")
@SOAPBinding(style = Style.DOCUMENT)
public interface IHello {
	@WebMethod
	String say(@WebParam(name = "nom") final String name);
}
