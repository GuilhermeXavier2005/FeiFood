/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.Controller;

import DAO.CatalogoDAO;
import java.sql.Connection;
import projeto.Move.Catalogos;
import projeto.View.Dashboard;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author guisx
 */
public class Pedidos {
    private Dashboard principal;
    Dados dados = new Dados();
    private double idPedido;
    private boolean pedidoConsultado = false;
    
    public Pedidos(Dashboard principal){
        this.principal = principal;
    }
    
    public void catalogo(Dashboard principal)throws SQLException{
         try{
            Connection conexao = dados.getDaoJava().getConexao(); 
            CatalogoDAO catalogoDao = new CatalogoDAO(conexao);
            
            catalogoDao.catalogo(principal);
        }catch(SQLException e){
            System.out.println("erro ao consultar cardapios : "+ e);
        }
    }
    
    public void buscarPedidos(Dashboard principal)throws SQLException{
        try{
            Connection conexao = dados.getDaoJava().getConexao(); 
            CatalogoDAO catalogoDao = new CatalogoDAO(conexao);
            
            catalogoDao.buscarPorPedido(principal);
        }catch(SQLException e){
            System.out.println("erro ao consultar pedidos : "+ e);
        }
    }
    
    public void cancelarPedido(Dashboard principal)throws SQLException{
        try{
            Connection conexao = dados.getDaoJava().getConexao(); 
            CatalogoDAO catalogoDao = new CatalogoDAO(conexao);
            
            catalogoDao.cancelarPedido(principal);
        }catch(SQLException e){
            System.out.println("erro ao consultar cardapios : "+ e);
        }
    }
    
    public void refeitoriosPadrao(Dashboard principal)throws SQLException{
        try{
           Connection conexao = dados.getDaoJava().getConexao(); 
           CatalogoDAO catalogoDao = new CatalogoDAO(conexao);
           
           catalogoDao.consultarTudo(principal);
           
        }catch(SQLException e){
            System.out.println("erro ao ver refeitorios padrão: "+ e);
        }
    }
    
    public void carrinho(Dashboard principal)throws SQLException{
        try{
            Connection conexao = dados.getDaoJava().getConexao(); 
            CatalogoDAO catalogoDao = new CatalogoDAO(conexao);
            
            catalogoDao.obterCarrinho(principal);
        }catch(SQLException e){
            System.out.println("erro ao adicionar item ao carrinho: erro " + e);
        }
    }
    
    public double verificaPedido(){
        System.out.println(pedidoConsultado);
        if(pedidoConsultado == false){
            idPedido = Math.round(Math.random()*100);
            pedidoConsultado = true;
            return idPedido;
        }
        else{
            return idPedido;
        }
    }

    public double getIdPedido() {
        return idPedido;
    }
    
    public void adicionarPedidoCarrinho(Dashboard principal)throws SQLException{
        try{
            Connection conexao = dados.getDaoJava().getConexao(); 
            CatalogoDAO catalogoDao = new CatalogoDAO(conexao);
            
            verificaPedido();
            catalogoDao.inserirCarrinho(principal, idPedido);
        }catch(SQLException e){
            System.out.println("erro ao acessar carrinho: erro "+ e);
        }
    }
    
    public void excluirNoCarrinho(Dashboard principal) throws SQLException{
        try{
            Connection conexao = dados.getDaoJava().getConexao(); 
            CatalogoDAO catalogoDao = new CatalogoDAO(conexao);
            
            catalogoDao.excluirNoCarrinho(principal);
        }catch(SQLException e){
            System.out.println("erro ao excluir produto no carrinho: erro "+ e);
        }
    }
}
