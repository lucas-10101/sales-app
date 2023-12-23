package myprojects.salesapp.models.internal;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import myprojects.salesapp.models.user.User;

/**
 * Application UserDetails implementation.
 */
@Data
public class ApplicationUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private boolean active;

	private Integer userId;

	private final Collection<GrantedAuthority> authorities;

	public ApplicationUserDetails(User user, String... authorities) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.userId = user.getId();
		this.authorities = new ArrayList<>(user.getRoles());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.isActive();
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.isActive();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.isActive();
	}

	@Override
	public boolean isEnabled() {
		return this.isActive();
	}
}
