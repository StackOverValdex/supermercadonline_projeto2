package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "HORARIO")
public class HORARIO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_HORARIO", nullable = false)
    private String idHorario;

    @Column(name = "ID_FUNCIONARIO", nullable = false)
    private String idFuncionario;

    @Column(name = "SEGUNDA_FEIRA", nullable = false)
    private String segundaFeira;

    @Column(name = "TERCA_FEIRA", nullable = false)
    private String tercaFeira;

    @Column(name = "QUARTA_FEIRA", nullable = false)
    private String quartaFeira;

    @Column(name = "QUINTA_FEIRA", nullable = false)
    private String quintaFeira;

    @Column(name = "SEXTA_FEIRA", nullable = false)
    private String sextaFeira;

    @Column(name = "SABADO", nullable = false)
    private String SABADO;

    @Column(name = "DOMINGO", nullable = false)
    private String DOMINGO;

    @Column(name = "NUMERODEFUNCIONARIOS", nullable = false)
    private String NUMERODEFUNCIONARIOS;

    @Column(name = "ESTADOATIVIDADE", nullable = false)
    private String ESTADOATIVIDADE;

}
