package mx.com.gnp.plus.consultasinies.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;

import gnp.ae.distribucion.AqCabeceraArquitectura;
import gnp.si.servidor.Kcili701;
import gnp.si.servidor.Kcilv701;
import gnp.si.servidor.Ksilil06;
import gnp.si.servidor.Ksilvl06;
import mx.com.gnp.plus.consultasinies.exception.ExceptionEot;
import mx.com.gnp.plus.consultasinies.model.ConsultaDocumentosSiniestrosRequest;
import mx.com.gnp.plus.consultasinies.model.ConsultaDocumentosSiniestrosResponse;
import mx.com.gnp.plus.consultasinies.model.ConsultaSiniestrosRequest;
import mx.com.gnp.plus.consultasinies.model.ConsultaSiniestrosResponse;


/**
 * The Class Mappers.
 */
public final class Mappers {
	
	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(Mappers.class);
	
	/** Idioma de la aplicacion. */ 

	private static final String IDIOMA = "ES";
	
	/** La aplicacion. */ 

	private static final String APLICACION = "AE";
	
	
	/**
	 * Instantiates a new mappers.
	 */
	private Mappers() {
	}
	
	/**
	 * Creates the ksilil06.
	 *
	 * @param msgEntrada el mensaje de a procesar
	 * @return ksilil06 el mensaje de regreso
	 */
	public static Ksilil06 consultaSiniestrosRequest(final ConsultaSiniestrosRequest msgEntrada) {
		Ksilil06 respuesta;
		respuesta = new Ksilil06();
		respuesta.setCdnumpol(msgEntrada.getCdnumpol());
		respuesta.setCdtipusu(msgEntrada.getCdtipusu());
		respuesta.setInsaneam(msgEntrada.getInsaneam());
		respuesta.setFeocusin(msgEntrada.getFeocusin());
		complementaCabecera(respuesta.getCabeceraArquitectura());
		return respuesta;
		}
	


	/**
	 * Creates the response consultar siniestros por poliza.
	 * @param msgVta el mensaje a procesar
	 * @return respuesta el mapeo del mensaje procesado 
	 * @throws ExceptionEot the exception eot
	 */
	
	
	public static ConsultaSiniestrosResponse consultaSiniestrosResponse(final Ksilvl06 msgVta) throws ExceptionEot {
		ConsultaSiniestrosResponse respuesta;
		respuesta = new ConsultaSiniestrosResponse();
		int resul = Short.compare(ConstantesGenerales.OK, msgVta.getCderror());
		if (resul == 0) {
			for (int i = 0; i < msgVta.getNuocurre(); i++) {
				respuesta.getEstrgres()[i].setCdnumpol(msgVta.getEstrgsib()[i].getCdnumpol());
				respuesta.getEstrgres()[i].setDntomseg(msgVta.getEstrgsib()[i].getDntomseg());
				respuesta.getEstrgres()[i].setNoproduc(msgVta.getEstrgsib()[i].getNoproduc());
				respuesta.getEstrgres()[i].setCdsinies(msgVta.getEstrgsib()[i].getCdsinies());
				respuesta.getEstrgres()[i].setFeocusin(msgVta.getEstrgsib()[i].getFeocusin());
				respuesta.getEstrgres()[i].setFecomuni(msgVta.getEstrgsib()[i].getFecomuni());
				respuesta.getEstrgres()[i].setTcsitsin(msgVta.getEstrgsib()[i].getTcsitsin());
				respuesta.getEstrgres()[i].setCdtipacc(msgVta.getEstrgsib()[i].getCdtipacc());
			}
		} else {
			LOG.error("ERROR EN RESPUESTA DE INFO");
			LOG.error("Cderror: " + msgVta.getCderror());
			LOG.error("Dsdareg: " + msgVta.getDsarg1() + " "  
			                      +  msgVta.getDsarg2() + " "  
					              +  msgVta.getDsarg3());
			throw new ExceptionEot(
					"Error en INFO, descripcion "   
			          + msgVta.getDsarg1()  + " "
			          + msgVta.getDsarg2()  + " "
                      + msgVta.getDsarg3()  + " "
			          + msgVta.getCderror() ,
					HttpStatus.BAD_REQUEST);
		}

		return respuesta;
	}	
	
	
/***********************************************************************************************
 * Objetivo :Mapear los datos del request a la idl's de entrada al programa KCILM701.
 * @param msgEntrada los datos del request
 * @return respuesta LA idl de vuelta 
 * @throws ExceptionEot the exception eot
 **********************************************************************************************/
	public static Kcili701 consultaDocumentosSiniestrosRequest(final ConsultaDocumentosSiniestrosRequest msgEntrada) {
		Kcili701 respuesta;
		respuesta = new Kcili701();
		respuesta.getCriterio().setTiclave(msgEntrada.getTiclave());
		respuesta.getCriterio().setCdclave1(msgEntrada.getCdclave1());
		complementaCabecera(respuesta.getCabeceraArquitectura());
		return respuesta;
		}
	
	/***********************************************************************************************
	 * Objetivo :Mapear los datos del request a la idl's de regreso del programa KCILM701.
	 * @param msgVta los datos del response
	 * @return respuesta la idl de vuelta 
	 * @throws ExceptionEot the exception eot
	 **********************************************************************************************/

	public static ConsultaDocumentosSiniestrosResponse 
	              consultaDocumentosSiniestrosResponse(final Kcilv701 msgVta) throws ExceptionEot {
		ConsultaDocumentosSiniestrosResponse respuesta;
		respuesta = new ConsultaDocumentosSiniestrosResponse();
		int resul = Short.compare(ConstantesGenerales.OK, msgVta.getCderror());
		if (resul == 0) {
			for (int i = 0; i < msgVta.getNuocurre(); i++) {
			}
		} else {
			LOG.error("ERROR EN RESPUESTA DE INFO");
			LOG.error("Cderror: " + msgVta.getCderror());
			LOG.error("Dsdareg: " + msgVta.getDsarg1() + " "  
			                      +  msgVta.getDsarg2() + " "  
					              +  msgVta.getDsarg3());
			throw new ExceptionEot(
					"Error en INFO, descripcion "   
			          + msgVta.getDsarg1()  + " "
			          + msgVta.getDsarg2()  + " "
                      + msgVta.getDsarg3()  + " "
			          + msgVta.getCderror() ,
					HttpStatus.BAD_REQUEST);
		}

		return respuesta;
	}	

	
/**
 * Objetivo: Poner el idioma y la aplicacion asociada a la transaccion.
 * @param cabeceraArquitectura cabecera a complementar
 * @throws ExceptionEot the exception eot
 */
    public static void complementaCabecera(final AqCabeceraArquitectura cabeceraArquitectura) {
            cabeceraArquitectura.setCdidioma(IDIOMA);
            cabeceraArquitectura.setCdaplic(APLICACION);
    }

}
