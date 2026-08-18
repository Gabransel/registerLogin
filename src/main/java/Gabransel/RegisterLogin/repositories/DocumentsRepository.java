package Gabransel.RegisterLogin.repositories;

import Gabransel.RegisterLogin.entities.Documents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentsRepository extends JpaRepository<Documents, Long> {

    List<Documents> findByUsuarioId(Long id);
}
