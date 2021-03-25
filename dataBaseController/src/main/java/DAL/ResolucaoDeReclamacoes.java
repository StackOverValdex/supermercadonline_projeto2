package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "RESOLUCAO_DE_RECLAMACOES")
public class ResolucaoDeReclamacoes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_RESOLUCAO", nullable = false)
    private String idResolucao;

    @Column(name = "ID_FUNCIONARIO", nullable = false)
    private String idFuncionario;

    @Column(name = "ID_RECLAMACAO", nullable = false)
    private String idReclamacao;

    @Column(name = "RESOLUCAO", nullable = false)
    private String RESOLUCAO;

    @Column(name = "ESTADORESOLUCAO", nullable = false)
    private String ESTADORESOLUCAO;

    @Column(name = "DATARESOLUCAO", nullable = false)
    private Date DATARESOLUCAO;

}
