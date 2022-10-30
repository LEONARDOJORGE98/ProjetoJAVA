package br.com.leonardojorge98.ProjetoJAVA.Repositories.User;

import br.com.leonardojorge98.ProjetoJAVA.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUuid(String uuid);

}
