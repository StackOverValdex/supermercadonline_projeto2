package repository;

import DAL.PRODUTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PRODUTORepository extends JpaRepository<PRODUTO, String>, JpaSpecificationExecutor<PRODUTO>
{

}