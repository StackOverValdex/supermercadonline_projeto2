package repository;

import DAL.RECLAMACOES;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RECLAMACOESRepository extends JpaRepository<RECLAMACOES, String>, JpaSpecificationExecutor<RECLAMACOES>
{

}