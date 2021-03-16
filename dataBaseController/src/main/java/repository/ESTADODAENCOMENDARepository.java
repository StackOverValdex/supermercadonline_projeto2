package repository;

import DAL.ESTADODAENCOMENDA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ESTADODAENCOMENDARepository extends JpaRepository<ESTADODAENCOMENDA, String>, JpaSpecificationExecutor<ESTADODAENCOMENDA>
{

}