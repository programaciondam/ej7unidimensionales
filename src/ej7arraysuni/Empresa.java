/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej7arraysuni;

import numeros.Numero;

/**
 *
 * @author 203p21
 */
public class Empresa {

    Cliente[] clientes;
    Vencimiento[] vencimientos;

    public Empresa(int nclientes) {
        clientes = new Cliente[nclientes];
        vencimientos = new Vencimiento[]{
            new Vencimiento(30, 0.1f),
            new Vencimiento(90, 0.07f),
            new Vencimiento(120, 0.05f),
            new Vencimiento(180, 0.02f),
            new Vencimiento(Integer.MAX_VALUE, 0)};
    }

    public void pedir() {
        String nombre;
        String cif;
        float importe;
        int diasVencimiento;
        Fecha ffra;

        for (int ncliente = 0; ncliente < clientes.length; ncliente++) {
            nombre = Numero.pedirString("Introduce el nombre");
            cif = Numero.pedirString("cif:  ");
            diasVencimiento = Numero.pedirNumeroEntero("Dias de vencimiento", 0, 360);
            importe = Numero.pedirNumeroReal("Importe", 0, Float.MAX_VALUE);
            ffra = pedirFecha();
            clientes[ncliente] = new Cliente();
            clientes[ncliente].nuevoCliente(cif, nombre, ffra, diasVencimiento, importe);
        }
    }

    public void informe() {
        float importeNeto;
        Fecha proximoMes = new Fecha();
        proximoMes.proximo();
        float totalImporteNeto = 0;

        Fecha fhoy = new Fecha();
        System.out.println("INFORME DE FACTURAS");
        System.out.println("Fecha:" + fhoy.visualizarLetra());
        System.out.println("CIF \t NOMBRE \t FECHA FRA \t FECHA VENCIMIENTO \t IMPORTE BRUTO \t IMPORTE NETO");
        for (int ncli = 0; ncli < clientes.length; ncli++) {
            Fecha f = clientes[ncli].getFechFactura();
            Fecha fven = new Fecha(f.dia, f.mes, f.getAnno());
            fven.calcularVencimiento(clientes[ncli].getDiasVencimiento());
            importeNeto = clientes[ncli].getImporte()
                    * (1 - busquedaPorcentaje(clientes[ncli].getDiasVencimiento()));
            if (importeNeto > 10000 && fven.getMes() == proximoMes.getMes()
                    && fven.getAnno() == proximoMes.getAnno()) {
                System.out.print(clientes[ncli].getCif() + "\t");
                System.out.print(clientes[ncli].getNombre() + "\t\t");
                System.out.print(clientes[ncli].getFechFactura().visualizar() + "\t\t");
                System.out.print(fven.visualizar() + "\t\t");
                System.out.print(clientes[ncli].getImporte() + "\t\t");
                System.out.println(importeNeto);
                totalImporteNeto = totalImporteNeto + importeNeto;
            }
        }
        System.out.println("Total importe Neto:" + totalImporteNeto);
    }

    private float busquedaPorcentaje(int dven) {
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < vencimientos.length) {
            if (dven < vencimientos[pos].getHasta()) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        return vencimientos[pos].getPorcentaje();
    }

    private Fecha pedirFecha() {
        Fecha f = new Fecha();
        String fecha;
        fecha = Numero.pedirString("Introducir fecha");
        while (!f.comprobarFecha(fecha)) {
            System.out.println("Fecha incorrecta");
            fecha = Numero.pedirString("Introducir fecha");
        }
        return f;
    }
}
