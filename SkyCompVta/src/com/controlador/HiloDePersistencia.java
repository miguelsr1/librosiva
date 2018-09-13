/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.utilidades.AccesoAVtaPadre;
import com.utilidades.Reportes;
import com.vistas.paneles.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MISanchez
 */
public class HiloDePersistencia extends Thread {//implements Runnable{

    private int proceso;
    private int param;
    private String titulo;
    private String nameIcono;
    private Thread t;
    private Persistencia panel;
    private HiloMensajeDeUsuario hijoMsjUs;

    public HiloDePersistencia() {
    }

    public void setOperacion(HiloMensajeDeUsuario hijoMsjUs, int proceso) {
        this.hijoMsjUs = hijoMsjUs;
        hijoMsjUs.start();
        this.proceso = proceso;

        send();
    }

    public void setOperacion(HiloMensajeDeUsuario hijoMsjUs, String titulo, String nameIcono, int proceso) {
        this.hijoMsjUs = hijoMsjUs;
        hijoMsjUs.start();
        this.titulo = titulo;
        this.nameIcono = nameIcono;
        this.proceso = proceso;

        send();
    }

    public void setOperacion(HiloMensajeDeUsuario hijoMsjUs, String titulo, String nameIcono, int proceso, int param) {
        this.hijoMsjUs = hijoMsjUs;
        hijoMsjUs.start();
        this.titulo = titulo;
        this.nameIcono = nameIcono;
        this.proceso = proceso;
        this.param = param;

        send();
    }

    @Override
    public void run() {
        try {
            if (proceso > 0 && proceso < 7) {
                switch (proceso) {
                    case 1:
                        panel = new V_Usuarios();
                        panel.setEnabledEliminar(Boolean.TRUE);
                        break;
                    case 2:
                    case 3:
                        panel = new V_Organizacion(param);
                        panel.setEnabledEliminar(Boolean.TRUE);
                        break;
                    case 4:
                        panel = new V_LibroCompras();
                        panel.setEnabledEliminar(Boolean.TRUE);
                        break;
                    case 5:
                        panel = new V_LibroVtaConF();
                        panel.setEnabledEliminar(Boolean.TRUE);
                        break;
                    case 6:
                        panel = new V_LibroVtaContribuyente();
                        panel.setEnabledEliminar(Boolean.TRUE);
                        break;
                }

                hijoMsjUs.finalizar();

                AccesoAVtaPadre.setVisibleVtna(titulo, nameIcono, panel);
            }else{
                switch(proceso){
                    case 7:
                    (new Reportes("rptLibroCompra")).viewRpt();
                    break;
                case 8:
                    (new Reportes("rptLibroVtaCF")).viewRpt();
                    break;
                case 9:
                    (new Reportes("rptLibroVtaContribuyente")).viewRpt();
                    break;
                }
                hijoMsjUs.finalizar();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(AccesoAVtaPadre.vtaPadre, "Error al intentar realizar abrir el formulario!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void send() {
        t = new Thread(this);
        t.start();
    }
}
