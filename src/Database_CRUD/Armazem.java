package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Armazem
{
    private int id_armazem;
    private int id_gestor;
    private String caixa_postal;
    private String nome;
    private short rua;
    private short porta;
    private String nomeResponsavel;
    private String telofoneResponsavel;
    private short estadoAtividade;

    public int getId_armazem() {
        return id_armazem;
    }

    public void setId_armazem(int id_armazem) {
        this.id_armazem = id_armazem;
    }

    public int getId_gestor() {
        return id_gestor;
    }

    public void setId_gestor(int id_gestor) {
        this.id_gestor = id_gestor;
    }

    public String getCaixa_postal() {
        return caixa_postal;
    }

    public void setCaixa_postal(String caixa_postal) {
        this.caixa_postal = caixa_postal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public short getRua() {
        return rua;
    }

    public void setRua(short rua) {
        this.rua = rua;
    }

    public short getPorta() {
        return porta;
    }

    public void setPorta(short porta) {
        this.porta = porta;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getTelofoneResponsavel() {
        return telofoneResponsavel;
    }

    public void setTelofoneResponsavel(String telofoneResponsavel) {
        this.telofoneResponsavel = telofoneResponsavel;
    }

    public short getEstadoAtividade() {
        return estadoAtividade;
    }

    public void setEstadoAtividade(short estadoAtividade) {
        this.estadoAtividade = estadoAtividade;
    }

    public void adicionarArmazem()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO ARMAZEM COLUMNS(ID_ARMAZEM, ID_GESTOR, CAIXAPOSTAL, NOME_ARMAZEM, RUA, PORTA, NOME_RESPONSAVELARMAZEM, TELEFONE_RESPONSAVEL, ESTADOATIVIDADE)" +
                " VALUES(?,?,?,?,?,?,?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_armazem);
            st.setInt(2, this.id_gestor);
            st.setString(3, this.caixa_postal);
            st.setString(4, this.nome);
            st.setShort(5, this.rua);
            st.setShort(6, this.porta);
            st.setString(7, this.nomeResponsavel);
            st.setString(8, this.telofoneResponsavel);
            st.setShort(9, this.estadoAtividade);


            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Armazem> listarArmazem()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_ARMAZEM, ID_GESTOR, CAIXAPOSTAL, NOME_ARMAZEM, RUA, PORTA, NOME_RESPONSAVELARMAZEM, TELEFONE_RESPONSAVEL, ESTADOATIVIDADE  FROM ARMAZEM";

        List<Armazem> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Armazem armazem  = new Armazem();

                armazem.setId_armazem(rs.getInt("ID_ARMAZEM"));
                if (rs.getString("ID_GESTOR") != null) armazem.setId_gestor(rs.getInt("ID_GESTOR"));
                if (rs.getString("CAIXAPOSTAL") != null) armazem.setCaixa_postal(rs.getString("CAIXAPOSTAL"));
                if (rs.getString("NOME_ARMAZEM") != null) armazem.setNome(rs.getString("NOME_ARMAZEM"));
                if (rs.getString("RUA") != null) armazem.setRua(rs.getShort("RUA"));
                if (rs.getString("PORTA") != null) armazem.setPorta(rs.getShort("PORTA"));
                if (rs.getString("NOME_RESPONSAVELARMAZEM") != null) armazem.setNomeResponsavel(rs.getString("NOME_RESPONSAVELARMAZEM"));
                if (rs.getString("TELEFONE_RESPONSAVEL") != null) armazem.setTelofoneResponsavel(rs.getString("TELEFONE_RESPONSAVEL"));
                if (rs.getString("ESTADOATIVIDADE") != null) armazem.setEstadoAtividade(rs.getShort("ESTADOATIVIDADE"));
                //

                lista.add(armazem);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void editarArmazem(String command)
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

    public void eliminarArmazem(String command)
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = command;

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
