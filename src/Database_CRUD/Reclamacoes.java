package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Reclamacoes
{
    private int id_reclamacao;
    private int id_cliente;
    private int id_funcionario;
    private String tituloReclamacao;
    private String conteudoReclamacao;
    private String dataReclamacao;
    private short estadoReclamacao;

    public void setId_reclamacao(int id_reclamacao) {
        this.id_reclamacao = id_reclamacao;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public void setTituloReclamacao(String tituloReclamacao) {
        this.tituloReclamacao = tituloReclamacao;
    }

    public void setConteudoReclamacao(String conteudoReclamacao) {
        this.conteudoReclamacao = conteudoReclamacao;
    }

    public void setDataReclamacao(String dataReclamacao) {
        this.dataReclamacao = dataReclamacao;
    }

    public void setEstadoReclamacao(short estadoReclamacao) {
        this.estadoReclamacao = estadoReclamacao;
    }

    public void adicionarReclamacoes()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO RECLAMACOES COLUMNSA(ID_RECLAMACAO, ID_CLIENTE, TITULORECLAMACAO, CONTEUDORECLAMACAO, ESTADORECLAMACAO, ID_FUNCIONARIO, DATARECLAMACAO)" +
                " VALUES(?,?,?,?,?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_reclamacao);
            st.setInt(2, this.id_cliente);
            st.setString(3, this.tituloReclamacao);
            st.setString(4, this.conteudoReclamacao);
            st.setShort(5, this.estadoReclamacao);
            st.setInt(6, this.id_funcionario);
            st.setString(7, this.dataReclamacao);

            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Reclamacoes> listarReclamacoes()
    {
        Connection conn = oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT  ID_RECLAMACAO, ID_CLIENTE, TITULORECLAMACAO, CONTEUDORECLAMACAO, ESTADORECLAMACAO, ID_FUNCIONARIO, DATARECLAMACAO  FROM RECLAMACOES";

        List<Reclamacoes> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Reclamacoes reclamacoes  = new Reclamacoes();

                reclamacoes.setId_reclamacao(rs.getInt("ID_RECLAMACAO"));
                if (rs.getString("ID_CLIENTE") != null)reclamacoes.setId_reclamacao(rs.getInt("ID_CLIENTE"));
                if (rs.getString("TITULORECLAMACAO") != null)reclamacoes.setTituloReclamacao(rs.getString("TITULORECLAMACAO"));
                if (rs.getString("CONTEUDORECLAMACAO") != null) reclamacoes.setConteudoReclamacao(rs.getString("CONTEUDORECLAMACAO"));
                if (rs.getString("ESTADORECLAMACAO") != null) reclamacoes.setEstadoReclamacao(rs.getShort("ESTADORECLAMACAO"));
                if (rs.getString("ID_FUNCIONARIO") != null) reclamacoes.setId_reclamacao(rs.getInt("ID_FUNCIONARIO"));
                if (rs.getString("DATARECLAMACAO") != null) reclamacoes.setDataReclamacao(rs.getString("DATARECLAMACAO"));


                //

                lista.add(reclamacoes);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void alterarLinhasReclamacoes(String command)
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

    //RESPONDER RECLAÇÕES POR FAVER!!!!!!!
}
