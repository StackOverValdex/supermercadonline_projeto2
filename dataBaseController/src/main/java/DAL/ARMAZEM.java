package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ARMAZEM")
public class ARMAZEM implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_ARMAZEM", nullable = false)
    private String idArmazem;

    @Column(name = "ID_GESTOR", nullable = false)
    private String idGestor;

    @Column(name = "CAIXAPOSTAL", nullable = false)
    private String CAIXAPOSTAL;

    @Column(name = "NOME_ARMAZEM", nullable = false)
    private String nomeArmazem;

    @Column(name = "RUA", nullable = false)
    private String RUA;

    @Column(name = "PORTA", nullable = false)
    private String PORTA;

    @Column(name = "NOME_RESPONSAVELARMAZEM")
    private String nomeResponsavelarmazem;

    @Column(name = "TELEFONE_RESPONSAVEL")
    private String telefoneResponsavel;

    @Column(name = "ESTADOATIVIDADE")
    private String ESTADOATIVIDADE;

}
