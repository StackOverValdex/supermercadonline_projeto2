package repository;

import DAL.DEPARTAMENTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DEPARTAMENTORepository extends JpaRepository<DEPARTAMENTO, String>, JpaSpecificationExecutor<DEPARTAMENTO>
{

}