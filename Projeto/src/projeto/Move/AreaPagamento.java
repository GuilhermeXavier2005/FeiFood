/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.Move;

/**
 *
 * @author guisx
 */
public class AreaPagamento {
    private String pagamento;
    private int avaliacao;
    private double total, idpedido;
    
    public AreaPagamento(double idpedido, String pagamento, int avaliacao, double total){
        this.idpedido = idpedido;
        this.pagamento = pagamento;
        this.avaliacao = avaliacao;
        this.total = total;
    }
}
