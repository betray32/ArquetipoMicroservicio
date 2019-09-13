package cl.poc.microservicio.rest;

import org.apache.camel.ProducerTemplate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

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
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(CamelRestExposer.class);

	/**
	 * producerTemplate
	 */
	@Autowired
	private ProducerTemplate producerTemplate;

	/**
	 * camelGetExample
	 */
	@GetMapping(value = "CamelGet")
	@ResponseBody
	public Employee camelGetExample() {

		log.info("------------------------------------------------------------");
		log.info("Se ha iniciado una solicitud hacia el metodo [CamelGet]");

		Employee salida = producerTemplate.requestBody("direct:consultarGET", null, Employee.class);

		log.info("Se ha finalizado una solicitud hacia el metodo [CamelGet]");
		log.info("[RESPONSE] = " + new Gson().toJson(salida));
		log.info("------------------------------------------------------------");

		return salida;

	}

}
