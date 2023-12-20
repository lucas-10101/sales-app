package myprojects.salesapp.data.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myprojects.salesapp.models.user.User;
import myprojects.salesapp.models.user.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	List<UserRole> findByUser(User user);
}
