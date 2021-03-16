package repository;

import DAL.EncomendasAoFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EncomendasAoFornecedorRepository extends JpaRepository<EncomendasAoFornecedor, String>, JpaSpecificationExecutor<EncomendasAoFornecedor>
{

}