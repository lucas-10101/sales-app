package myprojects.salesapp.configuration.security;

import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Application AuditorAware implementation.
 */
@Configuration
public class ApplicationAuditorAware implements AuditorAware<ApplicationUserDetails> {

	@Override
	public Optional<ApplicationUserDetails> getCurrentAuditor() {

		var principal = Optional.of(SecurityContextHolder.getContext().getAuthentication())
				.map(authentication -> (ApplicationUserDetails) authentication.getPrincipal());

		return principal;
	}

}
