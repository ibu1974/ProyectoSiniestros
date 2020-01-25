/**
 * 
 */
package mx.com.gnp.plus.consultasinies.config;



import java.util.ArrayList;
import java.util.Collection;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author jsetien
 *
 */
@Configuration
@EnableSwagger2
@ConditionalOnWebApplication
public class SwaggerConfig {

    /**
     * @return Constructor de la interfaz primaria SWAGGER.
     */
    @Bean
    public  Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("mx.com.gnp.service.controller")).build()
                .apiInfo(metadata());
    }

    /**
     * @return Información general del API.
     */
    @SuppressWarnings("rawtypes")
	private static ApiInfo metadata() {
        Collection<VendorExtension> vendors = new ArrayList<>();
        vendors.add(new StringVendorExtension("GNP", "Grupo Nacional Provincial"));
        return new ApiInfo("JavaMicroService", "Aplicación java para microservicios", "1.0",
                "URL de Terminos de servicio",
                new Contact("GNP", "http://git.gnp.mx/tools/javamicroservice-template", ""),
                "Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0", vendors);
    }

}
