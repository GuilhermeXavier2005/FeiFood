/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import projeto.Move.Usuarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author guisx
 */
public class usuarioDAO {
    private Connection conexao;
    
    public usuarioDAO(Connection conexao){
        this.conexao = conexao;
    }
    
    public ResultSet consultarTudo()throws SQLException{
        String sql = "select * from usuario;";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.execute();
        ResultSet resultadoBusca = statement.getResultSet();
        while(resultadoBusca.next()){
            System.out.println("Nome: "+ resultadoBusca.getString("nome"));
            System.out.println("contato: "+ resultadoBusca.getString("contato"));
            System.out.println("Nome: "+ resultadoBusca.getString("cpf"));
        }
        return resultadoBusca;
    }
    
    public boolean consultar(Usuarios usuario)throws SQLException{
        String sql = "select * from usuario where nome = ? and senha = ?;";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        while(resultado.next()){
            if(resultado.getString("nome").equals(usuario.getNome()) && resultado.getString("senha").equals(usuario.getSenha())){
                return true;
            }
        }
        return false;
    }
    
    public void inserir(Usuarios usuario)throws SQLException{
        String sql = "insert into usuario (nome,cpf,contato,senha) values('" 
                + usuario.getNome() + "','" + usuario.getCpf() + "','" + usuario.getContato() + "','"
                + usuario.getSenha() +
                "');" ;
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.execute();
        conexao.close();
    }
    
    public void atualizar(Usuarios usuario) throws SQLException{
        String sql = "update usuario set senha = ? where cpf = ? ;";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, usuario.getSenha());
        statement.setString(2, usuario.getCpf());
    }
    
    public void remover(Usuarios usuario) throws SQLException{
        String sql = "delete from usuario where cpf = ? ;";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, usuario.getCpf());
        statement.execute();
        conexao.close();
    }
    
    public void teste(){
        System.out.println("testando metodos");
    }
}
