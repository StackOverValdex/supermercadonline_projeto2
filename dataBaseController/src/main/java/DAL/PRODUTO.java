package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "PRODUTO")
public class PRODUTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_PRODUTO", nullable = false)
    private String idProduto;

    @Column(name = "ID_CATEGORIA", nullable = false)
    private String idCategoria;

    @Column(name = "ID_ARMAZEM", nullable = false)
    private String idArmazem;

    @Column(name = "NOME_PRODUTO", nullable = false)
    private String nomeProduto;

    @Column(name = "VALIDADE")
    private String VALIDADE;

    @Column(name = "QUANTIDADE_EM_STOCK", nullable = false)
    private String quantidadeEmStock;

    @Column(name = "PRECOVENDA", nullable = false)
    private String PRECOVENDA;

    @Column(name = "QUANTIDADE_MINIMA_STOCK", nullable = false)
    private String quantidadeMinimaStock;

    @Column(name = "ESTADOATIVIDADE", nullable = false)
    private String ESTADOATIVIDADE;

    @Column(name = "ID_UNIDADEMEDIDA", nullable = false)
    private String idUnidademedida;

}
