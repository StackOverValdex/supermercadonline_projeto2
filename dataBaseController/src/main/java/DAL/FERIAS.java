package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "FERIAS")
public class FERIAS implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Column(name = "ID_FERIAS", nullable = false)
    private String idFerias;

    @Column(name = "ID_FUNCIONARIO", nullable = false)
    private String idFuncionario;

    @Column(name = "DATAINICIOFERIAS", nullable = false)
    private Date DATAINICIOFERIAS;

    @Column(name = "COLUMN2", nullable = false)
    private Date COLUMN2;

}
