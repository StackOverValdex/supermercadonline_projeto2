package repository;

import DAL.PAGAMENTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PAGAMENTORepository extends JpaRepository<PAGAMENTO, String>, JpaSpecificationExecutor<PAGAMENTO> {

}