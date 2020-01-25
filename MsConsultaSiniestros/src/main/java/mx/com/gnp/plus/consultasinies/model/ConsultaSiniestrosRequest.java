package mx.com.gnp.plus.consultasinies.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * The Class ConsultaSiniestrosRequest.
 */

public class ConsultaSiniestrosRequest implements Serializable {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant NUM_POLIZA_PROPERTY. */
	private static final String NUM_POLIZA_PROPERTY = "Numero de poliza.";
	/** The Constant NUM_POLIZA_NOT_NULL. */
	private static final String NUM_POLIZA_NOT_NULL = "Por favor, ingrese un numero de poliza.";
	/** Contantes para  TIP_USUARIO_PROPERTY. */
	private static final String TIP_USUARIO_PROPERTY = "Tipo de Usuario.";
	/** The Constant TIP_USUARIO_NOT_NULL. */
	private static final String TIP_USUARIO_NOT_NULL = "Por favor, ingrese el tipo de usuario.";
	/** Contantes para  TIP_USUARIO_PROPERTY. */
	private static final String INDICADOR_PROPERTY = "Indicador.";
	/** The Constant TIP_USUARIO_NOT_NULL. */
	private static final String INDICADOR_NOT_NULL = "Por favor, ingrese el indicador.";
	/** Contantes para  FECHA_SINIESTRO_PROPERTY. */
	private static final String FECHA_SINIESTRO_PROPERTY = "Fecha de Siniestros.";
	/** The Constant TIP_USUARIO_NOT_NULL. */
	private static final String FECHA_SINIESTRO_NOT_NULL = "Por favor, ingrese la fecha de inicio de siniestros.";

	
	
	/** Numero de poliza. */
	@NotNull(message = NUM_POLIZA_NOT_NULL)	
	@ApiModelProperty(value = NUM_POLIZA_PROPERTY, required = true)
	private String cdnumpol;
	
	

	/** Tipo de usuario. */
	@NotNull(message = TIP_USUARIO_NOT_NULL)	
	@ApiModelProperty(value = TIP_USUARIO_PROPERTY, required = true)
	private String cdtipusu;

	
	/** Indicador.  */	
	@NotNull(message = INDICADOR_NOT_NULL)	
	@ApiModelProperty(value = INDICADOR_PROPERTY, required = true)
	private String insaneam;

	/** Fecha en que ocurrio el Siniestro. */	
	@NotNull(message = FECHA_SINIESTRO_NOT_NULL)	
	@ApiModelProperty(value = FECHA_SINIESTRO_PROPERTY, required = true)
	private int feocusin;



	/***********************************************************************************************
	 *                                Constructor.                                                 *   	
	 *                                                                                             *
	 **********************************************************************************************/

	public ConsultaSiniestrosRequest() {

		cdnumpol = "";

		cdtipusu = "";

		insaneam = "";
		
		feocusin = 0;

	}

	/**
	 * Gets el numero de poliza.
	 *
	 * @return cdnumpol el numero de poliza
	 */

	public final String getCdnumpol() {
		return cdnumpol;
	}

	/**
	 * Sets the num poliza.
	 *
	 * @param cdnumpol el nuevo numero de poliza
	 */
	public final void  setCdnumpol(final String cdnumpol) {
		this.cdnumpol = cdnumpol;
	}


	/**
	 * Gets el tipo de usuario.
	 *
	 * @return  cdtipusu el tipo de usuario
	 */
	
	public final String getCdtipusu() {
		return cdtipusu;
	}


	/**
	 * Sets the tipo de usuario.
	 *
	 * @param cdtipusu el nuevo tipo de usuario
	 */
	
	public final void setCdtipusu(final String cdtipusu) {
		this.cdtipusu = cdtipusu;
	}


	/**
	 * Gets el Indicador.
	 *
	 * @return insaneam el indicador
	 */
	
	public final String getInsaneam() {
		return insaneam;
	}

	/**
	 * Sets el Inidcador.
	 *
	 * @param insaneam el nuevo indicador
	 */

	public final void setInsaneam(final String insaneam) {
		this.insaneam = insaneam;
	}


	/**
	 * Gets la fecha de inicio de siniestros.
	 *
	 * @return feocusin fecha del inicio de los siniestros
	 */
	
	public final int getFeocusin() {
		return feocusin;
	}

	/**
	 * Sets la fecha inicial de Siniestros.
	 *
	 * @param feocusin la nueva fech del inicio de los siniestros
	 */

	public final void setFeocusin(final int feocusin) {
		this.feocusin = feocusin;
	}



}
