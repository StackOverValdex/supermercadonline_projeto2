package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pagamentos
{
    private int id_pagamento;
    private int id_metodopagamento;
    private float valorPago;

    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public int getId_metodopagamento() {
        return id_metodopagamento;
    }

    public void setId_metodopagamento(int id_pagamentos) {
        this.id_metodopagamento = id_pagamentos;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public static List<Pagamentos> listarPagamentos()
    {
        Connection conn = oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_PAGAMENTO, ID_METODOPAGAMENTO,VALORPAGO FROM PAGEMENTO";

        List<Pagamentos> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                Pagamentos pagamentos  = new Pagamentos();

                pagamentos.setId_pagamento(rs.getInt("ID_PAGAMENTO"));
                //
                if (rs.getString("ID_METODOPAGAMETO") != null) pagamentos.setId_metodopagamento(rs.getInt("ID_METODOPAGAMETO"));
                if (rs.getString("VALORPAGO") != null) pagamentos.setValorPago(rs.getFloat("VALORPAGO"));
                //

                lista.add(pagamentos);
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }

        return lista;
    }

    public void eliminarMetodosPagamento(String command)
    {
        // PreparedStatement
        Connection conn = oracleDB_connection.createConnection();

        String sqlCommand =  command;

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
