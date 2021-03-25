package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CATEGORIA")
public class CATEGORIA implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CATEGORIA", nullable = false)
    private String idCategoria;

    @Column(name = "NOME_CATEGORIA", nullable = false)
    private String nomeCategoria;

    @Column(name = "DESCRICAO_CATEGORIA", nullable = false)
    private String descricaoCategoria;

    @Column(name = "ESTADOATIVIDADE", nullable = false)
    private String ESTADOATIVIDADE;

}
