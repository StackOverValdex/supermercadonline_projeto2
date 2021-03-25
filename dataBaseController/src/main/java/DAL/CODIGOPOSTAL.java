package DAL;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CODIGOPOSTAL")
public class CODIGOPOSTAL implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CAIXAPOSTAL", nullable = false)
    private String CAIXAPOSTAL;

    @Column(name = "LOCALIDADE", nullable = false)
    private String LOCALIDADE;

}
