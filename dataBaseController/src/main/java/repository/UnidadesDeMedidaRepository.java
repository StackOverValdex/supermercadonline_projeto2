package repository;

import DAL.UnidadesDeMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UnidadesDeMedidaRepository extends JpaRepository<UnidadesDeMedida, String>, JpaSpecificationExecutor<UnidadesDeMedida> {

}