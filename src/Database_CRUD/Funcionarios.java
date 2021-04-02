package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Funcionarios
{
    private int id_funcionario;
    private int id_departamento;
    private String caixa_postal;
    private String nome;
    private String nif;
    private short rua;
    private short porta;
    private short lote;
    private String telefone;
    private int id_horario;
    private short estadoAtividade;
    private int id_login;

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public short getEstadoAtividade() {
        return estadoAtividade;
    }

    public void setEstadoAtividade(short estadoAtividade) {
        this.estadoAtividade = estadoAtividade;
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }


    public void adicionarFuncionarios()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO FUNCIONARIOS COLUMNS(ID_FUNCIONARIO, ID_DEPARTAMENTO, CAIXAPOSTAL, NOME, NIF, RUA, PORTA, TELEFONE, ID_HORARIO, ESTADOATIVIDADE, ID_LOGIN)" +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_funcionario);
            st.setInt(2, this.id_departamento);
            st.setString(3, this.caixa_postal);
            st.setString(4, this.nome);
            st.setString(5, this.nif);
            st.setShort(6, this.rua);
            st.setShort(7, this.porta);
            st.setString(8, this.telefone);
            st.setInt(9, this.id_horario);
            st.setShort(10, this.estadoAtividade);
            st.setInt(11, this.id_login);

            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Funcionarios> listarFuncionarios()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_FUNCIONARIO, ID_DEPARTAMENTO, CAIXAPOSTAL, NOME, NIF, RUA, PORTA, TELEFONE, ID_HORARIO, ESTADOATIVIDADE, ID_LOGIN  FROM FUNCIONARIOS";

        List<Funcionarios> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Funcionarios funcionarios  = new Funcionarios();

                funcionarios.setId_funcionario(rs.getInt("ID_FUNCIONARIO"));
                if (rs.getString("ID_DEPARTAMENTO") != null) funcionarios.setId_departamento(rs.getInt("ID_DEPARTAMENTO"));
                if (rs.getString("CAIXAPOSTAL") != null) funcionarios.setCaixa_postal(rs.getString("CAIXAPOSTAL"));
                if (rs.getString("NOME") != null) funcionarios.setNome(rs.getString("NOME"));
                if (rs.getString("NIF") != null) funcionarios.setNif(rs.getString("NIF"));
                if (rs.getString("RUA") != null) funcionarios.setRua(rs.getShort("RUA"));
                if (rs.getString("PORTA") != null) funcionarios.setPorta(rs.getShort("PORTA"));
                if (rs.getString("TELEFONE") != null) funcionarios.setTelefone(rs.getString("TELEFONE"));
                if (rs.getString("ID_HORARIO") != null) funcionarios.setId_horario(rs.getShort("ID_HORARIO"));
                if (rs.getString("ESTADOATIVIDADE") != null) funcionarios.setEstadoAtividade(rs.getShort("ESTADOATIVIDADE"));
                if (rs.getString("ID_LOGIN") != null) funcionarios.setId_login(rs.getInt("ID_LOGIN"));
                //

                lista.add(funcionarios);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void editarFuncionarios(String command)
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

    public void eliminarFuncionarios(String command)
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
