/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventaspc.factura;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import ventaspc.empresa.posesiones.Cliente;
import ventaspc.empresa.posesiones.Producto;
/**
 *
 * @author Ivan
 */
public class Factura {
    //Clase utilizada para generar el archivo de pdf de una factura
    
    //Estilos de fuente
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
      Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
      Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
      Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
      Font.BOLD);
    
    public Factura(Cliente cliente, Producto producto){
        Document documento = new Document();
        FileOutputStream ficheroPdf;
        try{
            //Código para la fecha
            Date date = new Date();
            DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd");
            String convertido = fechaHora.format(date);
            
            //Creación del flujo de datos de salida
            ficheroPdf = new FileOutputStream("factura_" + cliente.getCedula() + "_" + producto.getClave() + "_" + convertido + ".PDF");
            PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        try{
            //Serie de métodos que componen a la estructura del pdf, creado utilizando
            //la librería de iText.
            documento.open();
            titulo(documento);
            cuerpoLogo(documento);
            documento.add(new Paragraph(" "));
            cuerpoCliente(documento,cliente);
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            cuerpoVenta(documento,producto);
            documento.close();
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    
    public static void titulo(Document documento){
        documento.addTitle("Factura");
        documento.addSubject("Factura en PDF");
        documento.addAuthor("Ventas PC");
    }
    //Parte superior del archivo pdf
    public static void cuerpoLogo(Document documento) throws BadElementException, IOException, DocumentException{
        Paragraph encabezado = new Paragraph();
        PdfPTable tablaLogo = new PdfPTable(2);
        PdfPCell c = new PdfPCell();
        c.setBorder(Rectangle.NO_BORDER);
        
        Image logo = Image.getInstance("VentasPClogo.png");
        logo.scalePercent(70f);
        encabezado.add(logo);
        //Celdas
        float[] columnWidths = {2f, 3f };

        tablaLogo.setWidths(columnWidths);
        String informacion = "\n\nTecnológico de Monterrey\n"
                + "California 2100, Col. Obregón Norte, C.P. 85010, Ciudad Obregón Sonora.";
        c.addElement(logo);
        PdfPCell c2 = new PdfPCell(new Paragraph(informacion));
        c2.setBorder(Rectangle.NO_BORDER);
        tablaLogo.addCell(c);
        tablaLogo.addCell(c2);
        tablaLogo.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        documento.add(tablaLogo);
    }
    //Parte con los datos del cliente
    public static void cuerpoCliente(Document documento, Cliente cliente) throws DocumentException{
        PdfPTable tabla = new PdfPTable(1);
        String cli = "Cliente: " + cliente.getNombre() + " " + cliente.getApellido();
        String dir = "Dirección: " + cliente.getDireccion();
        String cd = "Ciudad: " + cliente.getCiudad();
        String ced = "Cédula: " + cliente.getCedula();
        tabla.addCell(cli+"\n"+dir+"\n"+cd+"\n"+ced);
        documento.add(tabla);
    }
    //Descripción, importe y el resto de los datos de la computadora
    public static void cuerpoVenta(Document documento, Producto producto) throws DocumentException{
        PdfPTable tabla = new PdfPTable(2);
        PdfPCell descripcion = new PdfPCell(new Phrase(producto.getMarca() + " " + producto.getModelo() + " - " + producto.getHdd() + " HDD " + producto.getRam() + "GB RAM"));
        float[] anchos = {7f,3f};
        tabla.setWidths(anchos);
        
        tabla.addCell("Descripción");
        tabla.addCell("Importe");
        descripcion.setFixedHeight(260f);
        tabla.addCell(descripcion);
        tabla.addCell("$" + producto.getPrecio());
        //Codigo para convertir de numero a letra por Camilo Nova. Tomado de https://github.com/AxiaCore/numero-a-letras
        
        //cell.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT);
        tabla.addCell("Cantidad en letra: " + NumberToLetterConverter.convertNumberToLetter(producto.getPrecio()));
        tabla.addCell("TOTAL: $" + producto.getPrecio());
        documento.add(tabla);
    }
}
