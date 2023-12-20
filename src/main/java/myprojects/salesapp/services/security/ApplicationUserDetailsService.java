package myprojects.salesapp.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import myprojects.salesapp.configuration.security.ApplicationUserDetails;
import myprojects.salesapp.models.user.User;
import myprojects.salesapp.services.user.UserService;

@Component
public class ApplicationUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userService.findByUsername(username);

		return new ApplicationUserDetails(user, new String[0]);
	}

}
