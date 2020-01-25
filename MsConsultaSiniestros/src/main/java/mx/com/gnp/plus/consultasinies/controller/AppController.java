package mx.com.gnp.plus.consultasinies.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import gnp.si.servidor.Kcilv701;
import gnp.si.servidor.Ksilvl06;
import lombok.extern.slf4j.Slf4j;
import mx.com.gnp.plus.consultasinies.exception.ExceptionEot;
import mx.com.gnp.plus.consultasinies.model.ConsultaDocumentosSiniestrosRequest;
import mx.com.gnp.plus.consultasinies.model.ConsultaDocumentosSiniestrosResponse;
import mx.com.gnp.plus.consultasinies.model.ConsultaSiniestrosRequest;
import mx.com.gnp.plus.consultasinies.model.ConsultaSiniestrosResponse;
import mx.com.gnp.plus.consultasinies.services.TransaccionInfoService;
import mx.com.gnp.plus.consultasinies.utils.Mappers;


/**
 * Clase controller para aplicación microservicio java.
 * 
 * @author jsetien
 *
 */
@RestController
@Slf4j

public class AppController  implements ConsultaSiniestrosApi {

	/** La variable para implementar el LOG. */

	public static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(AppController.class);

	/** The service. */
	@Autowired
	private TransaccionInfoService service;
	
	/**

	/**
	 * Consulta los siniestros asociados a la poliza.
	 *
	 * @param request the request
	 * @return the response entity
	 * @throws ExceptionEot the exception eot
	 */
	
@Override
	public final ResponseEntity<ConsultaSiniestrosResponse> consultaSiniestrosporPoliza(
			@Valid @ModelAttribute final ConsultaSiniestrosRequest request) throws ExceptionEot {  

			Ksilvl06 respuesta = service.callKsilml06(Mappers.consultaSiniestrosRequest(request));
			
			ConsultaSiniestrosResponse response = Mappers.consultaSiniestrosResponse(respuesta);
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		
	}	

/***********************************************************************************************
 * Objetivo : Consultar los documentos asociados al Siniestro.
 * @param msgVta el mensaje a procesar
 * @return respuesta el mapeo del mensaje procesado 
 * @throws ExceptionEot the exception eot
 **********************************************************************************************/
@Override
public final ResponseEntity<ConsultaDocumentosSiniestrosResponse> consultaDocumentosSiniestros(
		@Valid @ModelAttribute final ConsultaDocumentosSiniestrosRequest request) throws ExceptionEot {  

		Kcilv701 respuesta = service.consultaDocumentosSiniestros(Mappers.consultaDocumentosSiniestrosRequest(request));
		
		ConsultaDocumentosSiniestrosResponse response = Mappers.consultaDocumentosSiniestrosResponse(respuesta);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	
}	
	
}
