package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Metodos_Pagamento
{
    private int id_metodoPagamento;
    private String descricao;
    private int estadoDeAtividade;

    public int getId_metodoPagamento() {
        return id_metodoPagamento;
    }

    public void setId_metodoPagamento(int id_metodoPagamento) {
        this.id_metodoPagamento = id_metodoPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstadoDeAtividade() {
        return estadoDeAtividade;
    }

    public void setEstadoDeAtividade(int estadoDeAtividade) {
        this.estadoDeAtividade = estadoDeAtividade;
    }


    public void adicionarMetodosPagamento()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO METODOPAGAMENTO COLUMNS(ID_METODOPAGAMENTO,DESCRICAO,ESTADOATIVIDADE) VALUES(?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1,this.id_metodoPagamento);
            st.setString(2, this.descricao);
            st.setInt(3, this.estadoDeAtividade);

            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Metodos_Pagamento> listarMetodosDePagamento()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_METODOPAGAMENTO, DESCRICAO,ESTADOATIVIDADE FROM METODOPAGAMENTO";

        List<Metodos_Pagamento> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Metodos_Pagamento metodopagamento  = new Metodos_Pagamento();

                metodopagamento.setId_metodoPagamento(rs.getInt("ID_METODOPAGAMENTO"));
                //
                if (rs.getString("DESCRICAO") != null) metodopagamento.setDescricao(rs.getString("DESCRICAO"));
                if (rs.getString("ESTADOATIVIDADE") != null) metodopagamento.setEstadoDeAtividade(rs.getInt("ESTADOATIVIDADE"));
                //

                lista.add(metodopagamento);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void editarMetodosPagamento(String command)
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

    public void eliminarMetodosPagamento(String command)
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand =  command;

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.execute();
            System.out.println("Row deleted successfully!");
        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }
}
