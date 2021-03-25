package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "METODOPAGAMENTO")
public class METODOPAGAMENTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_METODOPAGAMENTO", nullable = false)
    private String idMetodopagamento;

    @Column(name = "DESCRICAO", nullable = false)
    private String DESCRICAO;

    @Column(name = "ESTADOATIVIDADE")
    private String ESTADOATIVIDADE;

}
