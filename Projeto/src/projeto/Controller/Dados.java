/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.Controller;

import DAO.dao;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import projeto.View.Cadastro;
import java.sql.SQLException;
import projeto.Move.Usuarios;

/**
 *
 * @author guisx
 */
public class Dados {
    ArrayList<Usuarios> dados = new ArrayList<>();
    private String nome, CPF, contato;
    
    private dao daoJava;
    
    public Dados() {
        daoJava = new dao(this);
    }

    public dao getDaoJava() {
        return daoJava;
    }
    
    public Dados(String nome, String CPF, String contato){
        this.nome = nome;
        this.CPF = CPF;
        this.contato = contato;
    }
    
    public void processaDados(String nome, String CPF, String contato, String senha){
        try{
            //dados.add(new Dados(nome,CPF,contato));
            dados.add(new Usuarios(nome, CPF, contato, senha));
            try{
                daoJava.getCadastrarUsuario().cadastrar(nome,CPF,contato,senha);
            }catch(SQLException e){
                System.out.println("Impossivel conectar ao banco\n" + e);
            }
            popUp();
        }catch(NullPointerException e){
            System.out.println("erro" + e);
        }
        
    }

    public ArrayList<Usuarios> getDados() {
        return dados;
    }
    
    public void exibir(){
        for(int contador=0;contador<dados.size();contador++){
            System.out.println("-----------------------");
            System.out.println(dados.get(contador).getNome());
            System.out.println(dados.get(contador).getContato());
            System.out.println(dados.get(contador).getCpf());
        }
    }
    
    public void popUp(){
        JFrame jFrame = new JFrame();
        jFrame.setSize(200, 200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Cadastro concluído!", SwingConstants.CENTER);

        jFrame.add(label);

        jFrame.setVisible(true);
    }
}
