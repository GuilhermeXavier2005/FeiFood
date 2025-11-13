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
    private double idProduto, preco, idpedido;

    public String getProduto() {
        return produto;
    }
    
    public Carrinho(String estabelecimento,String produto, double idProduto, double preco, String usuario, double idpedido) {
        this.estabelecimento = estabelecimento;
        this.produto = produto;
        this.idProduto = idProduto;
        this.preco = preco;
        this.usuario = usuario;
        this.idpedido = idpedido;
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

    public double getIdpedido() {
        return idpedido;
    }

    public double getIdProduto() {
        return idProduto;
    }
    
}
