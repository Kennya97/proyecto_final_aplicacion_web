/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import com.sun.tools.ws.wsdl.document.Output;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class GenerarPDF {
    //se definen las fuentes 
    public static final Font FuenteTitulos = FontFactory.getFont(FontFactory.TIMES_ROMAN,18, Font.BOLD);
    public static final Font FuenteSubtitulo = FontFactory.getFont(FontFactory.TIMES_ITALIC,12, Font.NORMAL);
    //para poder seguir con los reportes se crea otra de estas, con difeentes
    //parametros dependiendo de la tabla 
    //y la cantidad de campos que posea utilizando la lista, el bucle y el 
    //objeto de la tabla(ejem: Categoria Tabla, Producto Tabla )
    //se define FUNCION GenerarPDF
    public static void Generar_PDF (OutputStream nombre_archivo, List tablaCategorias){
        //definir 
        try {
            Document documento = new Document();
            try {
                //habilitando la escritura en el pdfWriter
                PdfWriter.getInstance(documento, nombre_archivo);
            } catch (Exception e) {
                System.out.println("Ay amigo vuelve a intentarlo! " +e);
            }
            
            documento.open();
            // Meta data
            documento.addAuthor("cotuzos");
            documento.addSubject("muricion");
            documento.addTitle("ProyectoFinal");
            
            //se crea una pagina :3 
            Paragraph titulo = new Paragraph(new Phrase("Registros de Categoria", FuenteSubtitulo));
            // Alinear
            titulo.setAlignment(Chunk.ALIGN_CENTER);
            //add documento
            documento.add(titulo);
            // crear la tabla
            int numeroColumnas = 3;
            PdfPTable registro = new  PdfPTable(numeroColumnas);
            //crear la cabecera
            PdfPCell Cabecera = new PdfPCell();
            // alinear celdas(texto)
            Cabecera.setHorizontalAlignment(Element.ALIGN_CENTER);
            // Nombre de la celda
            Cabecera.setPhrase(new Paragraph("ID",FuenteSubtitulo));
            registro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("NOMBRE CATEGORIA",FuenteSubtitulo));
            registro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("ESTADO",FuenteSubtitulo));
            registro.addCell(Cabecera);
            
            for(int i = 0; i < tablaCategorias.size(); i++){
                Categoria Tabla = (Categoria) tablaCategorias.get(i);
                
                Cabecera.setPhrase(new Paragraph(String.valueOf(Tabla.getId_categoria()),FuenteSubtitulo));
                registro.addCell(Cabecera);
                Cabecera.setPhrase(new Paragraph(Tabla.getNom_categoria(),FuenteSubtitulo));
                registro.addCell(Cabecera);
                Cabecera.setPhrase(new Paragraph(String.valueOf(Tabla.getEstado_categoria()),FuenteSubtitulo));
                registro.addCell(Cabecera);
            }
            
            // Salto dea l
            Chunk saltosdeliena = new Chunk(Chunk.NEWLINE);
            documento.add(saltosdeliena);
            documento.add(registro);
            documento.close();
        } catch (Exception e) {
            System.out.println("No amigo aqui tampoco es " + e);
        }
    }
    
    
    //aqui debo seguir con la siguiente tabla ( Productos)
    public static void GeneraPDFProducto(OutputStream nombre_archivo, List tablaProducto){
        
    }

    public static void GeneraPDFUsuario(OutputStream Salida, List tablaUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
