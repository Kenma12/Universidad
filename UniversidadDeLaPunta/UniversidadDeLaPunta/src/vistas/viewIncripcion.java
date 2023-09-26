/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import AccesoADatos.InscripcionData;
import entidades.Alumno;
import entidades.AlumnoServices;
import entidades.Inscripcion;
import entidades.InscripcionServices;
import entidades.Materia;
import entidades.MateriaServices;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enzo-PC
 */
public class viewIncripcion extends javax.swing.JInternalFrame {
    private AlumnoServices alumS = new AlumnoServices();
    private DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<Alumno> alumnos= new ArrayList();
    private InscripcionServices inscS = new InscripcionServices();
    private MateriaServices matS = new MateriaServices();
    ArrayList<Materia> materiasNoInc = new ArrayList<>();
    
    /**
     * Creates new form viewIncripcion
     */
    public viewIncripcion() {
        initComponents();
        cargarBox();
        armarTabla();
        int insalum;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboAlumnos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jRadioInsc = new javax.swing.JRadioButton();
        jRadioNoInsc = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMaterias = new javax.swing.JTable();
        btnIncripcion = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Seleccione un alumno:");

        jComboAlumnos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jComboAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAlumnosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Formulario de Incripcion");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Listado de Materias");

        jRadioInsc.setText("Materias Incriptas");
        jRadioInsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioInscActionPerformed(evt);
            }
        });

        jRadioNoInsc.setText("Materias no inscriptas");
        jRadioNoInsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioNoInscActionPerformed(evt);
            }
        });

        tblMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblMaterias);

        btnIncripcion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnIncripcion.setText("Inscribir");
        btnIncripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncripcionActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton2.setText("Anular Inscripcion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo cerrar.png"))); // NOI18N
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnIncripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jRadioInsc)
                        .addGap(43, 43, 43)
                        .addComponent(jRadioNoInsc))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1)
                        .addGap(58, 58, 58)
                        .addComponent(jComboAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioInsc)
                    .addComponent(jRadioNoInsc))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIncripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioNoInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioNoInscActionPerformed
        
       jRadioInsc.setSelected(false);
       //prueba si borra filas 
       borrarfilas();
       
       InscripcionData insc = new InscripcionData();
       
       Alumno alum = (Alumno) jComboAlumnos.getSelectedItem();
       
       String activo;
       
       for (Materia a:insc.materiaNoCursada(alum.getIdAlumno())){
           activo = (a.isActivo()) ? "si" : "no";
           modelo.addRow(new Object []{a.getIdMateria(),a.getNombre(),a.getAnioMateria(),activo });
       }
        tblMaterias.setModel(modelo);
       
        
        
    }//GEN-LAST:event_jRadioNoInscActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void jComboAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAlumnosActionPerformed
        jRadioInsc.setSelected(false);
        jRadioNoInsc.setSelected(false);
        modelo.setRowCount(0);
    }//GEN-LAST:event_jComboAlumnosActionPerformed

    private void jRadioInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioInscActionPerformed
        jRadioNoInsc.setSelected(false);
        //prueba si borra las filas 
        borrarfilas();
        //estoy trabajando aca hay que corregir la impresion de los datos en la tabla y combo 
        InscripcionData insc = new InscripcionData();
       Alumno alum= (Alumno) jComboAlumnos.getSelectedItem();
       insc.listarInscriptosPorAlumno(alum.getIdAlumno());
       //int insalum = (Integer) alum.getIdAlumno();

       String activo;
       
       for (Inscripcion a:insc.listarInscriptosPorAlumno(alum.getIdAlumno())){
           activo = (a.getMateria().isActivo()) ? "Si" : "No";
           modelo.addRow(new Object []{a.getIdIncripcion(),a.getMateria().getNombre()
                   ,a.getMateria().getAnioMateria(), activo });
       }
           tblMaterias.setModel(modelo);
        
    }//GEN-LAST:event_jRadioInscActionPerformed

    private void btnIncripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncripcionActionPerformed
        if(tblMaterias.getSelectedRow() != -1){
            int i = jComboAlumnos.getSelectedIndex();
            Alumno alum = alumnos.get(i);
            
            int idMateria = (Integer) tblMaterias.getValueAt(tblMaterias.getSelectedRow(), 0);
            Materia materia =  matS.buscarMateriaXId(idMateria);
            
            Inscripcion aluIns = new Inscripcion (0 ,alum,materia);

            inscS.inscripcionAmateria(0, alum, materia);
            
            modelo.removeRow(tblMaterias.getSelectedRow());
            
        }else{
           JOptionPane.showMessageDialog(null, "Debe seleccionar una materia.");
        }
    }//GEN-LAST:event_btnIncripcionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void cargarBox(){
        alumS.listarAlumnos(alumnos);
        for(Alumno a:alumnos){
            jComboAlumnos.addItem(a);
        }
    }
 
    private void cargarTabla(){
//      inscS.listarInscripciones(materiasNoInc);
        matS.listarMaterias(materiasNoInc);
           
        for(Materia a:materiasNoInc){
            modelo.addRow(new Object[]{
             a.getIdMateria(),a.getNombre(),a.getAnioMateria(),a.isActivo()}) ;  
            }
        tblMaterias.setModel(modelo);
        }
    
     
    private void borrarfilas(){
        int filas=tblMaterias.getRowCount()-1;
        for(int f=filas; f>=0;f--){
           modelo.removeRow(f);
        };
    }
    
    
        
    
    
    
    
    
    
    private void armarTabla(){
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        modelo.addColumn("Activo");
        tblMaterias.setModel(modelo);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnIncripcion;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<Alumno> jComboAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioInsc;
    private javax.swing.JRadioButton jRadioNoInsc;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblMaterias;
    // End of variables declaration//GEN-END:variables
}
