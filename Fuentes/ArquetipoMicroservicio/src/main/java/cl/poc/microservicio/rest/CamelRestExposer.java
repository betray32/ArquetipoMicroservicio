package cl.poc.microservicio.rest;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.poc.microservicio.bean.Employee;

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
	 * camelGetExample
	 */
	@GetMapping(value = "Camel")
	@ResponseBody
	public Employee camelGetExample() {
		return producerTemplate.requestBody("direct:consultarGET", null, Employee.class); 
	}

}
