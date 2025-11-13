/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.Move;

/**
 *
 * @author guisx
 */
public class Bebidas extends alimentos{
    private double impostoAlcool;

    public double getImpostoAlcool() {
        return impostoAlcool;
    }

    public Bebidas(String nome, String local, double preco, double impostoAlcool) {
        super(nome, local, preco);
        this.impostoAlcool = impostoAlcool*1.15;
    }
}
