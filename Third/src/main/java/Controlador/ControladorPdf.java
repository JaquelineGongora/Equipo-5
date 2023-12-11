/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import BD.Consultador;
import Modelo.Estudiante;
import Vista.ReportesUI;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import static org.apache.commons.io.IOUtils.writer;

/**
 *
 * @author mauro
 */
public class ControladorPdf implements ActionListener{
    
    Estudiante estudiante;
    ReportesUI vista;
    Consultador consultador;
    JTextArea textArea;
   
    

    //Constructor 
    public ControladorPdf(ReportesUI vista, Consultador consultador, Estudiante estudiante){
       this.estudiante=estudiante;
       this.vista = vista;
       this.consultador=consultador;
       this.vista.pdf_button.addActionListener(this);
       this.vista.contancia_btn.addActionListener(this);
       
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
        if(e.getSource()==vista.pdf_button){
            List<Estudiante> estudiantes = consultador.CargarBase();
            try {
                Hacerpdf(estudiantes);
            } catch (BadElementException ex) {
                Logger.getLogger(ControladorPdf.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ControladorPdf.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource()==vista.contancia_btn){
             HacerConstancia();
        }
    }
    
    public void HacerConstancia(){
    
    
    }
    
    public void Hacerpdf(List<Estudiante> estudiantes) throws BadElementException, IOException{
    
        String path = "";
        
        JFileChooser j=new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        int x= j.showSaveDialog(this.vista);
       
        
        if(x==JFileChooser.APPROVE_OPTION){
        
            path=j.getSelectedFile().getPath(); 
        }
        
        
        Document doc = new Document();
        doc.setMargins(20, 20, 20, 20); // Establecer márgenes
        doc.addCreationDate(); // Agregar fecha de creación
        
        try{
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(path+"\\abc123.pdf"));
           
             writer.setPageEvent(new PdfPageEventHelper() {
             @Override
            
            public void onEndPage(PdfWriter writer, Document document) {
            // Agregar el número de página y el pie de página
            int pageNumber = writer.getPageNumber();
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase("Página " + pageNumber),
                    (document.right() + document.left()) / 2, document.bottom() - 10, 0);
            }
            });
            
            
            doc.open();
            PdfContentByte cb = writer.getDirectContent();
            
             // Línea azul
            cb.setColorStroke(new BaseColor(0, 0, 255)); // Azul
            cb.setLineWidth(2f); // Ancho de la línea
             cb.rectangle(doc.left(), doc.bottom(), doc.right() - doc.left(), doc.top() - doc.bottom());
             cb.stroke();

            // Línea dorada
            cb.setColorStroke(new BaseColor(255, 215, 0)); // Dorado
            cb.setLineWidth(2f); // Ancho de la línea
            cb.rectangle(doc.left() + 2, doc.bottom() + 2, doc.right() - doc.left() - 4, doc.top() - doc.bottom() - 4);
            cb.stroke();
            
              // Crear una tabla para el encabezado (logo y título)
            PdfPTable headerTable = new PdfPTable(2);
            headerTable.setWidthPercentage(90);

            // Agregar el logo a la tabla
            Image header = Image.getInstance("C:\\Users\\mauro\\Downloads\\EducacionC\\EC\\src\\main\\java\\img\\logo.jpg");
            header.scaleToFit(100, 150);
            header.setAlignment(Element.ALIGN_LEFT);  // Alineación a la izquierda
      
            // Agregar celda del logo
            PdfPCell logoCell = new PdfPCell(header);
            logoCell.setBorder(Rectangle.NO_BORDER);
            logoCell.setPaddingRight(10);
            headerTable.addCell(logoCell);

            // Agregar celda para "Calificaciones Educación Continua"
            PdfPCell titleCell = new PdfPCell(new Phrase("Calificaciones Educación Continua",
             new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD)));
            titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);  // Alineación a la izquierda
            titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);   // Alineación vertical al centro
            titleCell.setBorder(Rectangle.NO_BORDER);
            headerTable.addCell(titleCell);

            // Agregar celda para "Facultad de Matemáticas"
            PdfPCell title2Cell = new PdfPCell(new Phrase("Facultad de Matemáticas",
                    new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD)));
            title2Cell.setHorizontalAlignment(Element.ALIGN_LEFT);  // Alineación a la izquierda
            title2Cell.setVerticalAlignment(Element.ALIGN_MIDDLE);   // Alineación vertical al centro
            title2Cell.setBorder(Rectangle.NO_BORDER);
            headerTable.addCell(title2Cell);
           
            
          
            
             doc.add(headerTable);
             doc.add(new Paragraph(" ")); 
             //doc.add(tabla);
           
             PdfPTable tbl = new PdfPTable(8);
            tbl.setWidthPercentage(90);
            
            float[] columnWidths = { 15f, 26f, 30f, 6f, 6f, 6f, 6f, 6f };
            tbl.setWidths(columnWidths);
            
            // Establecer el color de fondo para las celdas de encabezado
                BaseColor headerColor = new BaseColor(150, 220, 235); // Puedes ajustar estos valores según tu preferencia
                Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK); // Color del texto en las celdas de encabezado

                // Añadir las celdas de encabezado a la tabla con color de fondo
                PdfPCell headerCell;

                headerCell = new PdfPCell(new Phrase("Matricula", headerFont));
                headerCell.setBackgroundColor(headerColor);
                tbl.addCell(headerCell);

                headerCell = new PdfPCell(new Phrase("Nombre", headerFont));
                headerCell.setBackgroundColor(headerColor);
                tbl.addCell(headerCell);
                
                headerCell = new PdfPCell(new Phrase("Diplomado", headerFont));
                headerCell.setBackgroundColor(headerColor);
                tbl.addCell(headerCell);

                headerCell = new PdfPCell(new Phrase("I", headerFont));
                headerCell.setBackgroundColor(headerColor);
                tbl.addCell(headerCell);

                headerCell = new PdfPCell(new Phrase("II", headerFont));
                headerCell.setBackgroundColor(headerColor);
                tbl.addCell(headerCell);

                headerCell = new PdfPCell(new Phrase("III", headerFont));
                headerCell.setBackgroundColor(headerColor);
                tbl.addCell(headerCell);

                headerCell = new PdfPCell(new Phrase("IV", headerFont));
                headerCell.setBackgroundColor(headerColor);
                tbl.addCell(headerCell);

                headerCell = new PdfPCell(new Phrase("Final", headerFont));
                headerCell.setBackgroundColor(headerColor);
                tbl.addCell(headerCell);
             
            
            for(Estudiante estudiante : estudiantes) {
                tbl.addCell(String.valueOf(estudiante.getMatricula()));
                PdfPCell nombreCell = new PdfPCell(new Phrase(estudiante.getNombre()));
                nombreCell.setFixedHeight(30f); // Establecer la altura fija
                tbl.addCell(nombreCell);
                PdfPCell diplomadoCell = new PdfPCell(new Phrase(this.vista.jComboBox1.getSelectedItem().toString()));
                diplomadoCell.setFixedHeight(30f); // Establecer la altura fija
                tbl.addCell(diplomadoCell);
                tbl.addCell(String.valueOf(estudiante.getCalif1()));
                tbl.addCell(String.valueOf(estudiante.getCalif2()));
                tbl.addCell(String.valueOf(estudiante.getCalif3()));
                tbl.addCell(String.valueOf(estudiante.getCalif4()));
                PdfPCell finalCell = new PdfPCell(new Phrase(String.valueOf(estudiante.getCalif())));
    
                // Cambiar el color de fondo basado en la condición
                 if (estudiante.getCalif() < 60) {
                finalCell.setBackgroundColor(BaseColor.RED);
                 } else {
               finalCell.setBackgroundColor(BaseColor.GREEN);
                }
    
                 tbl.addCell(finalCell);

                }
            doc.add(tbl);
            
        // Añadir espacio entre la tabla y el texto final
         doc.add(new Paragraph(" "));

        // Agregar texto al final de la última página
        
        Paragraph textoFinal = new Paragraph(" Le presentamos el informe de calificaciones correspondiente al período 2023. Este documento refleja el rendimiento académico y la evaluación detallada en cada modulo de su respectivo diplomado. Observamos con atención los logros obtenidos y las áreas en las que pueden existir oportunidades de mejora. Este informe proporciona una visión objetiva del desempeño de los alumnos y puede servir como punto de partida para la reflexión y la planificación futura. Si tiene alguna pregunta o requiere aclaraciones sobre el informe, no dude en ponerse en contacto con nosotros.", new Font(Font.FontFamily.TIMES_ROMAN, 12));
       textoFinal.setAlignment(Element.ALIGN_CENTER);
         doc.add(textoFinal);
        
        } catch (FileNotFoundException ex){
            Logger.getLogger(ControladorPdf.class.getName()).log(Level.SEVERE, null, ex);
        }catch (DocumentException ex){
             Logger.getLogger(ControladorPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close(); 
    
    }
   
    
    
}
