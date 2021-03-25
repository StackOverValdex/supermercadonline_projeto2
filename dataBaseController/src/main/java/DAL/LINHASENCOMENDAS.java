package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "LINHASENCOMENDAS")
public class LINHASENCOMENDAS implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_ENCOMENDA", nullable = false)
    private String idEncomenda;

    @Id
    @Column(name = "ID_PRODUTO", nullable = false)
    private String idProduto;

    @Column(name = "QUANTIDADE", nullable = false)
    private String QUANTIDADE;

    @Column(name = "PRECO", nullable = false)
    private String PRECO;

    @Column(name = "DESCRICAO", nullable = false)
    private String DESCRICAO;

}
