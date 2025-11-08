/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.Move;

/**
 *
 * @author guisx
 */
public class Carrinho {
    private String estabelecimento, produto, usuario;
    private double idPedido, preco;

    public String getProduto() {
        return produto;
    }
    
    public Carrinho(String estabelecimento,String produto, double idPedido, double preco, String usuario) {
        this.estabelecimento = estabelecimento;
        this.produto = produto;
        this.idPedido = idPedido;
        this.preco = preco;
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public double getPreco() {
        return preco;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public double getIdPedido() {
        return idPedido;
    }
    
}
