/*
 * $Id: ColumnControlButton.java,v 1.15 2005/10/13 08:59:56 kleopatra Exp $
 *
 * Copyright 2004 Sun Microsystems, Inc., 4150 Network Circle,
 * Santa Clara, California 95054, U.S.A. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package com.controles;

import com.utilidades.PersonalFileFilter;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import org.apache.poi.hssf.usermodel.*;

/**
 * This class is installed in the upper right corner of the table and is a
 * control which allows for toggling the visibilty of individual columns.
 * 
 * TODO: the table reference is a potential leak
 * 
 * TODO: no need to extend JButton - use non-visual controller returning
 * a JComponent instead.
 * 
 */
public final class HColumnControlButton extends JButton {

    /** exposed for testing. */
    protected JPopupMenu popupMenu = null;
    /** the table which is controlled by this. */
    private JXTable table;

    /**
     * Constructor de la clase
     * @param table
     * @param icon
     */
    public HColumnControlButton(JXTable table, Icon icon) {
        super();
        init();
        setAction(createControlAction(icon));
        installTable(table);
    }

    @Override
    public void updateUI() {
        super.updateUI();
        setMargin(new Insets(1, 2, 2, 1)); // Make this LAF-independent
        if (popupMenu != null) {
            // JW: Hmm, not really working....
            popupMenu.updateUI();
        }
    }

    /** 
     * open the popup. 
     * 
     * hmmm... really public?
     * 
     *
     */ 
    public void togglePopup() {
        if (popupMenu.isVisible()) {
            popupMenu.setVisible(false);
        } else if (popupMenu.getComponentCount() > 0) {
            Dimension buttonSize = getSize();
            popupMenu.show(this, buttonSize.width, buttonSize.height);
        }
    }

    /**
     * Asociacion de la tabla al control
     * @param table
     */
    private void installTable(JXTable table) {
        this.table = table;
        JMenuItem jmiExpXml = new JMenuItem("Exportar a Excel...", new ImageIcon(HColumnControlButton.class.getResource("/com/recursos/excel.png")));
        jmiExpXml.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearArchivoXLS();
            }
        });
        popupMenu.add(jmiExpXml);
    }

    /**
     * Crea el archivo XLS con los datos de la tabla
     */
    private void crearArchivoXLS(){
        int numRow;
        int numCol;
        String sTmp ;
        Object obj;
        TableCellRenderer r;
        Component c;
        HSSFRow row;
        HSSFCell cell;
        HSSFWorkbook libroXLS = new HSSFWorkbook();
        HSSFSheet hojaXLS = libroXLS.createSheet();

        HSSFCellStyle estiloCelda = libroXLS.createCellStyle();
        estiloCelda.setWrapText(false);
        estiloCelda.setAlignment(HSSFCellStyle.ALIGN_JUSTIFY);
        estiloCelda.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);

        row = hojaXLS.createRow(hojaXLS.getPhysicalNumberOfRows());
        for(numCol=0; numCol<table.getColumnCount(); numCol++){
            sTmp = table.getColumnName(numCol);
            if(sTmp == null)
                sTmp = "";
            cell = row.createCell(numCol);
            cell.setCellStyle(estiloCelda);
            cell.setCellValue(sTmp);
        }

        for(numRow=0; numRow<table.getRowCount(); numRow++){
            row = hojaXLS.createRow(hojaXLS.getPhysicalNumberOfRows());
            for(numCol = 0; numCol<table.getColumnCount(); numCol++){
                cell = row.createCell(numCol);
                obj = table.getValueAt(numRow, numCol);
                if(obj != null){
                    r = table.getCellRenderer(numRow, numCol);
                    c = table.prepareRenderer(r, numRow, numCol);
                    if(c != null){
                        //System.out.println(obj.getClass());
                        if(obj.getClass().equals(java.lang.String.class))
                            cell.setCellValue(obj.toString());
                        else if (obj.getClass().equals(java.lang.Integer.class))
                            cell.setCellValue((Integer)obj);
                        else if(obj.getClass().equals(java.util.Date.class))
                            cell.setCellValue((java.util.Date)obj);
                        else if(obj.getClass().equals(java.math.BigDecimal.class))
                            cell.setCellValue(((java.math.BigDecimal)obj).setScale(2).floatValue());
                        else
                            cell.setCellValue(obj.toString());
                    }
                }
            }
        }

        sTmp = getUbicacionNuevoArchivo(table, "xls", "Libro de Excel");

        if(!sTmp.equals("")){
            try{
                FileOutputStream archivoXLS = new FileOutputStream(sTmp.concat(".xls"));
                libroXLS.write(archivoXLS);
                archivoXLS.close();
            } catch(IOException e){
                System.out.println("Error en creacion de xls: "+e.getMessage());
            }
        }
    }

    /**
     * Initialize the column control button's gui
     */
    private void init() {
        setFocusPainted(false);
        setFocusable(false);
        popupMenu = new JPopupMenu();
    }


    /** 
     * the action created for this.
     * 
     * @param icon
     * @return
     */
    private Action createControlAction(Icon icon) {
        Action control = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                togglePopup();
            }
        };
        control.putValue(Action.SMALL_ICON, icon);
        return control;
    }
    
    /**
     * Retorna la ubicacion seleccionada en donde se espera que se cree un nuevo archivo
     * @param main
     * @param exts
     * @param descripExts
     * @return
     */
    public String getUbicacionNuevoArchivo(Component main, String exts, String descripExts){
        JFileChooser jfcNuevoArchivo = new JFileChooser(System.getProperty("user.home"));
        jfcNuevoArchivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfcNuevoArchivo.setFileFilter(new PersonalFileFilter(exts.split(","), descripExts));

        int seleccion = jfcNuevoArchivo.showSaveDialog(main);

        if (seleccion == JFileChooser.APPROVE_OPTION){
            return jfcNuevoArchivo.getSelectedFile().getAbsolutePath();
        }
        return "";
    }
} 
