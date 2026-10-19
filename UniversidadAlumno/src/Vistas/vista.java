package Vistas;

/**
 *
 * @author LAURA TELLO
 */
public class vista extends javax.swing.JFrame {
    public vista() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPasswordField1 = new javax.swing.JPasswordField();
        dskPanelEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmenItemFormMateria = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        JMenuInscribirse = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout dskPanelEscritorioLayout = new javax.swing.GroupLayout(dskPanelEscritorio);
        dskPanelEscritorio.setLayout(dskPanelEscritorioLayout);
        dskPanelEscritorioLayout.setHorizontalGroup(
            dskPanelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );
        dskPanelEscritorioLayout.setVerticalGroup(
            dskPanelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        jMenu2.setText("Alumno");

        jMenuItem1.setText("Adminsitrar Alumnos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Materia");

        jmenItemFormMateria.setText("Administrar Materias");
        jmenItemFormMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenItemFormMateriaActionPerformed(evt);
            }
        });
        jMenu3.add(jmenItemFormMateria);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Inscripcion");

        JMenuInscribirse.setText("Inscribirse");
        JMenuInscribirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuInscribirseActionPerformed(evt);
            }
        });
        jMenu4.add(JMenuInscribirse);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dskPanelEscritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dskPanelEscritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
            FormularioAlumnoView vistaFormularioAlumno = new FormularioAlumnoView();
            dskPanelEscritorio.add(vistaFormularioAlumno);
            vistaFormularioAlumno.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void JMenuInscribirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuInscribirseActionPerformed
       FormularioInscripcionView vistaFormularioInscripcion = new FormularioInscripcionView();
       dskPanelEscritorio.add(vistaFormularioInscripcion);
       vistaFormularioInscripcion.setVisible(true);
    }//GEN-LAST:event_JMenuInscribirseActionPerformed

    private void jmenItemFormMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenItemFormMateriaActionPerformed
       FormularioMateria fm = new FormularioMateria();
       dskPanelEscritorio.add(fm);
       fm.setVisible(true);
    }//GEN-LAST:event_jmenItemFormMateriaActionPerformed
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
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMenuInscribirse;
    private javax.swing.JDesktopPane dskPanelEscritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JMenuItem jmenItemFormMateria;
    // End of variables declaration//GEN-END:variables
}
