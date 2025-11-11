/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.Move.Carrinho;
import projeto.View.Pagamentos;

/**
 *
 * @author guisx
 */
public class pagamentosDAO {
    private Connection conexao;
    private CatalogoDAO catalogoDao;
    private int contador=0;
    
    public pagamentosDAO(Connection conexao){
        this.conexao = conexao;
        catalogoDao = new CatalogoDAO(conexao);
    }
    
    public ResultSet consultarPedidos()throws SQLException{
        String sql = "select * from pedidos;";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.execute();
        ResultSet buscador = statement.getResultSet();
        ArrayList<Carrinho> carrinho = new ArrayList<>();
        while(buscador.next()){
            carrinho.add(new Carrinho(buscador.getString("estabelecimento"), buscador.getString("produto"), buscador.getDouble("idproduto"),
            buscador.getDouble("preco"), buscador.getString("usuario"), buscador.getDouble("idpedido")));
            System.out.println(carrinho.get(contador).getIdpedido());
            contador++;
        }
        return buscador;
    }
    
    public void consultarCarrinho(Pagamentos areaPagamento) throws SQLException{
        try{
            String sql = "select usuario, SUM(preco) from pedidos group by usuario;";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.execute();
            ResultSet resultadoBusca = statement.getResultSet();

            while(resultadoBusca.next()){
                areaPagamento.getArea().setText("\nusuario: " + resultadoBusca.getString("usuario") + "\ntotal a pagar: "+
                        String.format("%.2f",resultadoBusca.getDouble("sum")));
            }
        }catch(SQLException e){
            System.out.println("erro: "+ e);
        }

    }
    
    public void fecharPedido(Pagamentos areaPagamento, String usuario)throws SQLException{
        String sql = "insert into carrinho (idpedido, pagamento, avaliacao, total) select idpedido,"
                + "? as pagamento,"
                + "? as avaliacao,"
                + "SUM(preco) as total "
                + "from pedidos "
                + "where usuario = ? "
                + "group by idpedido;";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, areaPagamento.getPagamento().getText());
        statement.setInt(2, Integer.parseInt(areaPagamento.getAvalia().getText()));
        statement.setString(3, usuario);
        statement.execute();
        
        areaPagamento.getArea().setText("carrinho pago com sucesso");
    }
}
