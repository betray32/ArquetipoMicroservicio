package cl.poc.microservicio.rest;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CamelRestExposer
 * 
 * @author ccontrerasc
 *
 */
@RestController
public class CamelRestExposer {

	/**
	 * producerTemplate
	 */
	@Autowired
	private ProducerTemplate producerTemplate;

	/**
	 * startCamel
	 */
	@GetMapping(value = "Camel")
	public void startCamel() {
		producerTemplate.sendBody("direct:endpointCamel", "Invocando desde Spring Boot Rest > CAMEL");
	}

}
