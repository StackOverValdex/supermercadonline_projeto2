package Database_CRUD;

import com.company.oracleDB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinhasEncomendas
{
    
    private int id_encomenda;
    private int id_produto;
    private int quantidade;
    private float preco;
    private String descricao;

    public int getId_encomenda() {
        return id_encomenda;
    }

    public void setId_encomenda(int id_encomenda) {
        this.id_encomenda = id_encomenda;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getpreco() {
        return preco;
    }

    public void setpreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static List<LinhasEncomendas> listarLinhasEncomendas()
    {
        Connection conn = oracleDB_connection.createConnection() ;

        String sqlCommand = "SELECT ID_ENCOMENDA, ID_PRODUTO,QUANTIDADE,PRECO,DESCRICAO FROM LINHASENCOMENDAS";

        List<LinhasEncomendas> lista = new ArrayList<>();

        try
        {
            PreparedStatement st = conn.prepareStatement(sqlCommand);


            ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                LinhasEncomendas linhasencomendas = new LinhasEncomendas();

                linhasencomendas.setId_encomenda(rs.getInt("ID_ENCOMENDA"));
                linhasencomendas.setId_produto(rs.getInt("ID_PRODUTO"));

                if (rs.getString("QUANTIDADE") != null) linhasencomendas.setQuantidade(rs.getInt("QUANTIDADE"));
                if (rs.getString("PRECO") != null) linhasencomendas.setpreco(rs.getFloat("PRECO"));
                if (rs.getString("DESCRICAO") != null) linhasencomendas.setDescricao(rs.getString("DESCRICAO"));
                //
            }

        } catch (SQLException ex)
        {
            System.out.println("ERRO: " + ex.getMessage());
        }
        return lista;
    }
}
