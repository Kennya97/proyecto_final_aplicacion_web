/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
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
    public static final Font FuenteSubtitulo = FontFactory.getFont(FontFactory.TIMES_ITALIC,12, Font.NORMAL,BaseColor.BLACK); 
    public static final Font FuenteHormiga = FontFactory.getFont(FontFactory.TIMES_ROMAN,11, Font.NORMAL,BaseColor.WHITE);
    public static final Font FuenteMiniHormiga = FontFactory.getFont(FontFactory.TIMES_ITALIC,9, Font.NORMAL,BaseColor.BLACK);
    public static final Font FuenteCabecera = FontFactory.getFont(FontFactory.TIMES_ITALIC,12,Font.NORMAL, BaseColor.WHITE);
 
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    public GenerarPDF() {
    }
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
            Paragraph titulo = new Paragraph(new Phrase("Registros de Categoria", FuenteTitulos));
            // Alinear
            titulo.setAlignment(Chunk.ALIGN_CENTER);
            //add documento
            documento.add(titulo);
            // crear la tabla
            int numeroColumnas = 3;
            PdfPTable registro = new  PdfPTable(numeroColumnas);
            //crear la cabecera
            PdfPCell Cabecera = new PdfPCell();
            Cabecera.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cabecera.setBackgroundColor(BaseColor.BLACK);
            // alinear celdas(texto)
            Cabecera.setHorizontalAlignment(Element.ALIGN_CENTER);
            // Nombre de la celda
            Cabecera.setPhrase(new Paragraph("ID",FuenteCabecera));
            registro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("NOMBRE CATEGORIA",FuenteCabecera));
            registro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("ESTADO",FuenteCabecera));
            registro.addCell(Cabecera);
            
            for(int i = 0; i < tablaCategorias.size(); i++){
                Categoria Tabla = (Categoria) tablaCategorias.get(i);
                Cabecera.setBackgroundColor(BaseColor.WHITE);
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
        
        try{
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
            Paragraph titulo = new Paragraph(new Phrase("Registros de Productos", FuenteTitulos));
            
            // Alinear
            titulo.setAlignment(Chunk.ALIGN_CENTER);
            //add documento
            documento.add(titulo);
            PdfPTable tablaRegistro = new PdfPTable(8);
            // Definir cabecera
            PdfPCell Cabecera = new PdfPCell();
            Cabecera.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cabecera.setBackgroundColor(BaseColor.BLACK);
            Cabecera.setPhrase(new Paragraph("Nombre", FuenteCabecera));
            tablaRegistro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("Descripcion", FuenteCabecera));
            tablaRegistro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("Stock", FuenteCabecera));
            tablaRegistro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("Precio", FuenteCabecera));
            tablaRegistro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("Unidad Medidad", FuenteCabecera));
            tablaRegistro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("Estado", FuenteCabecera));
            tablaRegistro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("Categoria", FuenteCabecera));
            tablaRegistro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("Fecha Ingreso", FuenteCabecera));
            tablaRegistro.addCell(Cabecera);        
            // Asignar cabecera
            tablaRegistro.setHeaderRows(1);
            // Rellenar
            for(int i = 0; i < tablaProducto.size(); i++){
                Producto producto = (Producto) tablaProducto.get(i);
                PdfPCell Cuerpo = new PdfPCell();
                Cuerpo.setBackgroundColor(BaseColor.WHITE);
                Cuerpo.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cuerpo.setPhrase(new Paragraph(producto.getNom_producto(),FuenteSubtitulo));
                tablaRegistro.addCell(Cuerpo);
                Cuerpo.setPhrase(new Paragraph(producto.getDes_producto(),FuenteSubtitulo));
                tablaRegistro.addCell(Cuerpo);
                Cuerpo.setPhrase(new Paragraph(String.valueOf(producto.getStock()),FuenteSubtitulo));
                tablaRegistro.addCell(Cuerpo);
                Cuerpo.setPhrase(new Paragraph(String.valueOf(producto.getPrecio()),FuenteSubtitulo));
                tablaRegistro.addCell(Cuerpo);
                Cuerpo.setPhrase(new Paragraph(producto.getUnidadMedida(),FuenteSubtitulo));
                tablaRegistro.addCell(Cuerpo);
                Cuerpo.setPhrase(new Paragraph(String.valueOf(producto.getEstado()),FuenteSubtitulo));
                tablaRegistro.addCell(Cuerpo);
                Cuerpo.setPhrase(new Paragraph(String.valueOf(producto.getCategoria_id()),FuenteSubtitulo));
                tablaRegistro.addCell(Cuerpo);
                Cuerpo.setPhrase(new Paragraph(String.valueOf(producto.getFecha_entrada()),FuenteSubtitulo));
                tablaRegistro.addCell(Cuerpo);
            }
            tablaRegistro.setWidthPercentage(100); // ancho tabla completa 
            
                        // Salto dea l
            Chunk saltosdeliena = new Chunk(Chunk.NEWLINE);
            documento.add(saltosdeliena);
            documento.add(tablaRegistro);
            documento.close();
        }catch(Exception e){
            System.out.println("No amigo aqui tampoco es " + e);
        }

    }

    public static void GeneraPDFUsuario(OutputStream Salida, List tablaUsuario) {
        try {
            Document documento = new Document();
            try {
                //habilitando la escritura en el pdfWriter
                PdfWriter.getInstance(documento, Salida);
            } catch (Exception e) {
                System.out.println("amigo tiene que hacer las cosas bien!!" + e);
            }
            documento.open();
            // Meta data
            documento.addAuthor("cotuzos");
            documento.addSubject("muricion");
            documento.addTitle("ProyectoFinal");
            //se crea una pagina :3 
            Paragraph titulo = new Paragraph(new Phrase("Registros de Usuarios", FuenteTitulos));

            // Alinear
            titulo.setAlignment(Chunk.ALIGN_CENTER);
            // Se agrega al documento
            documento.add(titulo);
            PdfPTable tablaRegistro = new PdfPTable(10);
            // Definir cabecera
            PdfPCell Cabecera = new PdfPCell();
            Cabecera.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cabecera.setBackgroundColor(BaseColor.BLACK);
            Cabecera.setPhrase(new Paragraph("Nombre", FuenteHormiga));
            tablaRegistro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("Apellido", FuenteHormiga));
            tablaRegistro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("Correo", FuenteHormiga));
            tablaRegistro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("Usuario", FuenteHormiga));
            tablaRegistro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("Clave", FuenteHormiga));
            tablaRegistro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("Tipo", FuenteHormiga));
            tablaRegistro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("Estado", FuenteHormiga));
            tablaRegistro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("Pregunta", FuenteHormiga));
            tablaRegistro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("Respuesta", FuenteHormiga));
            tablaRegistro.addCell(Cabecera);
            Cabecera.setPhrase(new Paragraph("Fecha Registro", FuenteHormiga));
            tablaRegistro.addCell(Cabecera);

            // Asignar cabecera
            tablaRegistro.setHeaderRows(1);
            // Rellenar
            for(int i = 0; i < tablaUsuario.size(); i++){
                Usuarios usuario = (Usuarios) tablaUsuario.get(i);

                PdfPCell Cuerpo = new PdfPCell();
                Cuerpo.setBackgroundColor(BaseColor.WHITE);
                Cuerpo.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cuerpo.setPhrase(new Paragraph(usuario.getNombre(),FuenteMiniHormiga));
                tablaRegistro.addCell(Cuerpo);
                Cuerpo.setPhrase(new Paragraph(usuario.getApellido(),FuenteMiniHormiga));
                tablaRegistro.addCell(Cuerpo);
                Cuerpo.setPhrase(new Paragraph(String.valueOf(usuario.getCorreo()),FuenteMiniHormiga));
                tablaRegistro.addCell(Cuerpo);
                Cuerpo.setPhrase(new Paragraph(usuario.getUsuario(),FuenteMiniHormiga));
                tablaRegistro.addCell(Cuerpo);
                Cuerpo.setPhrase(new Paragraph(String.valueOf(usuario.getClave().hashCode()),FuenteMiniHormiga));
                tablaRegistro.addCell(Cuerpo);
                String tipo = (usuario.getTipo() == 1 )? "Administrador" : "Cliente";
                Cuerpo.setPhrase(new Paragraph(tipo,FuenteMiniHormiga));
                tablaRegistro.addCell(Cuerpo);
                String estado =(String.valueOf(usuario.getEstado()).equalsIgnoreCase("1"))? "Activo" : "Inactivo";
                Cuerpo.setPhrase(new Paragraph(estado,FuenteMiniHormiga));
                tablaRegistro.addCell(Cuerpo);
                Cuerpo.setPhrase(new Paragraph(String.valueOf(usuario.getPregunta()),FuenteMiniHormiga));
                tablaRegistro.addCell(Cuerpo);
                Cuerpo.setPhrase(new Paragraph(String.valueOf(usuario.getRespuesta().hashCode()),FuenteMiniHormiga));
                tablaRegistro.addCell(Cuerpo);
                Cuerpo.setPhrase(new Paragraph(usuario.getFecha_registro(),FuenteMiniHormiga));
                tablaRegistro.addCell(Cuerpo);
            }
            tablaRegistro.setWidthPercentage(100); // ancho tabla completa
            Chunk saltosdeliena = new Chunk(Chunk.NEWLINE);
            documento.add(saltosdeliena);
            documento.add(tablaRegistro);
            documento.close();

        } catch (Exception e) {
            System.out.println("sigue participando " + e);
        }
    }

}
