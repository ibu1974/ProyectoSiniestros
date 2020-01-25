package mx.com.gnp.plus.consultasinies.controller;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import mx.com.gnp.plus.consultasinies.model.ConsultaSiniestrosRequest;
import mx.com.gnp.plus.consultasinies.model.ConsultaSiniestrosResponse;

import mx.com.gnp.plus.consultasinies.exception.ExceptionEot;
import org.springframework.web.server.ResponseStatusException;

import gnp.ae.presentacion.ventanaMarco.AqSesion;
import gnp.ae.presentacion.ventanaMarco.AqSistema;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AppControllerTest {
	/** The env. */
	@Autowired
	private Environment env;

	@Autowired 
	private AppController appcontroler;
	@Test
	public void consultaSiniestrosporPolizaOk() throws ExceptionEot{
		ConsultaSiniestrosRequest request;

		String usuario = this.env.getProperty("PLUS_USER");
		String entorno = this.env.getProperty("PLUS_INFO_ENTORNO");
		String password = this.env.getProperty("PLUS_PASS");
		AqSesion sesion;
		sesion=AqSistema.getSesionActiva();
		sesion.setCdUsuario(usuario);
		sesion.setDsPassword(password);
		AqSistema.setCdEntorno(entorno);

		ResponseEntity<ConsultaSiniestrosResponse> response;
		request = new ConsultaSiniestrosRequest();
		request.setCdnumpol("00000373642420");
		request.setCdtipusu("EMP");
		request.setFeocusin(0);
		request.setInsaneam("N");
		Assert.assertNotNull(appcontroler);
		response=appcontroler.consultaSiniestrosporPoliza(request);
		Assert.assertEquals(200,response.getStatusCodeValue());
	}

	@Test(expected = ResponseStatusException.class)
	public void consultaSiniestrosporPolizaNoOk() throws ExceptionEot{
		ConsultaSiniestrosRequest request;

		String usuario = this.env.getProperty("PLUS_USER");
		String entorno = this.env.getProperty("PLUS_INFO_ENTORNO");
		String password = this.env.getProperty("PLUS_PASS");
		AqSesion sesion;
		sesion=AqSistema.getSesionActiva();
		sesion.setCdUsuario(usuario);
		sesion.setDsPassword(password);
		AqSistema.setCdEntorno(entorno);
		
		ResponseEntity<ConsultaSiniestrosResponse> response;
		request = new ConsultaSiniestrosRequest();
		request.setCdnumpol("00000373642421");
		request.setCdtipusu("EMP");
		request.setFeocusin(0);
		request.setInsaneam("N");
		Assert.assertNotNull(appcontroler);
		response=appcontroler.consultaSiniestrosporPoliza(request);
	}

	@Test(expected = ResponseStatusException.class)
	public void consultaSiniestrosporPolizaUsuarioErroneo() throws ExceptionEot{
		ConsultaSiniestrosRequest request;

		AqSesion sesion = new AqSesion();
		sesion=AqSistema.getSesionActiva();
		sesion.setCdUsuario("XXX");
		
		ResponseEntity<ConsultaSiniestrosResponse> response;
		request = new ConsultaSiniestrosRequest();
		request.setCdnumpol("00000373642421");
		request.setCdtipusu("EMP");
		request.setFeocusin(0);
		request.setInsaneam("N");
		Assert.assertNotNull(appcontroler);
		response=appcontroler.consultaSiniestrosporPoliza(request);
	}


}
