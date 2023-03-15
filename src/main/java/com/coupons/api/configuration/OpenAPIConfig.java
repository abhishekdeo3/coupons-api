package com.coupons.api.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Coupon API",
                version = "1.0.0",
                description = "This API provides list of valid coupons of a member. List is sorted by valid until date. " +
                        "If Latitude and longitude provided as a parameters then API returns coupon list sorted by distance.",
                extensions = {
                        @Extension(properties = {
                                @ExtensionProperty(name = "x-business-domain", value = "Coupon")
                        }),
                        @Extension(properties = {
                                @ExtensionProperty(name = "x-business-objects", parseValue = true, value = "[\"Coupons\"]")
                        }),
                        @Extension(properties = {@ExtensionProperty(name = "x-product", value = "Coupons")})
                },
                contact = @Contact(url = "https://coupon-xxx.de", name = "Coupons Management", email = "coupons@xxx.de")
        ),
        security = {
                @SecurityRequirement(name = "Basic-Authentication"),
        },
        servers = {
                @Server(
                        description = "Coupons API local Environment",
                        url = "http://localhost:8091/"
                )
        }
)

@SecurityScheme(
        name = "Basic-Authentication",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
@Configuration
public class OpenAPIConfig {

    @Bean
    public GroupedOpenApi groupApiV1() {
        return GroupedOpenApi.builder().group("api-v1").pathsToMatch("/**")
                .build();
    }
}
