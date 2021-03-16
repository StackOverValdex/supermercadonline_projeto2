package repository;

import DAL.FERIAS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FERIASRepository extends JpaRepository<FERIAS, Void>, JpaSpecificationExecutor<FERIAS>
{

}