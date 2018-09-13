package com.utilidades;

import java.io.File;
import java.util.Hashtable;
import java.util.Enumeration;
import javax.swing.filechooser.*;

/**
 *
 * @author MISanchez
 */
public class PersonalFileFilter extends FileFilter {

    private Hashtable filters = null;
    private String description = null;
    private String fullDescription = null;
    private boolean useExtensionsInDescription = true;

    /**
     * Constructor de la clase
     */
    public PersonalFileFilter() {
        this.filters = new Hashtable();
    }

    /**
     * Constructor de la clase
     * @param extension
     */
    public PersonalFileFilter(String extension) {
        this(extension, null);
    }

    /**
     * Constructor de la clase
     * @param extension
     * @param description
     */
    public PersonalFileFilter(String extension, String description) {
        this();
        if (extension != null) {
            addExtension(extension);
        }
        if (description != null) {
            setDescription(description);
        }
    }

    /**
     * Constructor de la clase
     * @param filters
     */
    public PersonalFileFilter(String[] filters) {
        this(filters, null);
    }

    /**
     * Constructor de la clase
     * @param filters
     * @param description
     */
    public PersonalFileFilter(String[] filters, String description) {
        this();
        for (int i = 0; i < filters.length; i++) {
            addExtension(filters[i]);
        }
        if (description != null) {
            setDescription(description);
        }
    }

    public boolean accept(File f) {
        if (f != null) {
            if (f.isDirectory()) {
                return true;
            }
            String extension = getExtension(f);
            if (extension != null && filters.get(getExtension(f)) != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna la extencion de un archivo
     * @param f
     * @return
     */
    public String getExtension(File f) {
        if (f != null) {
            String filename = f.getName();
            int i = filename.lastIndexOf('.');
            if (i > 0 && i < filename.length() - 1) {
                return filename.substring(i + 1).toLowerCase();
            }
        }
        return null;
    }

    /**
     * Agrega una extension
     * @param extension
     */
    public void addExtension(String extension) {
        if (filters == null) {
            filters = new Hashtable(5);
        }
        filters.put(extension.toLowerCase(), this);
        fullDescription = null;
    }

    public String getDescription() {
        if (fullDescription == null) {
            if (description == null || isExtensionListInDescription()) {
                fullDescription = description == null ? "(" : description + " (";
                Enumeration extensions = filters.keys();
                if (extensions != null) {
                    fullDescription += "." + (String) extensions.nextElement();
                    while (extensions.hasMoreElements()) {
                        fullDescription += ", " + (String) extensions.nextElement();
                    }
                }
                fullDescription += ")";
            } else {
                fullDescription = description;
            }
        }
        return fullDescription;
    }

    /**
     * Establece la descripcion de una extension
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
        fullDescription = null;
    }

    /**
     * 
     * @param b
     */
    public void setExtensionListInDescription(boolean b) {
        useExtensionsInDescription = b;
        fullDescription = null;
    }

    /**
     *
     * @return
     */
    public boolean isExtensionListInDescription() {
        return useExtensionsInDescription;
    }
}
