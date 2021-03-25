package repository;

import DAL.CLIENTES;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CLIENTESRepository extends JpaRepository<CLIENTES, String>, JpaSpecificationExecutor<CLIENTES> {

}