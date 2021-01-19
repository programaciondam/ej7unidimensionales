/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej7arraysuni;

/**
 *
 * @author 203p21
 */
public class Vencimiento {
    private int hasta;
     private float porcentaje;
    

    public Vencimiento(int hasta, float porcentaje) {
        this.hasta = hasta;
        this.porcentaje = porcentaje;
    }

    public int getHasta() {
        return hasta;
    }

    public float getPorcentaje() {
        return porcentaje;
    }
   
    
}
