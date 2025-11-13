/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.Controller;

import DAO.pagamentosDAO;
import projeto.View.Pagamentos;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author guisx
 */
public class pagar {
    private Pagamentos areaPagamento;
    Dados dados = new Dados();

    public pagar(Pagamentos areaPagamento) {
        this.areaPagamento = areaPagamento;
    }
    
    public void exibirCarrinho(Pagamentos areaPagamento)throws SQLException {
        try{
            Connection conexao = dados.getDaoJava().getConexao(); 
            pagamentosDAO pagamentos = new pagamentosDAO(conexao);
            
            pagamentos.consultarCarrinho(areaPagamento);
        }catch(SQLException e){
            System.out.println("erro  : "+ e);
        }
    }
    
    public void fecharPedido(Pagamentos areaPagamento, String usuario)throws SQLException{
        try{
            Connection conexao = dados.getDaoJava().getConexao(); 
            pagamentosDAO pagamentos = new pagamentosDAO(conexao);
            pagamentos.fecharPedido(areaPagamento, usuario);
        }catch(SQLException e){
            System.out.println("erro em pagar pedido : "+ e);
        }
    }
    
}
