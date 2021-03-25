package repository;

import DAL.HORARIO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HORARIORepository extends JpaRepository<HORARIO, String>, JpaSpecificationExecutor<HORARIO> {

}