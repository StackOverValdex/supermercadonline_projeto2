package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EncomendasAoFornecedor
{
    private int id_encomenda;
    private int id_gestor;
    private int id_forncedor;
    private int id_pagamento;
    private String dataEncomenda;
    private String dataPrevistaEntrega;

    public int getId_encomenda() {
        return id_encomenda;
    }

    public void setId_encomenda(int id_encomenda) {
        this.id_encomenda = id_encomenda;
    }

    public int getId_gestor() {
        return id_gestor;
    }

    public void setId_gestor(int id_gestor) {
        this.id_gestor = id_gestor;
    }

    public int getId_forncedor() {
        return id_forncedor;
    }

    public void setId_forncedor(int id_forncedor) {
        this.id_forncedor = id_forncedor;
    }

    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public String getDataEncomenda() {
        return dataEncomenda;
    }

    public void setDataEncomenda(String dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
    }

    public String getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(String dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public void fazerEncomenda()
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand = "INSERT INTO ENCOMENDAS_AO_FORNECEDOR COLUMNS(" +
                " ID_ENCOMENDA, ID_GESTOR, ID_FORNECEDOR, ID_PAGAMENTO, DATAENCOMENDA, DATAPREVISTAENTREGA) VALUES(?,?,?,?,?,?)";

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);
            st.setInt(1, this.id_encomenda);
            st.setInt(2, this.id_gestor);
            st.setInt(3, this.id_forncedor);
            st.setInt(4, this.id_pagamento);
            st.setString(5,this.dataEncomenda);
            st.setString(6,this.dataPrevistaEntrega);
            

            st.execute();

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }

    public static List<EncomendasAoFornecedor> verEncomendas()
    {
        Connection conn =oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT CAIXAPOSTAL, LOCALIDADE FROM CODIGOPOSTAL";

        List<EncomendasAoFornecedor> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                EncomendasAoFornecedor encomendasaofornecedor  = new EncomendasAoFornecedor();

                encomendasaofornecedor.setId_encomenda(rs.getInt("ID_ENCOMENDA"));
                //
                if (rs.getString("ID_GESTOR") != null) encomendasaofornecedor.setId_gestor(rs.getInt("ID_GESTOR"));
                if (rs.getString("ID_FORNECEDOR") != null) encomendasaofornecedor.setId_forncedor(rs.getInt("ID_FORNECEDOR"));
                if (rs.getString("ID_PAGAMENTO") != null) encomendasaofornecedor.setId_pagamento(rs.getInt("ID_PAGAMENTO"));
                if (rs.getString("DATAENCOMENDA") != null) encomendasaofornecedor.setDataEncomenda(rs.getString("DATAENCOMENDA"));
                if (rs.getString("DATAPREVISTAENTREGA") != null) encomendasaofornecedor.setDataPrevistaEntrega(rs.getString("DATAPREVISTAENTREGA"));
                //

                lista.add(encomendasaofornecedor);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }


    public void eliminarEncomenda(String command)
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
