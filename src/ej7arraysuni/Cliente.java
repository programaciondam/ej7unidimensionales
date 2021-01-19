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
public class Cliente {
    private String cif;
    private String nombre;
    private Fecha fechFactura;
    private int diasVencimiento;
    private float importe;

    public Cliente() {
    }

    public String getCif() {
        return cif;
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFechFactura() {
        return fechFactura;
    }

    public int getDiasVencimiento() {
        return diasVencimiento;
    }

    public float getImporte() {
        return importe;
    }

    public void nuevoCliente(String cif, String nombre,
            Fecha fechFactura, int diasVencimiento, float importe) {
       this.cif = cif;
        this.nombre = nombre;
        this.fechFactura = fechFactura;
        this.diasVencimiento = diasVencimiento;
        this.importe = importe;
    }
    
}
