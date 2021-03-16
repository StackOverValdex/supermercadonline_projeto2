package repository;

import DAL.ARMAZEM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ARMAZEMRepository extends JpaRepository<ARMAZEM, String>, JpaSpecificationExecutor<ARMAZEM>
{

}