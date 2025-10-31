/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.Controller;
import java.sql.SQLException;
import DAO.dao;
import DAO.usuarioDAO;
import java.sql.Connection;
import projeto.Move.Usuarios;

/**
 *
 * @author guisx
 */
public class cadastrarUsuario {
    private dao dao;
    private String nome,cpf,contato,senha;
    
    public cadastrarUsuario(dao dao){
        this.dao = dao;
    }
    
    public void cadastrar(String nome, String cpf, String contato, String senha)throws SQLException{
        try{
            this.nome = nome;
            this.cpf = cpf;
            this.contato = contato;
            this.senha = senha;
            
            Usuarios usuario = new Usuarios(nome,cpf,contato,senha);
            Connection conexao = dao.getConexao();
            usuarioDAO usuarioDao = new usuarioDAO(conexao);
            
            usuarioDao.inserir(usuario);
            usuarioDao.consultarTudo();
            
            System.out.println("usuario cadastrado");
        }catch(NullPointerException e){
            System.out.println("erro ao cadastradar usuario");
        }
        
        
    }
}
