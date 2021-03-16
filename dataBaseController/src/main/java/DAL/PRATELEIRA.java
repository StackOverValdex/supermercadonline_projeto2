package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "PRATELEIRA")
public class PRATELEIRA implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_PRATELEIRA", nullable = false)
    private String idPrateleira;

    @Column(name = "ID_ARMAZEM")
    private String idArmazem;

    @Column(name = "CORREDOR")
    private String CORREDOR;

}
