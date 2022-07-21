package br.com.throchadev.configuration;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(
                title="Crud Quarkus",
                version = "1.0.0",
                contact = @Contact(
                        name = "Thiago Support",
                        url = "https://www.linkedin.com/in/thiago-de-oliveira-27663b161",
                        email = "oliveira.thiago2@hotmail.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class ApiConfiguration extends Application {
}
