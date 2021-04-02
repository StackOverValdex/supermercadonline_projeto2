package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Gestores
{
    private int id_gestor;
    private int id_departamento;
    private String caixaPostal;
    private String nome;
    private String nif;
    private short rua;
    private short porta;
    private short lote;
    private String bi;
    private int id_horario;
    private short estadoAtividade;
    private int id_login;

    public int getId_gestor() {
        return id_gestor;
    }

    public void setId_gestor(int id_gestor) {
        this.id_gestor = id_gestor;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getCaixaPostal() {
        return caixaPostal;
    }

    public void setCaixaPostal(String caixaPostal) {
        this.caixaPostal = caixaPostal;
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

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
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

    public void adicionarGestores()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO GESTORES COLUMNS(ID_GESTOR, ID_DEPARTAMENTO, CAIXAPOSTAL, NOME_GESTOR, NIF, RUA, PORTA, LOTE, BI, ID_HORARIO, ESTADOATIVIDADE, ID_LOGIN)" +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_gestor);
            st.setInt(2, this.id_departamento);
            st.setString(3, this.caixaPostal);
            st.setString(4, this.nome);
            st.setString(5, this.nif);
            st.setShort(6, this.rua);
            st.setShort(7, this.porta);
            st.setShort(8, this.lote);
            st.setString(9, this.bi);
            st.setInt(10, this.id_horario);
            st.setShort(11, this.estadoAtividade);
            st.setInt(12, this.id_login);

            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Gestores> listarGestores()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_GESTOR, ID_DEPARTAMENTO, CAIXAPOSTAL, NOME_GESTOR, NIF, RUA, PORTA, LOTE, BI, ID_HORARIO, ESTADOATIVIDADE, ID_LOGIN  FROM GESTORES";

        List<Gestores> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Gestores gestores  = new Gestores();

                gestores.setId_gestor(rs.getInt("ID_GESTOR"));
                if (rs.getString("ID_DEPARTAMENTO") != null) gestores.setId_departamento(rs.getInt("ID_DEPARTAMENTO"));
                if (rs.getString("CAIXAPOSTAL") != null) gestores.setCaixaPostal(rs.getString("CAIXAPOSTAL"));
                if (rs.getString("NOME_GESTOR") != null) gestores.setNome(rs.getString("NOME_GESTOR"));
                if (rs.getString("NIF") != null) gestores.setNif(rs.getString("NIF"));
                if (rs.getString("RUA") != null) gestores.setRua(rs.getShort("RUA"));
                if (rs.getString("PORTA") != null) gestores.setPorta(rs.getShort("PORTA"));
                if (rs.getString("BI") != null) gestores.setBi(rs.getString("BI"));
                if (rs.getString("ID_HORARIO") != null) gestores.setId_horario(rs.getShort("ID_HORARIO"));
                if (rs.getString("ESTADOATIVIDADE") != null) gestores.setEstadoAtividade(rs.getShort("ESTADOATIVIDADE"));
                if (rs.getString("ID_LOGIN") != null) gestores.setId_login(rs.getInt("ID_LOGIN"));
                //

                lista.add(gestores);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void editarGestores(String command)
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

    public void eliminarGestores(String command)
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
