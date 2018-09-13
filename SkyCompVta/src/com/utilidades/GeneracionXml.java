/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilidades;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author misanchez
 */
public class GeneracionXml {
    public static String objectToString(Object obj){
        XStream xs = new XStream(new DomDriver());
        try {
            return xs.toXML(obj);
        } catch (Exception e) {
            
        } finally{
            return null;
        }
    }
    
    public static <T> T stringToObject(Class<T> clase, String xml){
        XStream xs = new XStream(new DomDriver());
        try {
            return clase.cast(xs.fromXML(xml));
        } catch (Exception e) {
           return null; 
        } 
    }
}
