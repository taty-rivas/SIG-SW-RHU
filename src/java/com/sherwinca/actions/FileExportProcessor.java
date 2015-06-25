package com.sherwinca.actions;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Taty
 */
@ManagedBean
@ViewScoped
public class FileExportProcessor implements Serializable{
    private final Object IMAGE_FOLDER="resources";
    private final Object LOGOS_FOLDER="img";
    
    /*Exportando a PDF*/
    public void preProcessPDF(Object document) throws IOException, DocumentException {
        Document pdf = (Document) document;
        System.out.println("pdf "+ pdf);
        pdf.setPageSize(PageSize.LETTER.rotate());
        PdfPTable pdfTable = new PdfPTable(2); 
        pdfTable.addCell(getImage("logo.png"));
        pdfTable.setWidthPercentage(40f);
        pdfTable.setHorizontalAlignment(0);
        
        pdf.add(pdfTable);
     
    }
    
    private Image getImage(String imageName) throws IOException, BadElementException {
		final Image image = Image.getInstance(getAbsolutePath(imageName));
		image.scalePercent(90f);
		return image;
	}
    private String getAbsolutePath(String imageName) {
		final ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		final StringBuilder logo = new StringBuilder().append(servletContext.getRealPath(""));
		logo.append(File.separator).append(IMAGE_FOLDER);
		logo.append(File.separator).append(LOGOS_FOLDER);
		logo.append(File.separator).append(imageName);
		return logo.toString();
	}
    
    
    /*Exportando a Excel*/
     public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        CellStyle style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
 
        for (Row row : sheet) {
            for (Cell cell : row) {
                cell.setCellStyle(style);
            }
        }
    }
}