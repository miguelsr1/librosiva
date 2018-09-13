/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author misanchez
 */
public class Fechas {
    public static Date stringToDate(String fecha) throws ParseException{
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoDeFecha.parse(fecha);
    }
    
    public static String DateToString(Date fecha){
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            return formatoDeFecha.format(fecha);
        } catch (Exception e) {
            
        }
        
        return null;
    }
    
    public static String getNumeroMes(String numeroMes){
        String nombreMes;
        if(numeroMes.trim().length() == 1)
            nombreMes = "0".concat(numeroMes);
        else nombreMes = numeroMes;
        
        return nombreMes;
    }
    
    public static String getNumeroMesPorNombre(String nombreMes){
        if(nombreMes.equals("ENERO"))
            return "01";
        else if(nombreMes.equals("FEBRERO"))
            return "02";
        else if(nombreMes.equals("MARZO"))
            return "03";
        else if(nombreMes.equals("ABRIL"))
            return "04";
        else if(nombreMes.equals("MAYO"))
            return "05";
        else if(nombreMes.equals("JUNIO"))
            return "06";
        else if(nombreMes.equals("JULIO"))
            return "07";
        else if(nombreMes.equals("AGOSTO"))
            return "08";
        else if(nombreMes.equals("SEPTIEMBRE"))
            return "09";
        else if(nombreMes.equals("OCTUBRE"))
            return "10";
        else if(nombreMes.equals("NOVIEMBRE"))
            return "11";
        else
            return "12";
    }
    
    public static String getNombreMes(String numeroMes){
        String nombreMes;
        switch(Integer.parseInt(numeroMes)){
            case 1:
                nombreMes = "ENERO";
                break;
            case 2:
                nombreMes = "FEBRERO";
                break;
            case 3:
                nombreMes = "MARZO";
                break;
            case 4:
                nombreMes = "ABRIL";
                break;
            case 5:
                nombreMes = "MAYO";
                break;
            case 6:
                nombreMes = "JUNIO";
                break;
            case 7:
                nombreMes = "JUNIO";
                break;
            case 8:
                nombreMes = "AGOSTO";
                break;
            case 9:
                nombreMes = "SEPTIEMBRE";
                break;
            case 10:
                nombreMes = "OCTUBRE";
                break;
            case 11:
                nombreMes = "NOVIEMBRE";
                break;
            default:
                nombreMes = "DICIEMBRE";
                break;
        }
        return nombreMes;
    }
    
    public static Date getPrimerDiaDelMes(){
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(System.getProperty("anho")), (Integer.parseInt(System.getProperty("mes"))-1), 1);
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMinimum(Calendar.DAY_OF_MONTH),
                cal.getMinimum(Calendar.HOUR_OF_DAY),
                cal.getMinimum(Calendar.MINUTE),
                cal.getMinimum(Calendar.SECOND));
        return cal.getTime();
    }
    
    public static Date getUltimoDiaDelMes() {
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(System.getProperty("anho")), (Integer.parseInt(System.getProperty("mes"))-1), 1);
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMaximum(Calendar.DAY_OF_MONTH),
                cal.getMaximum(Calendar.HOUR_OF_DAY),
                cal.getMaximum(Calendar.MINUTE),
                cal.getMaximum(Calendar.SECOND));
        return cal.getTime();
    }
    
    public static String getFechaRpt(){
        return getNumeroMes(System.getProperty("mes")).concat(System.getProperty("anho"));
    }
}
