package myprojects.salesapp.configuration.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ApplicationHttpSecurity {

    @Autowired
    private Environment env;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(request -> authorizeHttpRequests(request));

        http.csrf(csrf -> {
            csrf.disable();
        });

        http.sessionManagement(sessionManagement -> {
            sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });

        http.headers(headers -> {
            headers.frameOptions(frameOptions -> {
                frameOptions.sameOrigin();
            });
        });

        return http.build();
    }

    protected void authorizeHttpRequests(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry request) {

        if (Arrays.asList(env.getActiveProfiles()).contains("dev"))
            allowDevelopmentUrls(request);

        request.requestMatchers(new AntPathRequestMatcher("/test", "GET")).permitAll();
        request.anyRequest().hasAnyAuthority("LOGIN");
    }

    protected void allowDevelopmentUrls(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry request) {
        request.requestMatchers("/h2-console/**").permitAll();
    }
}
