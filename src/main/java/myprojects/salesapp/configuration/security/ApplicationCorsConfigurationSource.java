package myprojects.salesapp.configuration.security;

import java.time.Duration;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ApplicationCorsConfigurationSource implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .maxAge(Duration.ofHours(1).toSeconds())
                .allowedMethods(getAllowedMethods())
                .allowedHeaders(getAllowedHeaders())
                .allowedOrigins(getAllowedOrigins());
    }

    protected static String[] getAllowedHeaders() {
        String[] headers = { "Origin",
                "Authorization",
                "Content-Type",
                "Accept" };

        return headers;
    }

    protected static String[] getAllowedMethods() {
        String[] methods = { "GET", "POST", "PATCH", "PUT", "DELETE", "OPTIONS" };
        return methods;
    }

    protected static String[] getAllowedOrigins() {
        String[] origins = { "*" };
        return origins;
    }

}
