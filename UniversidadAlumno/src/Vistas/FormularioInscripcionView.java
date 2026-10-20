/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;
import Entidades.Alumno;
import Entidades.Cursada;
import Entidades.Materia;
import Persistencia.AlumnoData;
import Persistencia.CursadaData;
import Persistencia.MateriaData;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;

public class FormularioInscripcionView extends javax.swing.JInternalFrame {
     private Persistencia.miConexion conexion; 
     private Persistencia.AlumnoData aluData; 
     private Persistencia.MateriaData matData; 
     private Persistencia.CursadaData inscData; 
     private DefaultTableModel modelo;

    
    public FormularioInscripcionView() {
        initComponents();
        this.conexion = new Persistencia.miConexion("jdbc:mariadb://localhost:3306/universidad", "root", ""); 
        this.aluData = new Persistencia.AlumnoData(conexion); 
        this.matData = new Persistencia.MateriaData(conexion);
        this.inscData = new Persistencia.CursadaData(conexion);
        
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que la tabla sea de solo lectura
            }
        };
        
        armarCabeceraTabla();
        cargarAlumnosCombo();
        rbNoInscriptas.setSelected(true);
        cargarMaterias();
    }

    private void armarCabeceraTabla() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        TablaMaterias.setModel(modelo);
    }
    private void cargarAlumnosCombo() {
    cboAlumnos.removeAllItems();
    List<Alumno> lista = aluData.listarAlumnos();
    for (Alumno a : lista) {
        cboAlumnos.addItem(a.getIdAlumno() + "-" + a.getNombre());
    }
}

    private void borrarFilasTabla() {
        int filas = modelo.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private void cargarMaterias() {
        borrarFilasTabla();
        String seleccionado =(String) cboAlumnos.getSelectedItem();
        if (seleccionado != null && !seleccionado.equals("Seleccione Un Alumno")) {
            String[] partes = seleccionado.split("-");
            int idAlumno = Integer.parseInt(partes[0].trim());
            if (rbNoInscriptas.isSelected()) {
                List<Materia> lista = inscData.obtenerMateriasNoInscriptas(idAlumno);
                for (Materia m : lista) {
                    modelo.addRow(new Object[]{m.getIdMateria(),m.getNombre(),"-"});
                }
            } else if (rbInscriptas.isSelected()) {
                List<Cursada> listaCursadas = inscData.obtenerCursadasPorAlumno(idAlumno);
                List<Materia> listaMaterias = inscData.obtenerMateriasInscriptas(idAlumno);
                for (Materia m : listaMaterias) {
                    int id = m.getIdMateria();
                    String nombre = m.getNombre();
                    int anioCursada=0;
                    for (Cursada c : listaCursadas) {
                        if (m.getIdMateria()==c.getIdMateria()) {
                            anioCursada= c.getCursa();
                        }
                    }
                    modelo.addRow(new Object[]{id, nombre,anioCursada});
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgrupo1 = new javax.swing.ButtonGroup();
        cboAlumnos = new javax.swing.JComboBox<>();
        rbInscriptas = new javax.swing.JRadioButton();
        rbNoInscriptas = new javax.swing.JRadioButton();
        btnInscribir = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaMaterias = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        cboAlumnos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Un Alumno" }));
        cboAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAlumnosActionPerformed(evt);
            }
        });

        btgrupo1.add(rbInscriptas);
        rbInscriptas.setText("Materias Inscriptas");
        rbInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbInscriptasActionPerformed(evt);
            }
        });

        btgrupo1.add(rbNoInscriptas);
        rbNoInscriptas.setText("Materias NO inscriptas");
        rbNoInscriptas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbNoInscriptasStateChanged(evt);
            }
        });
        rbNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoInscriptasActionPerformed(evt);
            }
        });

        btnInscribir.setText("Inscribir");
        btnInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirActionPerformed(evt);
            }
        });

        btnAnular.setText("Anular Inscripcion");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        TablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaMaterias);
        if (TablaMaterias.getColumnModel().getColumnCount() > 0) {
            TablaMaterias.getColumnModel().getColumn(3).setHeaderValue("");
        }

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 3, 14)); // NOI18N
        jLabel1.setText("Formulario Inscripcion");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbNoInscriptas, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                .addComponent(rbInscriptas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInscribir)
                                .addGap(78, 78, 78)
                                .addComponent(btnAnular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir)
                                .addGap(18, 18, 18)))))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(cboAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbInscriptas)
                .addGap(5, 5, 5)
                .addComponent(rbNoInscriptas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInscribir)
                    .addComponent(btnAnular)
                    .addComponent(btnSalir))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed
        if (!rbNoInscriptas.isSelected()) {
           javax.swing.JOptionPane.showMessageDialog(this, "Materia ya inscripta");
            return;
        }
        String seleccionado =(String) cboAlumnos.getSelectedItem();
        if (seleccionado != null && !seleccionado.equals("Seleccione Un Alumno")) {
            String[] partes = seleccionado.split("-");
            int idAlumno = Integer.parseInt(partes[0].trim());
        int filaSeleccionada = TablaMaterias.getSelectedRow();
            if (filaSeleccionada == -1) {
                javax.swing.JOptionPane.showMessageDialog(this, "Tiene que seleccionar una fila");
                return;
            } 
            int idMateria = (int) TablaMaterias.getValueAt(filaSeleccionada, 0);
            int anio = LocalDate.now().getYear();
            Cursada c = new Cursada(idAlumno, idMateria, anio);
            inscData.guardarCursadaNull(c);
            javax.swing.JOptionPane.showMessageDialog(this, "Inscripto Correctamente");
            cargarMaterias();
    }//GEN-LAST:event_btnInscribirActionPerformed
    }
    
    private void cboAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAlumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboAlumnosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
 if (!rbInscriptas.isSelected()) {
           javax.swing.JOptionPane.showMessageDialog(this, "La Materia no esta entre sus inscripciones");
            return;
        }
        String seleccionado =(String) cboAlumnos.getSelectedItem();
      int idAlumno = 0;
        if (seleccionado != null && !seleccionado.equals("Seleccione Un Alumno")) {
            String[] partes = seleccionado.split("-");
            idAlumno = Integer.parseInt(partes[0].trim());
       } 
         int filaSeleccionada = TablaMaterias.getSelectedRow();
            if (filaSeleccionada == -1) {
                javax.swing.JOptionPane.showMessageDialog(this, "Tiene que seleccionar una fila");
                return;
            } 
            int idMateria = (int) TablaMaterias.getValueAt(filaSeleccionada, 0);
            int anio = LocalDate.now().getYear();
            Cursada c = new Cursada (idAlumno, idMateria, anio);
            inscData.anularCursada(c);       
             javax.swing.JOptionPane.showMessageDialog(this, "Inscripcion anulada con exito");
             cargarMaterias();
    }//GEN-LAST:event_btnAnularActionPerformed

    private void rbNoInscriptasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbNoInscriptasStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNoInscriptasStateChanged

    private void rbNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoInscriptasActionPerformed
      cargarMaterias();
    }//GEN-LAST:event_rbNoInscriptasActionPerformed

    private void rbInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbInscriptasActionPerformed
      cargarMaterias();
    }//GEN-LAST:event_rbInscriptasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaMaterias;
    private javax.swing.ButtonGroup btgrupo1;
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbInscriptas;
    private javax.swing.JRadioButton rbNoInscriptas;
    // End of variables declaration//GEN-END:variables
}
