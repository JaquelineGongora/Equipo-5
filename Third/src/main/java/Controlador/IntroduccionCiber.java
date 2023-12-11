/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConsultaIntroCiber;
import Modelo.Consultas;
import Modelo.Estudiante;
import Vista.IntroCiber ;
import java.awt.Color;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;



public class IntroduccionCiber implements ActionListener {
    
    Estudiante estudiante;
    IntroCiber vista;
    ConsultaIntroCiber consultador;
    JTextArea textArea;
   
    

    //Constructor 
    public IntroduccionCiber(IntroCiber vista, ConsultaIntroCiber consultador, Estudiante estudiante){
       this.estudiante=estudiante;
       this.vista = vista;
       this.consultador=consultador;
       this.vista.btn_agregarIC.addActionListener(this);
       this.vista.btn_modificar.addActionListener(this);
       this.vista.btn_buscar.addActionListener(this);
       this.vista.btn_limpiar.addActionListener(this);
       this.vista.btn_mostrar.addActionListener(this);
       this.vista.btn_pdf.addActionListener(this);
       
    }

    //Funcion Para desplegar Menú
  
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
        if (e.getSource() == vista.btn_agregarIC) {
            AgregarEstudiante();
        } else if (e.getSource() == vista.btn_modificar) {
            ModificarEstudiante();
            Mostrar();
            //List<Estudiante> actualizar = OrdenarId();
           //DesplegarTabla(actualizar);
           limpiarCampos();
        } else if (e.getSource() == vista.btn_buscar) {
            BuscarEstudiante();
        } else if (e.getSource() == vista.btn_limpiar) {
            limpiarCampos();
        } else if(e.getSource()==vista.btn_mostrar){
            Mostrar();
        }else if(e.getSource()==vista.btn_pdf){
            try {
                Hacerpdf();
            } catch (BadElementException ex) {
                Logger.getLogger(IntroduccionCiber.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(IntroduccionCiber.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void Mostrar(){
    
        consultador.MostrarAlumnos(vista.tabla2);
        
    
    }
    
    public void Seleccionar(JTable paramTabla, JTextField matricula, JTextField paramNombres, JTextField calif1, JTextField md2, JTextField md3, JTextField md4, JTextField cfinal){
    
        try {
            
            int fila = paramTabla.getSelectedRow();
            
            if(fila>=0){
                matricula.setText((paramTabla.getValueAt(fila, 0).toString()));
                paramNombres.setText((paramTabla.getValueAt(fila, 1).toString()));
                calif1.setText((paramTabla.getValueAt(fila, 2).toString()));
                cfinal.setText((paramTabla.getValueAt(fila, 6).toString()));
                
                
                boolean dip=true;
                
                 if(Integer.parseInt(paramTabla.getValueAt(fila, 2).toString())>=70){
                    vista.txt_estado1.setText("Aprobado");
                 }else{
                    vista.txt_estado1.setText("Reprobado");
                    dip=false;
                 }
                 
                 if(Integer.parseInt(paramTabla.getValueAt(fila, 3).toString())>=70){
                    vista.txt_md2.setText("Aprobado");
                 }else{
                    vista.txt_md2.setText("Reprobado");
                    dip=false;
                 }
                 
                 if(Integer.parseInt(paramTabla.getValueAt(fila, 4).toString())>=70){
                    vista.txt_md3.setText("Aprobado");
                 }else{
                    vista.txt_md3.setText("Reprobado");
                    dip=false;
                 }
                 
                 if(Integer.parseInt(paramTabla.getValueAt(fila, 5).toString())>=70){
                    vista.txt_md4.setText("Aprobado");
                 }else{
                    vista.txt_md4.setText("Reprobado");
                    dip=false;
                 }
                
                 if(dip){
                    vista.txt_estadoDiplomado.setText("Aprobado");
                }else{
                    vista.txt_estadoDiplomado.setText("Reprobado");
                }
                 
            }else{
                 JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
            
           
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error de Selección");
        }
    
    }
    
   /*
    public void DesplegarTabla(List<Estudiante> estudiante){
        
        // Definir las columnas y los datos para la tabla
        Object[][] data = new Object[estudiante.size()][8];
        String[] columns = {"ID", "Matricula", " Nombre", "Modulo1", "Modulo2", "Modulo3", "Modulo4", "Final"};

        // Llenar los datos de la tabla con la información de los productos
        for (int i = 0; i < estudiante.size(); i++) {
            Estudiante est = estudiante.get(i);
            data[i][0] = est.getId();
            data[i][1] = est.getMatricula();
            data[i][2] = est.getNombre();
            data[i][3] = est.getCalif1();
            data[i][4] = est.getCalif2();
            data[i][5] = est.getCalif3();
            data[i][6] = est.getCalif4();
            data[i][7] = (est.getCalif1() + est.getCalif2() + est.getCalif3() + est.getCalif4())/4;
        }

        // Crear la tabla y configurarla
        vista.tabla = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(vista.tabla);
        
         // Agregar la tabla al área de texto (puedes ajustar esto según la estructura de tu interfaz)
        vista.jPanel2.setLayout(new BorderLayout());
        vista.jPanel2.add(scrollPane, BorderLayout.CENTER);
        vista.jPanel2.revalidate(); // Asegurar que la interfaz se actualice correctamente
    
        vista.tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Verificar que la selección se haya completado
                if (!e.getValueIsAdjusting()) {
                    // Obtener la fila seleccionada
                    int selectedRow = vista.tabla.getSelectedRow();
                    
                    // Actualizar las cajas de texto con los datos de la fila seleccionada
                    vista.txt_matricula.setText(vista.tabla.getValueAt(selectedRow, 1).toString());
                    vista.txt_Calif.setText(vista.tabla.getValueAt(selectedRow, 3).toString());
                    vista.txt_nombre.setText(vista.tabla.getValueAt(selectedRow, 2).toString());
                    
                }
            }
        });
    }
*/
    
    public void Hacerpdf() throws BadElementException, IOException{
    
        String path = "";
        
        JFileChooser j=new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        int x= j.showSaveDialog(this.vista);
       
        
        if(x==JFileChooser.APPROVE_OPTION){
        
            path=j.getSelectedFile().getPath(); 
        }
        
        
        Document doc = new Document();
        
        try{
            PdfWriter.getInstance(doc, new FileOutputStream(path+"\\abc123.pdf"));
           
            doc.open();
            
            
              // Crear una tabla para el encabezado (logo y título)
            PdfPTable headerTable = new PdfPTable(2);
            headerTable.setWidthPercentage(90);

            // Agregar el logo a la tabla
            Image header = Image.getInstance("C:\\Users\\margl\\OneDrive\\Documentos\\EC[1]\\EC\\src\\main\\java\\img\\logo.jpg");
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


            /*// Agregar el logo a la tabla
            Image header = Image.getInstance("C:\\Users\\margl\\OneDrive\\Documentos\\EC[1]\\EC\\src\\main\\java\\img\\logo.jpg");
            header.scaleToFit(100, 100);
            header.setAlignment(Element.ALIGN_LEFT);  // Alineación a la izquierda
            PdfPCell logoCell = new PdfPCell(header);
            logoCell.setBorder(Rectangle.NO_BORDER);
            headerTable.addCell(logoCell);*/
           
            
           /* // Agregar espacio después del logo
            PdfPCell emptyCell = new PdfPCell();
            emptyCell.setBorder(Rectangle.NO_BORDER);
            emptyCell.setFixedHeight(5); // Ajusta la altura según tus necesidades
            headerTable.addCell(emptyCell);*/

            // Agregar el título a la tabla
            /*Paragraph titleParagraph = new Paragraph("Calificaciones Educación Continua",
            new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD));
            PdfPCell titleCell = new PdfPCell(titleParagraph);
            titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);  // Alineación al centro
            titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);   // Alineación vertical al centro
            titleCell.setBorder(Rectangle.NO_BORDER);
            headerTable.addCell(titleCell);
            

            // Agregar el segundo título a la tabla
            Paragraph title2Paragraph = new Paragraph("Facultad de Matemáticas",
            new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD));
            PdfPCell title2Cell = new PdfPCell(title2Paragraph);
            title2Cell.setHorizontalAlignment(Element.ALIGN_CENTER);  // Alineación al centro
            title2Cell.setVerticalAlignment(Element.ALIGN_MIDDLE);   // Alineación vertical al centro
            title2Cell.setBorder(Rectangle.NO_BORDER);
            headerTable.addCell(title2Cell); */
            
            
            
            //logo     
            /*Image header = Image.getInstance("C:/Users/margl/OneDrive/Documentos/EC[1]/EC/src/main/java/img/descarga (6).jpg");
            header.scaleToFit(80,80 ); //checar tamaño
            header.setAlignment(Chunk.ALIGN_RIGHT);
            
            Paragraph encabezado = new Paragraph();
            Font font = new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD); // Fuente grande y negrita
            Phrase frase = new Phrase("Calificaciones educación continua", font);
            encabezado.add(frase);
            
            Paragraph encabezado2 = new Paragraph();
            Font font2 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD); // Fuente grande y negrita
            Phrase frase2 = new Phrase("Facultad de Matemáticas", font2);
            encabezado2.add(frase2);
            
            
            // Agregar el encabezado al documento en la posición deseada
            encabezado.setAlignment(Paragraph.ALIGN_LEFT);
            encabezado.setSpacingBefore(10);
            encabezado.setSpacingAfter(10);
            
            encabezado2.setAlignment(Paragraph.ALIGN_LEFT);
            encabezado2.setSpacingBefore(10);
            encabezado2.setSpacingAfter(10);*/
            

        // Agregar el encabezado al documento
             doc.add(headerTable);
             doc.add(new Paragraph(" ")); 
            
            PdfPTable tbl = new PdfPTable(7);
            tbl.setWidthPercentage(100);
            
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

                headerCell = new PdfPCell(new Phrase("Modulo 1", headerFont));
                headerCell.setBackgroundColor(headerColor);
                tbl.addCell(headerCell);

                headerCell = new PdfPCell(new Phrase("Modulo 2", headerFont));
                headerCell.setBackgroundColor(headerColor);
                tbl.addCell(headerCell);

                headerCell = new PdfPCell(new Phrase("Modulo 3", headerFont));
                headerCell.setBackgroundColor(headerColor);
                tbl.addCell(headerCell);

                headerCell = new PdfPCell(new Phrase("Modulo 4", headerFont));
                headerCell.setBackgroundColor(headerColor);
                tbl.addCell(headerCell);

                headerCell = new PdfPCell(new Phrase("Final", headerFont));
                headerCell.setBackgroundColor(headerColor);
                tbl.addCell(headerCell);
            
        
            
            for(int i=0; i<vista.tabla2.getRowCount(); i++){
        
            
            String Matricula=vista.tabla2.getValueAt(i,0).toString();
            String Nombre=vista.tabla2.getValueAt(i,1).toString();
            String Modulo1=vista.tabla2.getValueAt(i,2).toString();
            String Modulo2=vista.tabla2.getValueAt(i,3).toString();
            String Modulo3=vista.tabla2.getValueAt(i,4).toString();
            String Modulo4=vista.tabla2.getValueAt(i,5).toString();
            String Final=vista.tabla2.getValueAt(i,6).toString();
            
            
            tbl.addCell(Matricula);
            tbl.addCell(Nombre);
            tbl.addCell(Modulo1);
            tbl.addCell(Modulo2);
            tbl.addCell(Modulo3);
            tbl.addCell(Modulo4);
            tbl.addCell(Final);
            }
            doc.add(tbl);
            
            
        } catch (FileNotFoundException ex){
            Logger.getLogger(IntroCiber.class.getName()).log(Level.SEVERE, null, ex);
        }catch (DocumentException ex){
             Logger.getLogger(IntroCiber.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close(); 
    
    }
    
    
    
     public void AgregarEstudiante() {
    llenarEstudianteDesdeVista();
    
    if (consultador.registrar(estudiante)) {
        JOptionPane.showMessageDialog(null, "Estudiante agregado");
        
        if(estudiante.getCalif1() >= 70){
            vista.txt_estado1.setBackground(Color.GREEN);  // Establecer color de fondo verde para aprobado
            vista.txt_estado1.setText("Aprobado");
        } else {
            vista.txt_estado1.setBackground(Color.RED);  // Establecer color de fondo rojo para reprobado
            vista.txt_estado1.setText("Reprobado");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Error al agregar");
        limpiarCampos();
    }
    }

    public void ModificarEstudiante() {
        
        
        int fila =vista.tabla2.getSelectedRow();
        estudiante.setMatricula(Integer.parseInt(vista.tabla2.getValueAt(fila, 0).toString()));
        estudiante.setCalif1(Integer.parseInt(vista.tabla2.getValueAt(fila, 2).toString()));
        estudiante.setCalif2(Integer.parseInt(vista.tabla2.getValueAt(fila, 3).toString()));
        estudiante.setCalif3(Integer.parseInt(vista.tabla2.getValueAt(fila, 4).toString()));
        estudiante.setCalif4(Integer.parseInt(vista.tabla2.getValueAt(fila, 5).toString()));
        estudiante.setCalif(((estudiante.getCalif1()+estudiante.getCalif2()+estudiante.getCalif3()+estudiante.getCalif4())/4));
        
        
        if (consultador.modificar(estudiante)) {
            JOptionPane.showMessageDialog(null, "Estudiante modificado");
            
            
            if(estudiante.getCalif1()>=70){
               vista.txt_estado1.setText("Aprobado");
            }else{
               vista.txt_estado1.setText("Reprobado");
            }
          
          
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar");
            limpiarCampos();
        }
    }


    public List<Estudiante> OrdenarId(){
        List<Estudiante> estudiantes = consultador.CargarBase();
        Collections.sort(estudiantes, Comparator.comparing(Estudiante::getId));
        return estudiantes;
    
    }
    
    public void BuscarEstudiante() {
        estudiante.setMatricula(Integer.parseInt(vista.txt_matricula.getText()));
        if (consultador.buscar(estudiante)) {
            llenarVistaDesdeEstudiante();
            
            if(estudiante.getCalif1()>=70){
               vista.txt_estado1.setText("Aprobado");
            }else{
               vista.txt_estado1.setText("Reprobado");
            }
            
            if(estudiante.getCalif1()<70 || estudiante.getCalif1()<70 || estudiante.getCalif1()<70 || estudiante.getCalif1()<70 ){
            
                vista.txt_estadoDiplomado.setText("Aprobado");
               
            }else{
                vista.txt_estadoDiplomado.setText("Reprobado");
            }
            
            
            int total = (estudiante.getCalif1() + estudiante.getCalif2() + estudiante.getCalif3() + estudiante.getCalif4())/4;
            vista.txt_diplomado.setText(String.valueOf(total));
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Error al buscar");
            limpiarCampos();
        }
    }
    
    
    public void llenarEstudianteDesdeVista() {
        
        estudiante.setMatricula(Integer.parseInt(vista.txt_matricula.getText()));
        estudiante.setNombre(vista.txt_nombre.getText());
        estudiante.setCalif1(Integer.parseInt(vista.txt_Calif.getText()));
    }

    public void llenarVistaDesdeEstudiante() {
        vista.txt_matricula.setText(String.valueOf(estudiante.getMatricula()));
        vista.txt_nombre.setText(estudiante.getNombre());
        vista.txt_Calif.setText(String.valueOf(estudiante.getCalif1()));
        
    }

    public void limpiarCampos() {
       
        vista.txt_nombre.setText("");
        vista.txt_matricula.setText("");
        vista.txt_Calif.setText("");
    }
}