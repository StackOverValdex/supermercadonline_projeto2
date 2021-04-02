package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Horario
{
    private int id_horario;
    private int id_funcionario;
    private short segunda_feira;
    private short terca_feira;
    private short quarta_feira;
    private short quinta_feira;
    private short sexta_feira;
    private short sabado;
    private short domingo;
    private short estadoAtividade;
    private int numeroDeFuncionarios;
    private int numeroDeFuncionariosNecessarios;

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public short getSegunda_feira() {
        return segunda_feira;
    }

    public void setSegunda_feira(short segunda_feira) {
        this.segunda_feira = segunda_feira;
    }

    public short getTerca_feira() {
        return terca_feira;
    }

    public void setTerca_feira(short terca_feira) {
        this.terca_feira = terca_feira;
    }

    public short getQuarta_feira() {
        return quarta_feira;
    }

    public void setQuarta_feira(short quarta_feira) {
        this.quarta_feira = quarta_feira;
    }

    public short getQuinta_feira() {
        return quinta_feira;
    }

    public void setQuinta_feira(short quinta_feira) {
        this.quinta_feira = quinta_feira;
    }

    public short getSexta_feira() {
        return sexta_feira;
    }

    public void setSexta_feira(short sexta_feira) {
        this.sexta_feira = sexta_feira;
    }

    public short getSabado() {
        return sabado;
    }

    public void setSabado(short sabado) {
        this.sabado = sabado;
    }

    public short getDomingo() {
        return domingo;
    }

    public void setDomingo(short domingo) {
        this.domingo = domingo;
    }

    public short getEstadoAtividade() {
        return estadoAtividade;
    }

    public void setEstadoAtividade(short estadoAtividade) {
        this.estadoAtividade = estadoAtividade;
    }

    public int getNumeroDeFuncionarios() {
        return numeroDeFuncionarios;
    }

    public void setNumeroDeFuncionarios(int numeroDeFuncionarios) {
        this.numeroDeFuncionarios = numeroDeFuncionarios;
    }

    public int getNumeroDeFuncionariosNecessarios() {
        return numeroDeFuncionariosNecessarios;
    }

    public void setNumeroDeFuncionariosNecessarios(int numeroDeFuncionariosNecessarios) {
        this.numeroDeFuncionariosNecessarios = numeroDeFuncionariosNecessarios;
    }

    public void adicionarHorario()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO HORARIO COLUMNS(ID_HORARIO, ID_FUNCIONARIO, SEGUNDA_FEIRA, TERCA_FEIRA, QUARTA_FEIRA, QUINTA_FEIRA, SEXTA_FEIRA, SABADO, DOMINGO, NUMERODEFUNCIONARIOS, ESTADOATIVIDADE, NUMEROFUNCIONARIOSNECESSARIO)" +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_horario);
            st.setInt(2, this.id_funcionario);
            st.setShort(3, this.segunda_feira);
            st.setShort(4, this.terca_feira);
            st.setShort(5, this.quarta_feira);
            st.setShort(6, this.quinta_feira);
            st.setShort(7, this.sexta_feira);
            st.setShort(8, this.sabado);
            st.setShort(9, this.domingo);
            st.setInt(10, this.numeroDeFuncionarios);
            st.setShort(11, this.estadoAtividade);
            st.setInt(12, this.numeroDeFuncionariosNecessarios);


            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Horario> listarHorario()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_HORARIO, ID_FUNCIONARIO, SEGUNDA_FEIRA, TERCA_FEIRA, QUARTA_FEIRA, QUINTA_FEIRA, SEXTA_FEIRA, SABADO, DOMINGO," +
                " NUMERODEFUNCIONARIOS, ESTADOATIVIDADE, NUMEROFUNCIONARIOSNECESSARIO  FROM HORARIO";

        List<Horario> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Horario horario  = new Horario();

                horario.setId_horario(rs.getInt("ID_HORARIO"));
                if (rs.getString("ID_FUNCIONARIO") != null) horario.setId_funcionario(rs.getInt("ID_FUNCIONARIO"));
                if (rs.getString("SEGUNDA_FEIRA") != null) horario.setSegunda_feira(rs.getShort("SEGUNDA_FEIRA"));
                if (rs.getString("TERCA_FEIRA") != null) horario.setTerca_feira(rs.getShort("TERCA_FEIRA"));
                if (rs.getString("QUARTA_FEIRA") != null) horario.setQuarta_feira(rs.getShort("QUARTA_FEIRA"));
                if (rs.getString("QUINTA_FEIRA") != null) horario.setQuinta_feira(rs.getShort("QUINTA_FEIRA"));
                if (rs.getString("SEXTA_FEIRA") != null) horario.setSexta_feira(rs.getShort("SEXTA_FEIRA"));
                if (rs.getString("SABADO") != null) horario.setSabado(rs.getShort("SABADO"));
                if (rs.getString("DOMINGO") != null) horario.setDomingo(rs.getShort("DOMINGO"));
                if (rs.getString("NUMERODEFUNCIONARIOS") != null) horario.setNumeroDeFuncionarios(rs.getInt("NUMERODEFUNCIONARIOS"));
                if (rs.getString("ESTADOATIVIDADE") != null) horario.setEstadoAtividade(rs.getShort("NUMERODEFUNCIONARIOS"));
                if (rs.getString("NUMEROFUNCIONARIOSNECESSARIO") != null) horario.setNumeroDeFuncionariosNecessarios(rs.getInt("NUMEROFUNCIONARIOSNECESSARIO"));

                //

                lista.add(horario);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void editarHorario(String command)
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

    public void eliminarHorario(String command)
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
