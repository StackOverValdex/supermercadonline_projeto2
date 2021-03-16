package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "FORNECEDOR")
public class FORNECEDOR implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_FORNECEDOR", nullable = false)
    private String idFornecedor;

    @Column(name = "CAIXAPOSTAL", nullable = false)
    private String CAIXAPOSTAL;

    @Column(name = "NOME_FORNECEDOR", nullable = false)
    private String nomeFornecedor;

    @Column(name = "EMAIL_FORNECEDOR", nullable = false)
    private String emailFornecedor;

    @Column(name = "TELEFONE", nullable = false)
    private String TELEFONE;

    @Column(name = "RUA", nullable = false)
    private String RUA;

    @Column(name = "PORTA", nullable = false)
    private String PORTA;

    @Column(name = "LOTE", nullable = false)
    private String LOTE;

}
