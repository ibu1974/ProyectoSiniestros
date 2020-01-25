package mx.com.gnp.plus.consultasinies.model;

import gnp.si.ModeloDatos.Kcirv701;


public class ConsultaDocumentosSiniestrosResponse {

	/** Numero de ocurrencias. */
	private short nuocurre;

	/** Indicador de ultima pagina. */
    private String inultpag;

    /** Lista de los documentos asociados al Siniestro. */
    private Kcirv701[] cdlisreg = new Kcirv701[50];

/***********************************************************************************************
 *                                Constructor.                                                 *   	
 *                                                                                             *
 **********************************************************************************************/

    public ConsultaDocumentosSiniestrosResponse() {
        super();
        inultpag = new String();
        for (int i0 = 0; i0 < 50; i0++) {
            cdlisreg[i0] = new Kcirv701();
        }

    }
}
