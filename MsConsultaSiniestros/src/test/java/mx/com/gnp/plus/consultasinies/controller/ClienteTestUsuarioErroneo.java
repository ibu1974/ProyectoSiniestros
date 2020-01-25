package mx.com.gnp.plus.consultasinies.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import gnp.ae.presentacion.ventanaMarco.AqSesion;
import gnp.ae.presentacion.ventanaMarco.AqSistema;
import mx.com.gnp.plus.consultasinies.exception.ExceptionEot;
import mx.com.gnp.plus.consultasinies.model.ConsultaSiniestrosResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ClienteTestUsuarioErroneo {
	@LocalServerPort
    private int port;

	@Autowired
	private TestRestTemplate template;
	
	@Test
	public void consultaSiniestrosporPolizaOk() throws ExceptionEot{
		AqSesion sesion = new AqSesion();
		sesion=AqSistema.getSesionActiva();
		sesion.setCdUsuario("XXX");

		ResponseEntity<ConsultaSiniestrosResponse> response = template.getForEntity("/Consultas/consultarSiniestros?cdnumpol=00000373642420&cdtipusu=EMP&insaneam=N&feocusin=0",  ConsultaSiniestrosResponse.class);
		Assert.assertEquals(500,response.getStatusCodeValue());
	}

}
