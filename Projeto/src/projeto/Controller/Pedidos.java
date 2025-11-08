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
    
    public Pedidos(Dashboard principal){
        this.principal = principal;
    }
    
    public void buscarPedidos(Dashboard principal)throws SQLException{
        try{
            Connection conexao = dados.getDaoJava().getConexao(); 
            CatalogoDAO catalogoDao = new CatalogoDAO(conexao);
            
            catalogoDao.buscarPorPedido(principal);
        }catch(SQLException e){
            System.out.println("erro ao consultar cardapios : "+ e);
        }
    }
    
    public void verCardapios(Dashboard principal)throws SQLException{
        try{
            Connection conexao = dados.getDaoJava().getConexao(); 
            CatalogoDAO catalogoDao = new CatalogoDAO(conexao);
            
            catalogoDao.consultarCardapio(principal);
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
    
    public void adicionarPedidoCarrinho(Dashboard principal)throws SQLException{
        try{
            Connection conexao = dados.getDaoJava().getConexao(); 
            CatalogoDAO catalogoDao = new CatalogoDAO(conexao);
            
            catalogoDao.inserirCarrinho(principal);
        }catch(SQLException e){
            System.out.println("erro ao acessar carrinho: erro "+ e);
        }
    }
}
