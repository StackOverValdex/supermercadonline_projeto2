package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "RECLAMACOES")
public class RECLAMACOES implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_RECLAMACAO", nullable = false)
    private String idReclamacao;

    @Column(name = "ID_CLIENTE", nullable = false)
    private String idCliente;

    @Column(name = "TITULORECLAMACAO", nullable = false)
    private String TITULORECLAMACAO;

    @Column(name = "CONTEUDORECLAMACAO", nullable = false)
    private String CONTEUDORECLAMACAO;

    @Column(name = "ESTADORECLAMACAO", nullable = false)
    private String ESTADORECLAMACAO;

    @Column(name = "ID_FUNCIONARIO", nullable = false)
    private String idFuncionario;

}
