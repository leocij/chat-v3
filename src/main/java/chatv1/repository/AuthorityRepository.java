package chatv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chatv1.model.Authorities;

public interface AuthorityRepository extends JpaRepository<Authorities, String> {

}
