package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "GESTORES")
public class GESTORES implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_GESTOR", nullable = false)
    private String idGestor;

    @Column(name = "ID_DEPARTAMENTO", nullable = false)
    private String idDepartamento;

    @Column(name = "CAIXAPOSTAL", nullable = false)
    private String CAIXAPOSTAL;

    @Column(name = "NOME_GESTOR", nullable = false)
    private String nomeGestor;

    @Column(name = "NIF", nullable = false)
    private String NIF;

    @Column(name = "RUA", nullable = false)
    private String RUA;

    @Column(name = "PORTA", nullable = false)
    private String PORTA;

    @Column(name = "LOTE", nullable = false)
    private String LOTE;

    @Column(name = "BI", nullable = false)
    private String BI;

    @Column(name = "ID_HORARIO", nullable = false)
    private String idHorario;

    @Column(name = "ESTADOATIVIDADE", nullable = false)
    private String ESTADOATIVIDADE;

}
