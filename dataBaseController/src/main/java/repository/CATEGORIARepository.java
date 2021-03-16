package repository;

import DAL.CATEGORIA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CATEGORIARepository extends JpaRepository<CATEGORIA, String>, JpaSpecificationExecutor<CATEGORIA>
{

}