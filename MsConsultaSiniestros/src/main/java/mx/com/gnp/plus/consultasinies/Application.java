/**
 * 
 */
package mx.com.gnp.plus.consultasinies;

import static springfox.documentation.builders.PathSelectors.regex;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import gnp.ae.presentacion.ventanaMarco.AqSesion;
import gnp.ae.presentacion.ventanaMarco.AqSistema;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * @author jsetien
 *
 */
@Slf4j
@SpringBootApplication
public class Application {
	/** La variable para implementar el LOG. */

	public static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Application.class);
	/** The group name. */
	@Value("${group.name}")
	private String groupName;

	/** The title. */
	@Value("${title}")
	private String title;

	/** The regex. */
	@Value("${regex}")
	private String regex;

	/** The description. */
	@Value("${description}")
	private String description;

	/** The terms of service url. */
	@Value("${terms.of.service.url}")
	private String termsOfServiceUrl;

	/** The license. */
	@Value("${license}")
	private String license;

	/** The license url. */
	@Value("${license.url}")
	private String licenseUrl;

	/** The version. */
	@Value("${version}")
	private String version;
	
	/** The env. */
	@Autowired
	private Environment env;

	/***********************************************************************************************
	* Objetivo :Inicializa los valores de las varibles de entorno antes  de ejecutar la
	* aplicacion.
	***********************************************************************************************/
	
	@PostConstruct
	public final void init() {
		String entorno = this.env.getProperty("PLUS_INFO_ENTORNO");
		String usuario = this.env.getProperty("PLUS_USER");
		String password = this.env.getProperty("PLUS_PASS");
		AqSesion sesion = new AqSesion();
		sesion.setCdUsuario(usuario);
		sesion.setDsPassword(password);
		AqSistema.setCdEntorno(entorno);
		AqSistema.setSesionActiva(sesion);

	}

/**
 * Configure.
 *
 * @param builder the builder
 * @return the spring application builder
 */
@SuppressWarnings("checkstyle:designforextension")
protected final SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
	return builder.sources(Application.class);
}

	
	
		
	/**
	 * @param args Esta aplicacion no requiere de parametros al inicializar.
	 */
	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
		LOG.info("Java microservice inicializado correctamente");
	}
	
	@Override
    public final String toString() {
        return "Java Microservice Application";
	}
	/**
	 * News api.
	 *
	 * @return the docket
	 */
	@SuppressWarnings("checkstyle:designforextension")
	@Bean
	public  Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName(this.groupName).apiInfo(this.apiInfo()).select()
				.paths(regex(this.regex)).build();
	}

	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(this.title).description(this.description)
				.termsOfServiceUrl(this.termsOfServiceUrl).license(this.license).licenseUrl(this.licenseUrl)
				.version(this.version).build();
	}
}
