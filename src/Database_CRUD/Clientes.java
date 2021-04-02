package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Clientes               //LOGIN,ADD2CART,COMPRAR,SHOP_HISTORY,RECLAMAÇÕES
{
    private int id_cliente;
    private String nome;
    private String data_nascimento;
    private String email;
    private String senha;
    private String nif;
    private String caixaPostal;
    private short rua;
    private short porta;
    private short lote;
    private String telefone;
    private int id_login;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getCaixaPostal() {
        return caixaPostal;
    }

    public void setCaixaPostal(String caixaPostal) {
        this.caixaPostal = caixaPostal;
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

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public void adicionarClientes()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO Clientes COLUMNS(ID_CLIENTE, NOME_CLIENTE, DATA_NASCIMENTO, EMAIL, SENHA, NIF, CAIXAPOSTAL, RUA, PORTA, LOTE, TELEFONE, ID_LOGIN)" +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_cliente);
            st.setString(2, this.nome);
            st.setString(3, this.data_nascimento);
            st.setString(4, this.email);
            st.setString(5, this.senha);
            st.setString(6, this.nif);
            st.setString(7, this.caixaPostal);
            st.setShort(8, this.rua);
            st.setShort(9, this.porta);
            st.setShort(10, this.lote);
            st.setString(11, this.telefone);
            st.setInt(12, this.id_login);

            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Clientes> listarClientes()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_Clientes,ID_ARMAZEM,CORREDOR  FROM Clientes";

        List<Clientes> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Clientes clientes  = new Clientes();

                clientes.setId_cliente(rs.getInt("ID_UNIDADEMEDIDA"));
                if (rs.getString("ID_ARMAZEM") != null) clientes.setNome(rs.getString("ID_ARMAZEM"));
                if (rs.getString("CORREDOR") != null) clientes.setData_nascimento(rs.getString("CORREDOR"));
                if (rs.getString("CORREDOR") != null) clientes.setEmail(rs.getString("CORREDOR"));
                if (rs.getString("CORREDOR") != null) clientes.setSenha(rs.getString("CORREDOR"));
                if (rs.getString("CORREDOR") != null) clientes.setNif(rs.getString("CORREDOR"));
                if (rs.getString("CORREDOR") != null) clientes.setCaixaPostal(rs.getString("CORREDOR"));
                if (rs.getString("CORREDOR") != null) clientes.setRua(rs.getShort("CORREDOR"));
                if (rs.getString("CORREDOR") != null) clientes.setPorta(rs.getShort("CORREDOR"));
                if (rs.getString("CORREDOR") != null) clientes.setLote(rs.getShort("CORREDOR"));
                if (rs.getString("CORREDOR") != null) clientes.setTelefone(rs.getString("CORREDOR"));
                if (rs.getString("CORREDOR") != null) clientes.setId_login(rs.getInt("CORREDOR"));
                //

                lista.add(clientes);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void editarClientes(String command)
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

    public void eliminarClientes(String command)
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
