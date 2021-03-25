package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "PAGAMENTO")
public class PAGAMENTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_PAGAMENTO", nullable = false)
    private String idPagamento;

    @Column(name = "ID_METODOPAGAMENTO", nullable = false)
    private String idMetodopagamento;

    @Column(name = "VALORPAGO", nullable = false)
    private String VALORPAGO;

}
