package repository;

import DAL.LINHASENCOMENDAS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LINHASENCOMENDASRepository extends JpaRepository<LINHASENCOMENDAS, String>, JpaSpecificationExecutor<LINHASENCOMENDAS> {

}