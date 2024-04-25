/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package suma;
import javax.swing.JOptionPane;

/**
 *
 * @author mayola
 */
public class Operaciones {

    public String SumarDArk(String n1, String n2) {
        try{
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        int suma = num1+num2;
                return String.valueOf(suma);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e,"Error",1);
                            return String.valueOf("error");

        }
    }

    public int Suma(int num1, int num2) {
        return num1 + num2;
    }

    public int resta(int num1, int num2) {
        return num1 - num2;
    }

    public int multiplicar(int num1, int num2) {
        return num1 * num2;
    }

    public double dividir(double num1, double num2) {
        return num1 / num2;
    }
}
