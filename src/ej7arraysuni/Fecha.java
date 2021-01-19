/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej7arraysuni;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author 203p21
 */
public class Fecha {

    int dia;
    int mes;
    int anno;
    static int[] diaMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String [] nombresMes={"ENERO","FEB","MAR","ABR","MAY","JUN","JUL","AGO",
        "SEP","NOV","DIC"};

    public Fecha(int dia, int mes, int anno) {
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
    }
    

    public Fecha() {
        Calendar fhoy = new GregorianCalendar();
        dia = fhoy.get(Calendar.DAY_OF_MONTH);
        mes = fhoy.get(Calendar.MONTH) + 1;
        anno = fhoy.get(Calendar.YEAR);
    }

    public int getDia() {
        return dia;
    }

    public int getAnno() {
        return anno;
    }

    public int getMes() {
        return mes;
    }

    public boolean comprobarFecha(String fecha) {
        boolean resultado = true;
        String[] datos = fecha.split("/");
        if (datos.length != 3) {
            resultado = false;
        } else {
            try {
                dia = Integer.parseInt(datos[0]);
                mes = Integer.parseInt(datos[1]);
                anno = Integer.parseInt(datos[2]);
                if (anno < 1900 || anno > 3000) {
                    resultado = false;
                } else if (mes < 1 || mes > 12) {
                    resultado = false;
                } else if (dia < 1 || dia > diaMes[mes - 1]) {
                    resultado = false;
                } else {
                    resultado = true;
                }
            } catch (NumberFormatException ex) {
                resultado = false;
            }
        }
        return resultado;
    }

    public void calcularVencimiento(int dven) {
        dia = dia + dven;
        while (dia > diaMes[mes - 1]) {
            dia = dia - diaMes[mes - 1];
            mes++;
            if (mes > 12) {
                anno++;
                mes = 1;
            }
        }

    }
    
    public String visualizarLetra(){
        return dia+"-"+nombresMes[mes-1]+"-"+anno;
    }
    public String visualizar(){
        return dia+"/"+mes+"/"+anno;
    }
    public void proximo(){
        mes++;
        if (mes>12){
            mes=1;
            anno++;
        }
    }
}
