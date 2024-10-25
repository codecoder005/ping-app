package com.popcorn.docx;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Ping App",
                version = "1.0.0",
                description = """
                Ping App
                """,
                termsOfService = "terms of service",
                contact = @Contact(
                        name = "Ramakrishna Janapureddy",
                        email = "developer.raakhi005@gmail.com"
                ),
                license = @License(
                        name = "Apache License 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        servers = {
                @Server(
                        description = "Local",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Development",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Test",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Production",
                        url = "http://15.206.151.118:8080"
                )
        }
)
public class OpenAPIDocxConfig {

}
