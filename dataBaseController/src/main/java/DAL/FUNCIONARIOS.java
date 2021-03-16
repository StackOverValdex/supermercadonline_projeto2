package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "FUNCIONARIOS")
public class FUNCIONARIOS implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_FUNCIONARIO", nullable = false)
    private String idFuncionario;

    @Column(name = "ID_DEPARTAMENTO", nullable = false)
    private String idDepartamento;

    @Column(name = "CAIXAPOSTAL", nullable = false)
    private String CAIXAPOSTAL;

    @Column(name = "NOME", nullable = false)
    private String NOME;

    @Column(name = "NIF", nullable = false)
    private String NIF;

    @Column(name = "RUA", nullable = false)
    private String RUA;

    @Column(name = "PORTA", nullable = false)
    private String PORTA;

    @Column(name = "TELEFONE", nullable = false)
    private String TELEFONE;

    @Column(name = "ID_HORARIO", nullable = false)
    private String idHorario;

}
