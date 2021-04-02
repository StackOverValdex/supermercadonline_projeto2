package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Resolucao_Reclamacoes 
{

    private int id_resolucao;
    private int id_funcionario;
    private int id_reclamacao;
    private String resolucao;
    private short estadoResolucao;
    private String dataResolucao;

    public int getId_resolucao() {
        return id_resolucao;
    }

    public void setId_resolucao(int id_resolucao) {
        this.id_resolucao = id_resolucao;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getId_reclamacao() {
        return id_reclamacao;
    }

    public void setId_reclamacao(int id_reclamacao) {
        this.id_reclamacao = id_reclamacao;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public short getEstadoResolucao() {
        return estadoResolucao;
    }

    public void setEstadoResolucao(short estadoResolucao) {
        this.estadoResolucao = estadoResolucao;
    }

    public String getDataResolucao() {
        return dataResolucao;
    }

    public void setDataResolucao(String dataResolucao) {
        this.dataResolucao = dataResolucao;
    }



    public void responderAoProblema()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO RESOLUCAO_DE_RECLAMACOES COLUMNS" +
                "(ID_RESOLUCAO, ID_FUNCIONARIO, ID_RECLAMACAO, RESOLUCAO, ESTADORESOLUCAO, DATARESOLUCAO)" +
                " VALUES(?,?,?,?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_resolucao);
            st.setInt(2, this.id_funcionario);
            st.setInt(3, this.id_reclamacao);
            st.setString(4, this.resolucao);
            st.setShort(5, this.estadoResolucao);
            st.setString(6, this.dataResolucao);

            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Login> listarContasLogin()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT (ID_LOGIN, USERNAME, PASSWORD, ESTADOATIVIDADE" +
                "FROM LOGIN";

        List<Login> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Login login  = new Login();

                login.setId_login(rs.getInt("ID_LOGIN"));
                if (rs.getString("USERNAME") != null)login.setUsername(rs.getString("USERNAME"));
                if (rs.getString("PASSWORD") != null)login.setPassword(rs.getString("PASSWORD"));
                if (rs.getString("ESTADOATIVIDADE") != null) login.setEmail(rs.getString("ESTADOATIVIDADE"));

                lista.add(login);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void alterarEstadoResolucao(String command)
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
