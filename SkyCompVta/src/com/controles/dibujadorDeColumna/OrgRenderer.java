/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controles.dibujadorDeColumna;

import com.entidades.Organizacion;
import com.servicio.ServOrganizacion;
import java.awt.Component;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author misanchez
 */
public class OrgRenderer extends DefaultTableCellRenderer {

    private int idTipoOrg;

    public OrgRenderer(int idTipoOrg) {
        this.idTipoOrg = idTipoOrg;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        List<Organizacion> lst = ServOrganizacion.getListado(idTipoOrg, value.toString());
        if (lst.isEmpty()) {
            System.out.println("vacio");
        } else {
            this.setValue(lst.get(0));
        }

        return this;
    }
}