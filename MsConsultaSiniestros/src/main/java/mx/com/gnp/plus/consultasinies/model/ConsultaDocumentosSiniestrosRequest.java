package mx.com.gnp.plus.consultasinies.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;




/***********************************************************************************************
 *                  Clase para realizar la peticion de los documentos asociado a el            *
 *                                      Siniestro.                                             * 
 *                                                                                             *
 **********************************************************************************************/

public class ConsultaDocumentosSiniestrosRequest implements Serializable{

    /** La constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** Propiedad tipo de busqueda. */
	private static final String TIPO_CLAVE_PROPERTY = "Tipo de clave.";
	/** El Tipo de busqueda no nulo. */
	private static final String TIPO_CLAVE_NOT_NULL = "Por favor, ingrese el tipo de clave.";
	/** Propiedad tipo de busqueda. */
	private static final String CLAVE_PROPERTY = "Clave.";
	/** El Tipo de busqueda no nulo. */
	private static final String CLAVE_NOT_NULL = "Por favor, ingrese la clave.";

	
	
	/** Tipo de busqueda (Por Siniestro). */
	@NotNull(message = TIPO_CLAVE_NOT_NULL)	
	@ApiModelProperty(value = TIPO_CLAVE_PROPERTY, required = true)
	private  String ticlave;

	/** LLave de la busqueda (Siniestro). */
	@NotNull(message = CLAVE_NOT_NULL)	
	@ApiModelProperty(value = CLAVE_PROPERTY, required = true)
    private String cdclave1;

	/***********************************************************************************************
	 *                                Constructor.                                                 *   	
	 *                                                                                             *
	 **********************************************************************************************/
	
	public ConsultaDocumentosSiniestrosRequest() {
		ticlave="";
		cdclave1="";
	}

	/**
	 * Gets el tipo de clave. 
	 *
	 * @return ticlave
	 */
	
	public String getTiclave() {
		return ticlave;
	}

	/**
	 * Sets el tipo de clave. 
	 *
	 * @param ticlave
	 */
	
	public void setTiclave(String ticlave) {
		this.ticlave = ticlave;
	}

	/**
	 * Gets la clave.
	 *
	 * @return cdclave1
	 */
	
	public String getCdclave1() {
		return cdclave1;
	}

	/**
	 * Sets la clave.
	 *
	 * @param cdclave1 
	 */
	
	public void setCdclave1(String cdclave1) {
		this.cdclave1 = cdclave1;
	}
}
