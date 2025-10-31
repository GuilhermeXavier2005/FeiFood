/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projeto;

import projeto.Controller.Dados;
import projeto.View.Cadastro;
import projeto.View.Login;

/**
 *
 * @author unifgxavier
 */
public class Projeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dados dados = new Dados();
        Cadastro cadastramento = new Cadastro(dados);
        Login janela = new Login(cadastramento);
        
        janela.setVisible(true);
        
        
        
    }
    
}
