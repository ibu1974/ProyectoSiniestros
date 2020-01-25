package mx.com.gnp.plus.consultasinies.services;

import gnp.si.servidor.Kcili701;
import gnp.si.servidor.Kcilv701;
import gnp.si.servidor.Ksilil06;
import gnp.si.servidor.Ksilvl06;
import mx.com.gnp.plus.consultasinies.exception.ExceptionEot;


/**
 * The Interface TransaccionInfoService.
 */
public interface TransaccionInfoService {
	
	/**
	 * Call ksilml06.
	 *
	 * @param mensajeIda the mensaje ida
	 * @return the ksilml06
	 * @throws ExceptionEot the exception eot
	 */
	Ksilvl06 callKsilml06(Ksilil06 mensajeIda)throws ExceptionEot;

/***********************************************************************************************
 * Objetivo : Consultar los documentos asociados al Siniestro.
 * @param mensajeIda el mensaje a procesar
 * @throws ExceptionEot the exception eot
 **********************************************************************************************/	

	Kcilv701 consultaDocumentosSiniestros(Kcili701 mensajeIda)throws ExceptionEot;

	

}
