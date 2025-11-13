/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.Move;

/**
 *
 * @author guisx
 */
public class Usuarios {
    private String nome, cpf, contato, senha;
    
    public Usuarios(String nome, String cpf, String contato, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
        this.senha = senha;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getContato() {
        return contato;
    }
}
