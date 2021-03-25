package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CLIENTES")
public class CLIENTES implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CLIENTE", nullable = false)
    private String idCliente;

    @Column(name = "NOME_CLIENTE", nullable = false)
    private String nomeCliente;

    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private String dataNascimento;

    @Column(name = "EMAIL", nullable = false)
    private String EMAIL;

    @Column(name = "SENHA", nullable = false)
    private String SENHA;

    @Column(name = "NIF", nullable = false)
    private String NIF;

    @Column(name = "CAIXAPOSTAL", nullable = false)
    private String CAIXAPOSTAL;

    @Column(name = "RUA", nullable = false)
    private String RUA;

    @Column(name = "PORTA")
    private String PORTA;

    @Column(name = "LOTE")
    private String LOTE;

    @Column(name = "TELEFONE", nullable = false)
    private String TELEFONE;

    @Column(name = "COLUMN1")
    private String COLUMN1;

}
