/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Vista;
import Controlador.ControladorEstudiante;
import Controlador.IntroduccionCiber;
import Modelo.Conexion;
import Modelo.ConsultaIntroCiber;
import Modelo.Consultas;
import Modelo.Estudiante;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import static org.apache.poi.sl.usermodel.PresetColor.Desktop;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IntroCiber extends javax.swing.JFrame {

    Estudiante estudiante;
    Conexion conexion= new Conexion();
    DefaultTableModel modelo;
    
   
    
    
    /**
     * Creates new form NewJFrame
     */
    public IntroCiber() {
        
        initComponents();
        setLocationRelativeTo(null);
        /*
        ConsultaIntroCiber consulta = new ConsultaIntroCiber();
        List<Estudiante> estudiantes = consulta.CargarBase();
        IntroduccionCiber control = new IntroduccionCiber(this, consulta, estudiante);
        control.DesplegarTabla(estudiantes);
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        btn_agregarIC = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        txt_nombre = new javax.swing.JTextField();
        txt_matricula = new javax.swing.JTextField();
        txt_Calif = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_estadoDiplomado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_estado1 = new javax.swing.JTextField();
        txt_diplomado = new javax.swing.JTextField();
        btn_mostrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btn_pdf = new javax.swing.JButton();
        excel = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_md4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_md2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_md3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        label1.setText("label1");

        label2.setText("label2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_agregarIC.setText("Agregar");
        btn_agregarIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarICActionPerformed(evt);
            }
        });

        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        txt_nombre.setEditable(false);
        txt_nombre.setText("Nombre");
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });

        txt_matricula.setEditable(false);
        txt_matricula.setText("Matricula");
        txt_matricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_matriculaActionPerformed(evt);
            }
        });

        txt_Calif.setText("Calif");
        txt_Calif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CalifActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jLabel2.setText("Matricula:");

        jLabel3.setText("Calif:");

        jLabel4.setText("Estado Modulo 1:");

        txt_estadoDiplomado.setEditable(false);
        txt_estadoDiplomado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_estadoDiplomadoActionPerformed(evt);
            }
        });

        jLabel5.setText("Estado Diplomado:");

        jLabel6.setText("Calif Diplomado:");

        txt_estado1.setEditable(false);
        txt_estado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_estado1ActionPerformed(evt);
            }
        });

        txt_diplomado.setEditable(false);
        txt_diplomado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_diplomadoActionPerformed(evt);
            }
        });

        btn_mostrar.setText("Mostrar Tabla");
        btn_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarActionPerformed(evt);
            }
        });

        jLabel7.setText("Para generar primero se deben mostrar datos");

        btn_pdf.setText("Generar PDF");
        btn_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pdfActionPerformed(evt);
            }
        });

        excel.setText("Generar Excel");
        excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelActionPerformed(evt);
            }
        });

        jLabel8.setText("Estado Modulo 2:");

        txt_md4.setEditable(false);
        txt_md4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_md4ActionPerformed(evt);
            }
        });

        jLabel9.setText("Estado Modulo 3 :");

        txt_md2.setEditable(false);
        txt_md2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_md2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Estado Modulo 4:");

        txt_md3.setEditable(false);
        txt_md3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_md3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_estado1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_md2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nombre))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_Calif))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_estadoDiplomado, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(excel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_diplomado, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel7)))
                        .addGap(258, 258, 258))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txt_md3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_md4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(btn_agregarIC)
                .addGap(18, 18, 18)
                .addComponent(btn_limpiar)
                .addGap(18, 18, 18)
                .addComponent(btn_buscar)
                .addGap(18, 18, 18)
                .addComponent(btn_modificar)
                .addGap(40, 40, 40)
                .addComponent(btn_mostrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_diplomado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_estadoDiplomado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Calif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_estado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_md4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_md2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txt_md3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregarIC)
                    .addComponent(btn_limpiar)
                    .addComponent(btn_buscar)
                    .addComponent(btn_modificar)
                    .addComponent(btn_mostrar))
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(btn_pdf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(excel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1033, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel11.setText("Registro de Calificaciones Ciberseguridad para los negocios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1055, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(223, 223, 223))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_matriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_matriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_matriculaActionPerformed

    private void txt_CalifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CalifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CalifActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed

    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_agregarICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarICActionPerformed
        
    }//GEN-LAST:event_btn_agregarICActionPerformed

    private void txt_estadoDiplomadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_estadoDiplomadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_estadoDiplomadoActionPerformed

    private void txt_estado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_estado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_estado1ActionPerformed

    private void txt_diplomadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_diplomadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_diplomadoActionPerformed

    private void btn_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_mostrarActionPerformed

    private void btn_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pdfActionPerformed
      
    }//GEN-LAST:event_btn_pdfActionPerformed

    private void excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelActionPerformed
        // TODO add your handling code here:
        /*
       JFileChooser chooser = new JFileChooser();
       FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
       chooser.setFileFilter(filter);
       chooser.setDialogTitle("Guardar archivo");
       chooser.setAcceptAllFileFilterUsed(false);
       if(chooser.showSaveDialog(null)== JFileChooser.APPROVE_OPTION){
       
       String ruta = chooser.getSelectedFile().toString().concat(".xls");
       
       try{
           File archivoXLS =new File(ruta);
           if(archivoXLS.exists()){
               archivoXLS.delete();
           }
           archivoXLS.createNewFile();
           Workbook libro = new HSSFWorkbook();
           FileOutputStream archivo = new FileOutputStream(archivoXLS);
           Sheet hoja = libro.createSheet("Estudiantes");
           hoja.setDisplayGridlines(false);
           for(int i=0; i<tabla.getRowCount(); i++){
           
            Row fila = hoja.createRow(i);
            for(int e=0; e<tabla.getColumnCount(); e++){
            
                Cell celda = fila.createCell(e);
                    if(i==0){
                        celda.setCellValue(tabla.getColumnName(e));
                    }
                
            } 
           }
           
           int filaInicio=1;
           for(int i=0; i<tabla.getRowCount(); i++){
               Row fila = hoja.createRow(filaInicio);
               filaInicio++;
               for(int e=0; e<tabla.getColumnCount(); e++){
               
                   Cell celda = fila.createCell(e);
                   if(tabla.getValueAt(i,e) instanceof Double){
                       celda.setCellValue(Double.parseDouble(tabla.getValueAt(i,e).toString()));
                   }else if(tabla.getValueAt(i,e) instanceof Float){
                       celda.setCellValue(Float.parseFloat((String) tabla.getValueAt(i, e)));
                       
                   }else{
                       celda.setCellValue(String.valueOf(tabla.getValueAt(i, e)));
                   }
               }
           }
           libro.write(archivo);
           archivo.close();
           
       } catch(IOException | NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Error");
       }
           
       }
       */

        
        
    }//GEN-LAST:event_excelActionPerformed

    private void tabla2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla2MouseClicked
        // TODO add your handling code here:
        
        Estudiante e = new Estudiante();
        ConsultaIntroCiber c = new ConsultaIntroCiber();
        IntroduccionCiber controlador = new IntroduccionCiber(this, c, e);
        controlador.Seleccionar(tabla2, txt_matricula, txt_nombre, txt_Calif, txt_md2, txt_md3, txt_md4, txt_diplomado);
        
    }//GEN-LAST:event_tabla2MouseClicked

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_md4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_md4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_md4ActionPerformed

    private void txt_md2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_md2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_md2ActionPerformed

    private void txt_md3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_md3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_md3ActionPerformed

    
    /*
    public void displayTable(List <Estudiante> estudiante) {
       
        
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
        tabla = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(tabla);
        
         // Agregar la tabla al área de texto (puedes ajustar esto según la estructura de tu interfaz)
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(scrollPane, BorderLayout.CENTER);
        jPanel2.revalidate(); // Asegurar que la interfaz se actualice correctamente
        
    }
    */
 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IntroCiber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntroCiber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntroCiber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntroCiber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntroCiber().setVisible(true);
            }
        });
    }
  
public javax.swing.JTable tabla;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_agregarIC;
    public javax.swing.JButton btn_buscar;
    public javax.swing.JButton btn_limpiar;
    public javax.swing.JButton btn_modificar;
    public javax.swing.JButton btn_mostrar;
    public javax.swing.JButton btn_pdf;
    public javax.swing.JButton excel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    public javax.swing.JTable tabla2;
    public javax.swing.JTextField txt_Calif;
    public javax.swing.JTextField txt_diplomado;
    public javax.swing.JTextField txt_estado1;
    public javax.swing.JTextField txt_estadoDiplomado;
    public javax.swing.JTextField txt_matricula;
    public javax.swing.JTextField txt_md2;
    public javax.swing.JTextField txt_md3;
    public javax.swing.JTextField txt_md4;
    public javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}