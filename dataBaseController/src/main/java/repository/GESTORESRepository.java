package repository;

import DAL.GESTORES;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GESTORESRepository extends JpaRepository<GESTORES, String>, JpaSpecificationExecutor<GESTORES>
{

}