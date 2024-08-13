/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.frame;

import gui.exchange.AddExchange;
import gui.exchange.UpdateExchange;
import gui.student.AddStudent;
import gui.student.SearchStudent;
import gui.subject.AddEquivalents;
import gui.subject.AddSubject;
import niti.KlijentskaNit;

/**
 *
 * @author jovana
 */
public class KlijentFrame extends javax.swing.JFrame {

    /**
     * Creates new form KlijentFrame
     */
    private KlijentskaNit kn;

    public KlijentFrame(KlijentskaNit kn) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Razmena studenata");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiDodajStudenta = new javax.swing.JMenuItem();
        jmiPretraga = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jmiDodajPredmet = new javax.swing.JMenuItem();
        jmiDodajEkvivalente = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiDodajRazmenu = new javax.swing.JMenuItem();
        jmiAžurirajRazmenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("File");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar3.add(jMenu7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Studenti");

        jmiDodajStudenta.setText("Dodaj studenta");
        jmiDodajStudenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDodajStudentaActionPerformed(evt);
            }
        });
        jMenu1.add(jmiDodajStudenta);

        jmiPretraga.setText("Pretraga studenata");
        jmiPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaActionPerformed(evt);
            }
        });
        jMenu1.add(jmiPretraga);

        jMenuBar1.add(jMenu1);

        jMenu10.setText("Predmeti");

        jmiDodajPredmet.setText("Dodaj predmet");
        jmiDodajPredmet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDodajPredmetActionPerformed(evt);
            }
        });
        jMenu10.add(jmiDodajPredmet);

        jmiDodajEkvivalente.setText("Dodaj ekvivalente");
        jmiDodajEkvivalente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDodajEkvivalenteActionPerformed(evt);
            }
        });
        jMenu10.add(jmiDodajEkvivalente);

        jMenuItem3.setText("Pregled predmeta");
        jMenu10.add(jMenuItem3);

        jMenuBar1.add(jMenu10);

        jMenu2.setText("Razmene");

        jmiDodajRazmenu.setText("Dodaj razmenu");
        jmiDodajRazmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDodajRazmenuActionPerformed(evt);
            }
        });
        jMenu2.add(jmiDodajRazmenu);

        jmiAžurirajRazmenu.setText("Ažuriraj razmenu");
        jmiAžurirajRazmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAžurirajRazmenuActionPerformed(evt);
            }
        });
        jMenu2.add(jmiAžurirajRazmenu);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Izveštaj");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiDodajStudentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDodajStudentaActionPerformed
        new AddStudent().setVisible(true);
    }//GEN-LAST:event_jmiDodajStudentaActionPerformed

    private void jmiPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaActionPerformed
        new SearchStudent().setVisible(true);
    }//GEN-LAST:event_jmiPretragaActionPerformed

    private void jmiDodajPredmetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDodajPredmetActionPerformed
        new AddSubject().setVisible(true);
    }//GEN-LAST:event_jmiDodajPredmetActionPerformed

    private void jmiDodajEkvivalenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDodajEkvivalenteActionPerformed
        new AddEquivalents().setVisible(true);
    }//GEN-LAST:event_jmiDodajEkvivalenteActionPerformed

    private void jmiDodajRazmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDodajRazmenuActionPerformed
        new AddExchange().setVisible(true);
    }//GEN-LAST:event_jmiDodajRazmenuActionPerformed

    private void jmiAžurirajRazmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAžurirajRazmenuActionPerformed
        new UpdateExchange().setVisible(true);
    }//GEN-LAST:event_jmiAžurirajRazmenuActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(KlijentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(KlijentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(KlijentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(KlijentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new KlijentFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jmiAžurirajRazmenu;
    private javax.swing.JMenuItem jmiDodajEkvivalente;
    private javax.swing.JMenuItem jmiDodajPredmet;
    private javax.swing.JMenuItem jmiDodajRazmenu;
    private javax.swing.JMenuItem jmiDodajStudenta;
    private javax.swing.JMenuItem jmiPretraga;
    // End of variables declaration//GEN-END:variables
}
