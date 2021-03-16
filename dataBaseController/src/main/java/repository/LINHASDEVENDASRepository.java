package repository;

import DAL.LINHASDEVENDAS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LINHASDEVENDASRepository extends JpaRepository<LINHASDEVENDAS, String>, JpaSpecificationExecutor<LINHASDEVENDAS>
{

}