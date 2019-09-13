package cl.poc.microservicio.rest;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import cl.poc.microservicio.bean.Employee;

/**
 * Configuracion de las rutas de camel
 * 
 * @author ccontrerasc
 *
 */
@Component
public class RutasCamel extends RouteBuilder {

	/**
	 * Se indican todas las rutinas camel que deseamos
	 */
	@Override
	public void configure() throws Exception {

		/*
		 * Ejemplo de invocacion hacia servicio que posee rutinas
		 */
		from("direct:consultarGET")
				/*
				 * Se indica las cabeceras y tipos a consultar
				 */
				.setHeader(Exchange.HTTP_METHOD, simple(HttpMethod.GET.name()))
				/*
				 * Endpoint de destino a consultar
				 */
				.to("http://localhost:8080/employee?id=5")
				/*
				 * Mediante esto se expresa que se desea obtener la salida como un objeto
				 * complejo deseado como salida
				 */
				.unmarshal(new JacksonDataFormat(Employee.class))
				/*
				 * Procesador, en este caso se toma la salida del endpoint invocado y se setea
				 * como salida de la rutina
				 */
				.process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {
						Employee salida = exchange.getIn().getBody(Employee.class);
						exchange.getOut().setBody(salida);
					}
				})
				/*
				 * Se despliega el contenido obtenido del mensaje
				 */
				.log("Salida Servicio GET > ${body}")
				/*
				 * Se finaliza esta rutina
				 */
				.end();

	}

}