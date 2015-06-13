/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sherwinca.actions;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import java.io.File;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Taty
 */
@ManagedBean
@ViewScoped
public class FileExportProcessor {
    private FileExportProcessor processor;

    /**
     * Creates a new instance of PreProcessDocument
     */
    public FileExportProcessor() {
        processor = new FileExportProcessor();
    }
    
    
  
    
    public void preProcessPDF(Object document) {
      Document pdf = (Document) document;
      pdf.setPageSize(PageSize.A4.rotate());
      pdf.open();
    }
}
