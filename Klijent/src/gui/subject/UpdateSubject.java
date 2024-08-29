/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui.subject;

import domen.Predmet;
import domen.Radnik;
import domen.Univerzitet;
import java.util.List;
import javax.swing.JOptionPane;
import kontroler.PredmetKontroler;
import kontroler.UniverzitetKontroler;

/**
 *
 * @author jovana
 */
public class UpdateSubject extends javax.swing.JDialog {

    Predmet predmet;
    Radnik prijavljeni;
    /**
     * Creates new form UpdateSubject
     */
    public UpdateSubject(SearchSubject parent, boolean modal, Predmet p, Radnik prijavljeni) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Azuriranje predmeta");

        this.prijavljeni = prijavljeni;
        this.predmet = p;
        popuniPolja();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnAzuriraj = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtNazivPredmeta = new javax.swing.JTextField();
        cmbUni = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rbZimski = new javax.swing.JRadioButton();
        rbLetnji = new javax.swing.JRadioButton();
        txtEspb = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAzuriraj.setText("Azuriraj predmet");
        btnAzuriraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzurirajActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Promena podataka o predmetu"));

        cmbUni.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Naziv visokoškolske ustanove:");

        jLabel4.setText("Naziv predmeta:");

        jLabel5.setText("Semestar:");

        buttonGroup1.add(rbZimski);
        rbZimski.setText("zimski");

        buttonGroup1.add(rbLetnji);
        rbLetnji.setText("letnji");

        jLabel6.setText("Broj ESPB:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(363, 363, 363))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNazivPredmeta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(24, 24, 24)
                                .addComponent(rbZimski, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbLetnji, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(txtEspb, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbUni, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNazivPredmeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbLetnji)
                            .addComponent(rbZimski)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtEspb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 392, Short.MAX_VALUE)
                        .addComponent(btnAzuriraj, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnAzuriraj)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAzurirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzurirajActionPerformed
        String nazivPredmeta = txtNazivPredmeta.getText();
        if (nazivPredmeta.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Unesite naziv predmeta.", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Univerzitet univerzitet = (Univerzitet) cmbUni.getSelectedItem();
        String semestar1 = rbZimski.isSelected() ? "Zimski" : "Letnji";
        int espb1;
        try {
            espb1 = Integer.parseInt(txtEspb.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Unesite validnu vrednost za ESPB.", "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Predmet p = new Predmet(this.predmet.getPredmetID(), nazivPredmeta, univerzitet, semestar1, espb1, prijavljeni);

        if (PredmetKontroler.getInstance().azurirajPredmet(p)) {
            JOptionPane.showMessageDialog(this, "Sistem je azurirao predmet.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            SearchSubject parent = (SearchSubject) this.getParent();
            parent.azurirajTabelu();
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da azurira predmet.", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAzurirajActionPerformed

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(UpdateSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(UpdateSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(UpdateSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UpdateSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                UpdateSubject dialog = new UpdateSubject(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAzuriraj;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbUni;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbLetnji;
    private javax.swing.JRadioButton rbZimski;
    private javax.swing.JTextField txtEspb;
    private javax.swing.JTextField txtNazivPredmeta;
    // End of variables declaration//GEN-END:variables

    private void popuniPolja() {
        txtNazivPredmeta.setText(predmet.getNaziv());
        popuniUniverzitete();
        txtEspb.setText(String.valueOf(predmet.getEspb()));
        rbZimski.setSelected(predmet.getSemestar().equals("Zimski"));
        rbLetnji.setSelected(predmet.getSemestar().equals("Letnji"));
    }

    private void popuniUniverzitete() {
        List<Univerzitet> listaUniverziteta = UniverzitetKontroler.getInstance().ucitajListuUniverziteta();
        cmbUni.removeAllItems();
        for (Univerzitet u : listaUniverziteta) {
            cmbUni.addItem(u);
        }
    }
}
