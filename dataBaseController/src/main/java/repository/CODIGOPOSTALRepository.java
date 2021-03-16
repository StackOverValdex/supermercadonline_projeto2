package repository;

import DAL.CODIGOPOSTAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CODIGOPOSTALRepository extends JpaRepository<CODIGOPOSTAL, String>, JpaSpecificationExecutor<CODIGOPOSTAL>
{

}