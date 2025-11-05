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
import projeto.Move.Catalogos;
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
    
    public CatalogoDAO(Connection conexao){
        this.conexao = conexao;
    }
    
    public ResultSet obterDadosEstabelecimento()throws SQLException{
        String sql = "select * from estabelecimento;";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.execute();
        resultadoBusca = statement.getResultSet();
        
        return resultadoBusca;
    }
    
    public void buscarPorPedido(Dashboard principal)throws SQLException{
        String sql = "select * from alimentos;";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.execute();
        resultadoBusca = statement.getResultSet();
        
        ArrayList<alimentos> alimentos = new ArrayList<>();
        while(resultadoBusca.next()){
            alimentos.add(new alimentos(resultadoBusca.getString("nome"), resultadoBusca.getString("local")
                    , resultadoBusca.getDouble("preco")));
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
