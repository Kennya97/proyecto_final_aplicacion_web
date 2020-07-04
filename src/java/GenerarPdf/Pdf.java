package GenerarPdf;

import com.itextpdf.text.BaseColor;
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
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sun.prism.Image;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet que genera un documento en pdf desde la base de datos
//Usando la libreria itextpdf 5.5.9
//En este caso solo se emplea una consulta de todos los registros dentro de la tabla
//Se pueden filtrar consultas para mostrar diferentes resultados
//o un conjunto de registros seleccionados

@WebServlet(urlPatterns = {"/Pdf"})
public class Pdf extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        try{
            
            try {//Para la conexion a la base de datos
                Connection con = null;
                Statement st = null;
                ResultSet rs = null;
                
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_inventario", "root", "");
                st = (Statement) con.createStatement();
                rs = st.executeQuery("SELECT tb_categoria.nom_categoria, tb_producto.nom_producto, tb_producto.precio FROM tb_categoria INNER JOIN tb_producto ON tb_producto.id_producto = tb_categoria.id_categoria");
                
                if (con != null) {
                   try{
                Document documento = new Document();
                PdfWriter.getInstance(documento, out);
                
                documento.open();
                
                Paragraph par1 = new Paragraph();
                Font fontitulo = new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLACK);
                par1.add(new Phrase("Reporte de registros del inventario en existencia",fontitulo));
                par1.setAlignment(Element.ALIGN_CENTER);
                par1.add(new Phrase(Chunk.NEWLINE));
                documento.add(par1);
                
                Paragraph par2 = new Paragraph();
                Font fondescrip = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL,BaseColor.BLACK);
                par2.add(new Phrase("Descripcion de categoria, nombre y precio del producto", fondescrip));
                par2.setAlignment(Element.ALIGN_CENTER);
                par2.add(new Phrase(Chunk.NEWLINE));
                par2.add(new Phrase(Chunk.NEWLINE));
                documento.add(par2);
                
                PdfPTable tabla = new PdfPTable(3);
                PdfPCell celda1 = new PdfPCell(new Paragraph("Nombre de la categoria", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLUE)));
                PdfPCell celda2 = new PdfPCell(new Paragraph("Nombre producto", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLUE)));
                PdfPCell celda3 = new PdfPCell(new Paragraph("Precio", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLUE)));
                
                tabla.addCell(celda1);
                tabla.addCell(celda2);
                tabla.addCell(celda3);
                
                       while (rs.next()) {                           
                           tabla.addCell(rs.getString(1));
                           tabla.addCell(rs.getString(2));
                           tabla.addCell(rs.getString(3));
                       }
                
                
                documento.add(tabla);
                
                documento.close();
                
            }catch(Exception ex){
                ex.getMessage();
            } 
                }
                
            } catch (Exception ex) {
                ex.getMessage();
            }
            
            
            
        }finally{
        
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
