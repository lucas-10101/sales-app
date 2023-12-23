package myprojects.salesapp.configuration.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import myprojects.salesapp.data.user.UserRepository;
import myprojects.salesapp.models.internal.ApplicationUserDetails;
import myprojects.salesapp.models.user.User;

/**
 * Application AuditorAware implementation that returns an valid Jpa
 * {@link User} reference.
 */
@Configuration
public class ApplicationAuditorAware implements AuditorAware<User> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> getCurrentAuditor() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth == null || auth instanceof AnonymousAuthenticationToken)
			return Optional.empty();

		var principal = Optional.of(auth)
				.map(authentication -> ((ApplicationUserDetails) authentication.getPrincipal()));

		var userRef = principal.map(details -> userRepository.getReferenceById(details.getUserId()));

		return userRef;
	}

}
