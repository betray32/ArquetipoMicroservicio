package cl.poc.microservicio.rest;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Configuracion de las rutas de camel
 * 
 * @author ccontrerasc
 *
 */
@Component
public class RutasCamel extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:endpointCamel").log("Camel body: ${body}");
	}

}