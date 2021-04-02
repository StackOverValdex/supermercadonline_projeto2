package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDaEncomenda
{
    private int id_venda;
    private int id_funcionario;
    private short estadoEntrega;
    private String dataEntrega ;

    private short estadoderesponsabilidade;


    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public short getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(short estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public short getEstadoderesponsabilidade() {
        return estadoderesponsabilidade;
    }

    public void setEstadoderesponsabilidade(short estadoderesponsabilidade) {
        this.estadoderesponsabilidade = estadoderesponsabilidade;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public static List<EstadoDaEncomenda> listarEstadoDaEncomenda()
    {
        Connection conn = oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_VENDA, ID_FUNCIONARIO, ESTADODAENTREGA, DATAENTREGA, ESTADODERESPONSABILIDADE  FROM ESTADODAENCOMENDA";

        List<EstadoDaEncomenda> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                EstadoDaEncomenda estadoencomenda  = new EstadoDaEncomenda();

                estadoencomenda.setId_venda(rs.getInt("ID_VENDA"));
                estadoencomenda.setId_funcionario(rs.getInt("ID_FUNCIONARIO"));
                if (rs.getString("ESTADODAENTREGA") != null)estadoencomenda.setEstadoEntrega(rs.getShort("ESTADODAENTREGA"));
                if (rs.getString("DATAENTREGA") != null)estadoencomenda.setDataEntrega(rs.getString("DATAENTREGA"));
                if (rs.getString("ESTADODERESPONSABILIDADE") != null) estadoencomenda.setEstadoderesponsabilidade(rs.getShort("ESTADODERESPONSABILIDADE"));


                //

                lista.add(estadoencomenda);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void alterarLinhasEstadoDaEncomenda(String command)
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = command;

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.execute();
            System.out.println("Row updated successfully!");
        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }
}
