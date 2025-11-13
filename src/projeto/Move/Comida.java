/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.Move;

/**
 *
 * @author guisx
 */
public class Comida extends alimentos{
    private String tipoComida;

    public String getTipoComida() {
        return tipoComida;
    }
    
    public Comida(String nome, String local, double preco,String tipoComida) {
        super(nome, local, preco);
        this.tipoComida = tipoComida;
    }
    
}
