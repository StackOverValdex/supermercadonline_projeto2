package repository;

import DAL.FUNCIONARIOS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FUNCIONARIOSRepository extends JpaRepository<FUNCIONARIOS, String>, JpaSpecificationExecutor<FUNCIONARIOS> {

}