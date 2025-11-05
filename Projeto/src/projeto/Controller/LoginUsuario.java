/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.Controller;

import DAO.dao;
import DAO.usuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import projeto.Move.Usuarios;
import projeto.View.Dashboard;
import projeto.View.Login;

/**
 *
 * @author guisx
 */
public class LoginUsuario {
    private Login login;
    private Dashboard dashboard;
    
    public LoginUsuario(Login login){
        this.login = login;
        dashboard = new Dashboard(this);
    }
    
    public void validarLogin(String usuario, String senha){
        Dados dados = new Dados();
        try{
            dados.getDaoJava().getConexao();
            Connection conexao = dados.getDaoJava().getConexao();
            usuarioDAO usuarioDao = new usuarioDAO(conexao);
            Usuarios usuarioLogin = new Usuarios(usuario,null,null,senha);
            if(usuarioDao.consultar(usuarioLogin)){
                dashboard.setVisible(true);
            }
            else{
                login.getLogin().setText("usuario inválido");
                login.getSenha().setText("senha inválida");
            }
        }catch(SQLException e){
            System.out.println("erro "+ e);
        }
        
        
        
    }
}
