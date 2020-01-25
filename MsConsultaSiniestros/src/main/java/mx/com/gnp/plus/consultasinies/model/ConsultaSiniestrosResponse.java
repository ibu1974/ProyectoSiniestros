package mx.com.gnp.plus.consultasinies.model;

import gnp.si.ModeloDatos.Ksirgres;



/***********************************************************************************************
 *                  Respuesta de la consulta de siniestros por poliza.                         *   	
 *                                                                                             *
 **********************************************************************************************/

public class ConsultaSiniestrosResponse  {


	/** Numero de ocurrencias en el arreglo. */
	private final int max = 25;
	
	/** Codigo de error de INFO. */	
	private short codigoError;

	/** Descripcion del Error. */	
	private String descripError;
	
	/** Los datos de los siniestros asociados a la poliza. */
	private Ksirgres[] estrgres = new Ksirgres[max];

/***********************************************************************************************
 *                                Constructor.                                                 *   	
 *                                                                                             *
 **********************************************************************************************/

	public ConsultaSiniestrosResponse()	{
			for (int i0 = 0; i0 < max; i0++) {
		estrgres[i0] = new Ksirgres();
		}


	}

	/**
	 * Gets los siniestros asociados a la poliza.
	 *
	 * @return estrgres arreglo detalle de siniestros
	 */

	public final Ksirgres[] getEstrgres() {
		return estrgres;
	}

	/**
	 * Sets los datos del siniestro asociado a la poliza.
	 *
	 * @param estrgres el nuevo estgres (datos de los siniestros)
	 */

	public final void setEstrgres(final Ksirgres[] estrgres) {
		this.estrgres = estrgres;
	}


	/**
	 * Gets el codigo de error de INFO.
	 *
	 * @return codigoError el codigo de error
	 */

	public final short getCodigoError() {
		return codigoError;
	}

	/**
	 * Sets el codigo de error de INFO.
	 *
	 * @param codigoError el nuevo codigo de error
	 */

	public final void setCodigoError(final short codigoError) {
		this.codigoError = codigoError;
	}

	/**
	 * Gets la descipcion del error.
	 *
	 * @return descripError la descripcion del error
	 */

	public final String getDescripError() {
		return descripError;
	}

	/**
	 * Sets la descripcion del error.
	 *
	 * @param descripError la nueva descripcion del error.
	 */

	public final void setDescripError(final String descripError) {
		this.descripError = descripError;
	}


}
