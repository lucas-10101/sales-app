package myprojects.salesapp.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import myprojects.salesapp.data.user.UserRepository;
import myprojects.salesapp.models.user.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findByUsername(String username) throws UsernameNotFoundException {

		var user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found!"));

		return user;
	}
}
