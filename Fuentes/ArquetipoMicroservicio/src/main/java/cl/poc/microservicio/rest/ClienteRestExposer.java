package cl.poc.microservicio.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.poc.microservicio.bean.ClienteBean;

/**
 * Expositor de cliente rest para el cliente
 * 
 * @author ccontrerasc
 *
 */
@RestController
public class ClienteRestExposer {

	@RequestMapping("/obtener")
	public ClienteBean obtenerCliente() {
		
		ClienteBean cliente = new ClienteBean();
		cliente.setRut("180356681");
		cliente.setNombre("Aquiles Brinco");
		
		return cliente;
	}

}
