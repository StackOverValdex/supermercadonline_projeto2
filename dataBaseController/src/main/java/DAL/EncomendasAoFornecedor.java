package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ENCOMENDAS_AO_FORNECEDOR")
public class EncomendasAoFornecedor implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_ENCOMENDA", nullable = false)
    private String idEncomenda;

    @Column(name = "ID_GESTOR", nullable = false)
    private String idGestor;

    @Column(name = "ID_FORNECEDOR", nullable = false)
    private String idFornecedor;

    @Column(name = "ID_PAGAMENTO", nullable = false)
    private String idPagamento;

    @Column(name = "DATAENCOMENDA", nullable = false)
    private String DATAENCOMENDA;

    @Column(name = "DATAPREVISTAENTREGA", nullable = false)
    private String DATAPREVISTAENTREGA;

}
