package chatv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chatv1.model.Users;

public interface UserRepository extends JpaRepository<Users, String> {

}
