package repository;

import DAL.VENDAS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VENDASRepository extends JpaRepository<VENDAS, String>, JpaSpecificationExecutor<VENDAS>
{

}