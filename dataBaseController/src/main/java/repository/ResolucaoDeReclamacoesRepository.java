package repository;

import DAL.ResolucaoDeReclamacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ResolucaoDeReclamacoesRepository extends JpaRepository<ResolucaoDeReclamacoes, String>, JpaSpecificationExecutor<ResolucaoDeReclamacoes> {

}