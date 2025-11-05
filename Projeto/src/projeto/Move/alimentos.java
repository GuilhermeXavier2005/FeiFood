/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.Move;

/**
 *
 * @author guisx
 */
public class alimentos {
    private String nome, local;
    private double preco;
    
    public alimentos(String nome, String local, double preco){
        this.nome = nome;
        this.local = local;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    public double getPreco() {
        return preco;
    }
}
