/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import projeto.Move.Carrinho;
import projeto.Move.Catalogos;
import projeto.Move.Comida;
import projeto.Move.alimentos;
import projeto.View.Dashboard;

/**
 *
 * @author guisx
 */
public class CatalogoDAO {
    private Connection conexao;
    private int contador=0;
    private ResultSet resultadoBusca;
    private String estabelecimento, produto, usuario;
    private double preco;
    
    public CatalogoDAO(Connection conexao){
        this.conexao = conexao;
    }
    
    public ResultSet obterDadosAlimentos(String alimento, String nomeUsuario)throws SQLException{
        String sql = "select * from alimentos;";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.execute();
        resultadoBusca = statement.getResultSet();
        while(resultadoBusca.next()){
            if(alimento.equals(resultadoBusca.getString("nome"))){
                produto = resultadoBusca.getString("nome");
                estabelecimento = resultadoBusca.getString("local");
                preco = resultadoBusca.getDouble("preco");
                usuario = nomeUsuario;
            }
        }
        
        return resultadoBusca;
    }
    
    public ResultSet inserirCarrinho (Dashboard principal) throws SQLException{
        obterDadosAlimentos(principal.getCarrinho().getText(), principal.getUsuario());
        Carrinho carrinho = new Carrinho(estabelecimento, produto, Math.random(), preco, usuario);
        System.out.println("adicionando produto ao carrinho");
        if(produto !=null){
            System.out.println("produto adicionado ao carrinho");
            String sql = "insert into public.pedidos(produto, idpedido, estabelecimento, preco, usuario) values "
                    + "(?,?,?,?,?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, carrinho.getProduto());
            statement.setDouble(2, carrinho.getIdPedido());
            statement.setString(3, carrinho.getEstabelecimento());
            statement.setDouble(4, carrinho.getPreco());
            statement.setString(5, carrinho.getUsuario());
            statement.execute();
            resultadoBusca = statement.getResultSet();

            System.out.println("produto no carrinho");
            principal.getTela1().setText("produto adicionado ao carrinho");
            return resultadoBusca;
        }
        System.out.println("erro ao adicionar alimento ao carrinho");
        principal.getTela1().setText("Não há esse alimento pesquisado no catalogo");
        return null;
    }
    
    public void obterCarrinho(Dashboard principal) throws SQLException{
        String sql = "select * from pedidos;";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.execute();
        resultadoBusca = statement.getResultSet();
        
        ArrayList<Carrinho> carrinho = new ArrayList<>();
        principal.getTela1().setText("");
        while(resultadoBusca.next()){
            carrinho.add(new Carrinho(resultadoBusca.getString("estabelecimento"), 
                    resultadoBusca.getString("produto"), resultadoBusca.getDouble("idpedido"), 0.0, resultadoBusca.getString("usuario")));
            principal.getTela1().setText(principal.getTela1().getText() + "\n");
                principal.getTela1().setText(principal.getTela1().getText()+ "\n" + 
                    "ID: "+carrinho.get(contador).getIdPedido() + "\nDestinatario: " + carrinho.get(contador).getUsuario()
                + "\nEstabelecimento: "+ carrinho.get(contador).getEstabelecimento() + "\nProduto: "+ carrinho.get(contador).getProduto());
            contador++;
        }
    }
    
    public ResultSet obterDadosEstabelecimento()throws SQLException{
        String sql = "select * from estabelecimento;";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.execute();
        resultadoBusca = statement.getResultSet();
        
        return resultadoBusca;
    }
    
    public void buscarPorPedido(Dashboard principal)throws SQLException{
        String sql = "SELECT alimentos.nome, alimentos.preco, alimentos.local, estabelecimento.cardapio FROM public.estabelecimento JOIN alimentos ON alimentos.local = estabelecimento.nome;";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.execute();
        resultadoBusca = statement.getResultSet();
        
        ArrayList<alimentos> alimentos = new ArrayList<>();
        while(resultadoBusca.next()){
            alimentos.add(new Comida(resultadoBusca.getString("nome"), resultadoBusca.getString("local")
                    , resultadoBusca.getDouble("preco"), resultadoBusca.getString("cardapio")));
            if(principal.getBuscador().getText().equals(alimentos.get(contador).getNome())){
                principal.getTela1().setText("");
                principal.getTela1().setText(principal.getTela1().getText()+ "\n" + 
                    "alimento: "+alimentos.get(contador).getNome() + "\npreco: " + alimentos.get(contador).getPreco()
                + "\nlocal: "+ alimentos.get(contador).getLocal());
            }
            contador++;
        }
    }
    
    
    public ArrayList consultarTudo(Dashboard principal) throws SQLException{
        obterDadosEstabelecimento();
        
        ArrayList<Catalogos> catalogos = new ArrayList<>();
        principal.getTela1().setText("");
        while(resultadoBusca.next()){
            catalogos.add(new Catalogos(resultadoBusca.getString("nome"), resultadoBusca.getString("local"),
            resultadoBusca.getString("cardapio")));
            
            principal.getTela1().setText(principal.getTela1().getText()+ "\n" + 
                    "nome: "+catalogos.get(contador).getNome() + "\nlocal: " + catalogos.get(contador).getLocal());
            contador++;
        }
        
        return catalogos;
    }
    
    public ArrayList consultarCardapio(Dashboard principal)throws SQLException{
        obterDadosEstabelecimento();
        
        ArrayList<Catalogos> catalogos = new ArrayList<>();
        principal.getTela1().setText("");
        while(resultadoBusca.next()){
            catalogos.add(new Catalogos(resultadoBusca.getString("nome"), resultadoBusca.getString("local"),
            resultadoBusca.getString("cardapio")));
            
            principal.getTela1().setText(principal.getTela1().getText()+ "\n" + 
                    "Tipo\n: "+catalogos.get(contador).getCardapio());
            contador++;
        }
        
        return catalogos;
    }
}
