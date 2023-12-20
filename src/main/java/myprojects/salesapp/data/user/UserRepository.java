package myprojects.salesapp.data.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myprojects.salesapp.models.user.User;

/**
 * {@link User} repository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

}
