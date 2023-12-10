package Controlador;

import BD.Consultador;
import Modelo.Estudiante;
import Vista.InicioEstudiante;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author mauro
 */
public class ControladorEstudiante implements ActionListener{
    
    Estudiante estudiante;
    InicioEstudiante vista;
    Consultador consultas;
    
    public ControladorEstudiante(Estudiante estudiante, InicioEstudiante vista, Consultador consultas){
        this.estudiante = estudiante;
        this.vista = vista;
        this.vista.botonBuscar.addActionListener(this);
        this.consultas=consultas;
        this.vista.contancia_btn.addActionListener(this);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == vista.botonBuscar) {
            buscar();
        }else if(e.getSource()==vista.contancia_btn){
            try {
                HacerConstancia();
            } catch (DocumentException ex) {
                Logger.getLogger(ControladorReportesInstructor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ControladorReportesInstructor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void buscar(){
        
        llenarDesdeVista();
   
        if(consultas.buscar(estudiante)){
    
            DefaultTableModel modelo = new DefaultTableModel();
            TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
            vista.tablaEst.setRowSorter(OrdenarTabla);

            modelo.addColumn("Matricula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Modulo 1");
            modelo.addColumn("Modulo 2");
            modelo.addColumn("Modulo 3");
            modelo.addColumn("Modulo 4");
            modelo.addColumn("Final");
        
            vista.tablaEst.setModel(modelo);
        
            String[] datos = new String[7];
        
            datos[0]=String.valueOf(estudiante.getMatricula());
            datos[1]=String.valueOf(estudiante.getNombre());
            datos[2]=String.valueOf(estudiante.getCalif1());
            datos[3]=String.valueOf(estudiante.getCalif2());
            datos[4]=String.valueOf(estudiante.getCalif3());
            datos[5]=String.valueOf(estudiante.getCalif4());
         if(estudiante.getCalif1()<=60|| estudiante.getCalif2()<=60 || estudiante.getCalif3()<=60 || estudiante.getCalif4()<=60){
         
              datos[6] = String.valueOf("Reprobado");
         
         }else{
             datos[6] = String.valueOf("Aprobado");
         }
        
                
            modelo.addRow(datos);
        
            vista.tablaEst.setModel(modelo);
            
    
        }else{
            JOptionPane.showMessageDialog(null, "Datos incorrectos o Usuario no existente", "Error", JOptionPane.ERROR_MESSAGE);   
        }
        

    
    }
    
    public void HacerConstancia() throws FileNotFoundException, DocumentException, BadElementException, IOException{
 
        estudiante.setMatricula(Integer.parseInt(vista.tf_matricula.getText()));
        if(consultas.buscar(estudiante)){
        
            if(estudiante.getCalif1()<=60|| estudiante.getCalif2()<=60 || estudiante.getCalif3()<=60 || estudiante.getCalif4()<=60){
                JOptionPane.showMessageDialog(null, "No aprobó el diplomado", "Error", JOptionPane.ERROR_MESSAGE);   
            return;  
            }
            
        }else{
          JOptionPane.showMessageDialog(null, "Matricula no encontrada", "Error", JOptionPane.ERROR_MESSAGE);   
          return;
        }
        
        String nombre = estudiante.getNombre();
        String matricula = String.valueOf(estudiante.getMatricula());
        String diplomado = vista.c_diplomado.getSelectedItem().toString();
        
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
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(path+"\\constancia.pdf"));
           
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
            
            // Configurar el formato de fecha en español
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd MMMM yyyy", new Locale("es", "ES"));

            // Párrafo con fecha actual en español
            Date fechaActual = new Date();
            String fechaFormateada = formatoFecha.format(fechaActual);

            Paragraph parrafoFecha = new Paragraph("Fecha: " + fechaFormateada);
            parrafoFecha.setAlignment(Element.ALIGN_RIGHT);
            parrafoFecha.setIndentationRight(10);
            parrafoFecha.setFont(FontFactory.getFont("Tahoma", 12));
            
            //logo
            Image logo = Image.getInstance("C:\\Users\\mauro\\Downloads\\EducacionC\\EC\\src\\main\\java\\img\\logo.jpg");
            logo.scaleToFit(100, 100);  
            logo.setAlignment(Chunk.ALIGN_LEFT);
            logo.setIndentationLeft(15);
           
            PdfPTable table = new PdfPTable(1);
            table.setWidthPercentage(100);

            // Párrafo 1 (alineación izquierda)
            Paragraph parrafo1 = new Paragraph();
            parrafo1.setAlignment(Element.ALIGN_LEFT);
            parrafo1.add("Educación Continua,");
            parrafo1.setFont(FontFactory.getFont("Tahoma", 70, Font.NORMAL, BaseColor.BLACK));
            parrafo1.setIndentationLeft(15);
            parrafo1.setSpacingAfter(10);

            PdfPCell cell1 = new PdfPCell(parrafo1);
            cell1.setBorder(Rectangle.NO_BORDER);
            cell1.setPadding(10);
            table.addCell(cell1);

            // Párrafo 2 (alineación izquierda)
            Paragraph parrafo2 = new Paragraph();
            parrafo2.setAlignment(Element.ALIGN_LEFT);
            parrafo2.add("Hace constar que el(la) alumno(a) "+nombre+" con la matricula "+matricula+" ha participado satisfactoriamente en el curso/diplomado "+diplomado+" dentro del programa de Educación Continua ofrecido por nuestra institución.");
            parrafo2.setFont(FontFactory.getFont("Tahoma", 70, Font.NORMAL, BaseColor.BLACK));
            parrafo2.setIndentationLeft(15);
            parrafo2.setSpacingAfter(10);

            PdfPCell cell2 = new PdfPCell(parrafo2);
            cell2.setBorder(Rectangle.NO_BORDER);
            cell2.setPadding(10);
            table.addCell(cell2);

            // Párrafo 3 (alineación izquierda)
            Paragraph parrafo3 = new Paragraph();
            parrafo3.setAlignment(Element.ALIGN_LEFT);
            parrafo3.add("Durante el desarrollo de este programa, el(la) estudiante demostró un compromiso excepcional, participación activa y un notable desempeño académico, adquiriendo los conocimientos y habilidades específicos del curso.");
            parrafo3.setFont(FontFactory.getFont("Tahoma", 20, Font.NORMAL, BaseColor.BLACK));
            parrafo3.setIndentationLeft(15);
            parrafo3.setSpacingAfter(10);

            PdfPCell cell3 = new PdfPCell(parrafo3);
            cell3.setBorder(Rectangle.NO_BORDER);
            cell3.setPadding(10);
            table.addCell(cell3);

            // Párrafo 4 (alineación centrada)
            Paragraph parrafo4 = new Paragraph();
            parrafo4.setAlignment(Element.ALIGN_CENTER);
            parrafo4.add("Se extiende la presente constancia a petición del interesado, para los fines que considere pertinentes.");
            parrafo4.setFont(FontFactory.getFont("Tahoma", 70, Font.NORMAL, BaseColor.BLACK));
            parrafo4.setIndentationLeft(15);
            parrafo4.setSpacingAfter(10);

            PdfPCell cell4 = new PdfPCell(parrafo4);
            cell4.setBorder(Rectangle.NO_BORDER);
            cell4.setPadding(10);
            table.addCell(cell4);
            
           Image firma = Image.getInstance("C:\\Users\\mauro\\Downloads\\EducacionC\\EC\\src\\main\\java\\img\\firma.png");
           firma.scaleToFit(250, 250);  // Ajusta el tamaño del logo según tus necesidades
           firma.setAlignment(Chunk.ALIGN_CENTER); 
            
           doc.add(new Paragraph(" ")); 
           doc.add(parrafoFecha);
           doc.add(logo);
           doc.add(new Paragraph(" ")); 
           doc.add(new Paragraph(" ")); 
           doc.add(table);
           doc.add(new Paragraph(" ")); 
           doc.add(new Paragraph(" ")); 
           doc.add(new Paragraph(" ")); 
           doc.add(firma);
            
            } catch (FileNotFoundException | DocumentException ex){
            Logger.getLogger(ControladorReportesInstructor.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close(); 
    }
    
    private void llenarDesdeVista() {
        estudiante.setMatricula(Integer.parseInt(vista.tf_matricula.getText()));
    }
    
}
