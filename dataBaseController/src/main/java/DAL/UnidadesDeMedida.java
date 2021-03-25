package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "UNIDADES_DE_MEDIDA")
public class UnidadesDeMedida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_UNIDADEMEDIDA", nullable = false)
    private String idUnidademedida;

    @Column(name = "COLUMN2", nullable = false)
    private String COLUMN2;

    @Column(name = "DESCRICAO_UNIDADEMEDIDA")
    private String descricaoUnidademedida;

}
