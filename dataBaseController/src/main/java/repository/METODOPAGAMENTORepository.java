package repository;

import DAL.METODOPAGAMENTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface METODOPAGAMENTORepository extends JpaRepository<METODOPAGAMENTO, String>, JpaSpecificationExecutor<METODOPAGAMENTO> {

}