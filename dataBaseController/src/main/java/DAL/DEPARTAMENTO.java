package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "DEPARTAMENTO")
public class DEPARTAMENTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_DEPARTAMENTO", nullable = false)
    private String idDepartamento;

    @Column(name = "NOME_DEPARTAMENTO", nullable = false)
    private String nomeDepartamento;

    @Column(name = "ESTADOATIVIDADE")
    private String ESTADOATIVIDADE;

}
