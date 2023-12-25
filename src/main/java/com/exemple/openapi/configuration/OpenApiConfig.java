package com.exemple.openapi.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${demo.url.local}")
    String urlLocal;

    @Value("${demo.url.prod}")
    String urlProd;

    @Bean
    public OpenAPI monOpenApi(){
        val openapi = new OpenAPI();

        val license = getLicense();

        val contact = getContact();

        val info = getInfo(license, contact);

        openapi.info(info);

        val local = getUrl(urlLocal);
        val prod  = getUrl(urlProd);

        openapi.servers(List.of(local,prod));
        return openapi;
    }

    private static License getLicense() {
        val license = new License();
        license.setName("Open Source");
        license.setUrl("http://www.exempleLicense.com");
        return license;
    }

    private static Contact getContact() {
        val contact = new Contact();
        contact.setName("TARIK");
        contact.setEmail("tarik@demo.com");
        contact.setUrl("www.exemplecontact.com");
        return contact;
    }

    private static Info getInfo(License license, Contact contact) {
        val info = new Info();
        info.license(license);
        info.description(" DEMO OPEN API");
        info.contact(contact);
        return info;
    }
    private Server getUrl(String urlLocal) {
        return new Server().url(urlLocal);
    }

}
