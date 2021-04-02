package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Vendas
{
    private int id_vendas;
    private int id_cliente;
    private int id_pagamento;
    private float valorTotal;
    private String dataVenda ;

    public int getId_vendas() {
        return id_vendas;
    }

    public void setId_vendas(int id_vendas) {
        this.id_vendas = id_vendas;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void adicionarVendas()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO VENDAS COLUMNSA(ID_VENDA, ID_CLIENTE, ID_PAGAMENTO, VALORTOTAL, DATAVENDA)" +
                " VALUES(?,?,?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_vendas);
            st.setInt(2, this.id_cliente);
            st.setInt(3, this.id_pagamento);
            st.setFloat(4, this.valorTotal);
            st.setString(5, this.dataVenda);

            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<Vendas> listarVendas()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_VENDA, ID_CLIENTE, ID_PAGAMENTO, VALORTOTAL, DATAVENDA  FROM VENDAS";

        List<Vendas> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Vendas vendas  = new Vendas();

                vendas.setId_vendas(rs.getInt("ID_VENDA"));
                if (rs.getString("ID_CLIENTE") != null)vendas.setId_cliente(rs.getInt("ID_CLIENTE"));
                if (rs.getString("ID_PAGAMENTO") != null)vendas.setId_pagamento(rs.getInt("ID_PAGAMENTO"));
                if (rs.getString("VALORTOTAL") != null) vendas.setValorTotal(rs.getFloat("VALORTOTAL"));
                if (rs.getString("DATAVENDA") != null) vendas.setDataVenda(rs.getString("DATAVENDA"));


                //

                lista.add(vendas);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void editarVendas(String command)
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

    public void eliminarVendas(String command)
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
