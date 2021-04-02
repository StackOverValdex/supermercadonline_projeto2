package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Fornecedores
{
    private int id_fornecedor;
    private String caixa_postal;
    private String nome;
    private String email;
    private String telefone;
    private short rua;
    private short porta;
    private short lote;
    private String nif;
    private short estadoAtividade;

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public short getLote() {
        return lote;
    }

    public void setLote(short lote) {
        this.lote = lote;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public short getEstadoAtividade() {
        return estadoAtividade;
    }

    public void setEstadoAtividade(short estadoAtividade) {
        this.estadoAtividade = estadoAtividade;
    }

    public void adicionarFornecedores()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO FORNECEDORES COLUMNS(ID_FORNECEDOR, CAIXAPOSTAL, NOME_FORNECEDOR, EMAIL_FORNECEDOR, TELEFONE, RUA, PORTA, LOTE, NIF, ESTADOATIVIDADE)" +
                " VALUES(?,?,?,?,?,?,?,?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_fornecedor);
            st.setString(2, this.caixa_postal);
            st.setString(3, this.nome);
            st.setString(4, this.email);
            st.setString(5, this.telefone);
            st.setString(6, this.nif);
            st.setShort(7, this.rua);
            st.setShort(8, this.porta);
            st.setShort(9, this.lote);
            st.setShort(10, this.estadoAtividade);


            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Fornecedores> listarFornecedores()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_FORNECEDOR, CAIXAPOSTAL, NOME_FORNECEDOR, EMAIL_FORNECEDOR, TELEFONE, RUA, PORTA, LOTE, NIF, ESTADOATIVIDADE  FROM FORNECEDORES";

        List<Fornecedores> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Fornecedores fornecedores  = new Fornecedores();

                fornecedores.setId_fornecedor(rs.getInt("ID_FORNECEDOR"));
                if (rs.getString("CAIXAPOSTAL") != null) fornecedores.setCaixa_postal(rs.getString("CAIXAPOSTAL"));
                if (rs.getString("NOME_FORNECEDOR") != null) fornecedores.setNome(rs.getString("NOME_FORNECEDOR"));
                if (rs.getString("EMAIL_FORNECEDOR") != null) fornecedores.setEmail(rs.getString("EMAIL_FORNECEDOR"));
                if (rs.getString("TELEFONE") != null) fornecedores.setTelefone(rs.getString("TELEFONE"));
                if (rs.getString("RUA") != null) fornecedores.setRua(rs.getShort("RUA"));
                if (rs.getString("PORTA") != null) fornecedores.setPorta(rs.getShort("PORTA"));
                if (rs.getString("LOTE") != null) fornecedores.setLote(rs.getShort("LOTE"));
                if (rs.getString("NIF") != null) fornecedores.setNif(rs.getString("NIF"));
                if (rs.getString("ESTADOATIVIDADE") != null) fornecedores.setEstadoAtividade(rs.getShort("ESTADOATIVIDADE"));
                //

                lista.add(fornecedores);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void editarFornecedores(String command)
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

    public void eliminarFornecedores(String command)
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
