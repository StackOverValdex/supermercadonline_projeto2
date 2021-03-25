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
@Table(name = "ESTADODAENCOMENDA")
public class ESTADODAENCOMENDA implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_VENDA", nullable = false)
    private String idVenda;

    @Id
    @Column(name = "ID_FUNCIONARIO", nullable = false)
    private String idFuncionario;

    @Column(name = "ESTADODAENTREGA", nullable = false)
    private String ESTADODAENTREGA;

    @Column(name = "DATAENTREGA", nullable = false)
    private Date DATAENTREGA;

    @Column(name = "ESTADODERESPONSABILIDADE", nullable = false)
    private String ESTADODERESPONSABILIDADE;

}
