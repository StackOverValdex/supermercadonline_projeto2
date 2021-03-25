package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "VENDAS")
public class VENDAS implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_VENDA", nullable = false)
    private String idVenda;

    @Column(name = "ID_CLIENTE", nullable = false)
    private String idCliente;

    @Column(name = "ID_PAGAMENTO", nullable = false)
    private String idPagamento;

    @Column(name = "VALORTOTAL", nullable = false)
    private String VALORTOTAL;

    @Column(name = "DATAVENDA", nullable = false)
    private String DATAVENDA;

}
