/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import projeto.Controller.Dados;
/**
 *
 * @author guisx
 */
public class dao {
    private Dados dados;
    
    public dao(Dados dados){
        this.dados = dados;
    }
    
    public Connection getConexao() throws SQLException{
        Connection conexao = (Connection) DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Usuarios",
            "postgres", "milagre123");
        System.out.println("conectado ao banco de dados\n");
        return conexao;
    }
}
