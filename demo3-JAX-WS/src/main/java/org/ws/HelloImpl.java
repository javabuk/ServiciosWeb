package org.ws;

import java.time.Instant;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Holder;

//@WebService(endpointInterface = "org.ws.IHello", serviceName = "NombreServicioWeb2", portName = "NombrePuerto", targetNamespace = "http://superbiz.org/wsdl", name = "NOMBRE_JORGE")
@WebService
// @Addressing(enabled = true, required = false, responses = Responses.ALL)
// @Action(input = "http://examples/HelloWorld/sayHelloWorldRequest", output =
// "http://examples/HelloWorld/sayHelloWorldResponse")
public class HelloImpl implements IHello {

	@WebMethod(operationName = "NombreMetodo", action = "AccionJorge")
	@WebResult(name = "Resultado")
	public String say(@WebParam(name = "NombreParametro") final String name) {
		System.out.println("@ " + Instant.now() + " retourne Hello " + name);
		return "Hello " + name;
	}

	/**
	 * Servicio web que devuelve el resultado en la cabecera (header)
	 * 
	 * @param name
	 * @return
	 */
	@WebMethod(operationName = "NombreSegundoMetodo", action = "AccionSegundoMetodo")
	@WebResult(name = "ResultadoSegundoMetodo", header = true)
	public String segundoMetodo(@WebParam(name = "OtroNombreParametro") final String name) {
		System.out.println("@ " + Instant.now() + " retourne Hello " + name);
		return "Hello " + name;
	}

	@WebMethod(operationName = "parametroHeader", action = "AccionSegundoMetdod")
	@WebResult(name = "ResultadoMetodoParametroHeader")
	public String parametroHeader(
			@WebParam(name = "ParametroHeader", header = true, mode = Mode.IN) final String name) {
		System.out.println("@ " + Instant.now() + " devolvemos resultado " + name);
		return "Hello " + name;
	}

	/**
	 * Metodo con un parametro en cabecera y otro normal (body)
	 * 
	 * @param name
	 * @param body
	 * @return
	 */
	@WebMethod(operationName = "parametrosDual", action = "AccionDual")
	@WebResult(name = "ResultadoMetodoParametroDual", header = false)
	public String parametrosDuales(@WebParam(name = "ParametroHeader", header = true, mode = Mode.IN) final String name,
			@WebParam(name = "ParametroBody", header = false) final String body) {
		System.out.println("@ " + Instant.now() + " devolvemos resultado " + name);
		return "Hello " + name;
	}

	/**
	 * Servicio que devuelve mas de un valor por llamada, con el parametro OUT
	 * 
	 * @param body
	 * @param devuelto
	 * @return
	 */
	public String parametrosDualesDos(@WebParam(name = "ParametroBody", header = false) final String body,
			@WebParam(name = "ParametroDevuelto", mode = Mode.OUT) Holder<String> devuelto) {
		devuelto.value = body + " HOLDER";
		return "Hello " + body;
	}
}
