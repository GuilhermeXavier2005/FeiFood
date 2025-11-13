/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.Move;

/**
 *
 * @author guisx
 */
public class Catalogos {
    private String nome, local, cardapio;
    private int pedidosId;
    
    public Catalogos(String nome, String local, String cardapio){
        this.nome = nome;
        this.local = local;
        this.cardapio = cardapio;
    }

    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    public String getCardapio() {
        return cardapio;
    }

    public int getPedidosId() {
        return pedidosId;
    }
}
