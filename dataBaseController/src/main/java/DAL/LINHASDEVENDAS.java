package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "LINHASDEVENDAS")
public class LINHASDEVENDAS implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_VENDA", nullable = false)
    private String idVenda;

    @Id
    @Column(name = "ID_PRODUTO", nullable = false)
    private String idProduto;

    @Column(name = "QUANTIDADE", nullable = false)
    private String QUANTIDADE;

    @Column(name = "PRECOUNITARIO", nullable = false)
    private String PRECOUNITARIO;

}
