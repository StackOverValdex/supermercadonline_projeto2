package repository;

import DAL.PRATELEIRA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PRATELEIRARepository extends JpaRepository<PRATELEIRA, String>, JpaSpecificationExecutor<PRATELEIRA> {

}