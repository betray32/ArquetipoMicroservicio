package cl.poc.microservicio.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import cl.poc.microservicio.bean.ClienteBean;
import cl.poc.microservicio.delegate.ClienteDelegate;

/**
 * Expositor de cliente rest para el cliente
 * 
 * @author ccontrerasc
 *
 */
@RestController
public class ClienteRestExposer {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(ClienteRestExposer.class);

	@Autowired
	private ClienteDelegate delegate;

	/**
	 * Ejemplo de endpoint con metodo GET, recibe de entrada un rut y lo despliega
	 * de salida
	 * 
	 * @param rut
	 * @return
	 */
	@RequestMapping(value = "/obtener", method = RequestMethod.GET)
	@ResponseBody
	public ClienteBean obtenerCliente(@RequestParam(value = "rut", defaultValue = "51266633") String rut) {

		log.info("------------------------------------------------------------");
		log.info("Se ha iniciado una solicitud hacia el metodo [obtenerCliente]");
		log.info("[REQUEST] RUT = " + rut);

		ClienteBean salida = delegate.obtenerCliente(rut);

		log.info("Se ha finalizado una solicitud hacia el metodo [obtenerCliente]");
		log.info("[RESPONSE]" + new Gson().toJson(salida));
		log.info("------------------------------------------------------------");

		return salida;
	}

}
