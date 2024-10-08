/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui.exchange;

import domen.Ekvivalenti;
import domen.Predmet;
import domen.Univerzitet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import kontroler.EkvivalentiKontroler;
import kontroler.PredmetKontroler;

/**
 *
 * @author jovana
 */
public class ChooseSubjects extends javax.swing.JDialog {

    boolean zimski;
    String semestar;
    List<Ekvivalenti> ekvivalentiZaOdabraniUni;
    Univerzitet izabraniUniverzitet;
    Ekvivalenti izabrani;
    private Map<Predmet, Map<Predmet, Ekvivalenti>> ekvivalentiMapa = new HashMap<>();

    /**
     * Creates new form ChooseSubjects
     */
    public ChooseSubjects(java.awt.Frame parent, boolean modal, boolean rbZimski, Univerzitet u) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Izbor predmeta");
        zimski = rbZimski;
        this.izabraniUniverzitet = u;
        semestar = rbZimski ? "Zimski" : "Letnji";


        ucitajListuEkvivalenata();

        popuniCmbFon();  // Popunjava cmbFon i postavlja mapu ekvivalentiZaOdabraniUni
        osveziCmbEkvivalenti();
        updateIzabraniEkvivalenti();
        cmbFon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                osveziCmbEkvivalenti();  // Ažurira cmbEkvivalenti na osnovu izabranog predmeta u cmbFon
                updateIzabraniEkvivalenti();  // Ažurira izabrani ekvivalent na osnovu trenutnih selekcija
            }
        });

        cmbEkvivalenti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateIzabraniEkvivalenti();  // Ažurira izabrani ekvivalent na osnovu trenutnih selekcija
            }
        });
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
        cmbFon = new javax.swing.JComboBox();
        cmbEkvivalenti = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbOcena = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Izbor predmeta na razmeni"));

        cmbFon.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbEkvivalenti.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Predmet na FON-u:");

        jLabel2.setText("Ekvivalent tom predmetu na drugom fakultetu:");

        cmbOcena.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "6", "7", "8", "9", "10" }));

        jLabel3.setText("Ocena:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbOcena, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmbFon, 0, 503, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbEkvivalenti, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(138, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbEkvivalenti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOcena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnDodaj.setText("Dodajte predmet");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDodaj)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        java.awt.Frame parentFrame = (java.awt.Frame) getParent();
        Predmet p1 = (Predmet) cmbFon.getSelectedItem();
        Predmet p2 = (Predmet) cmbEkvivalenti.getSelectedItem();
        int ocena = Integer.parseInt((String) cmbOcena.getSelectedItem());
        if (zimski && p2.getSemestar().equals("Letnji")) {
            JOptionPane.showMessageDialog(null, "Izabrali ste da semestar razmene bude " + semestar + ". Ne mozete dodavati predmet iz drugog semestra", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (parentFrame instanceof AddExchange) {
            AddExchange addForm = (AddExchange) parentFrame;

            addForm.dodajEkvivalente(izabrani, ocena);
        } else if (parentFrame instanceof UpdateExchange) {
            UpdateExchange updateForm = (UpdateExchange) parentFrame;

            updateForm.dodajEkvivalente(izabrani, ocena);
        }

        this.dispose();
    }//GEN-LAST:event_btnDodajActionPerformed

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
//            java.util.logging.Logger.getLogger(ChooseSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ChooseSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ChooseSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ChooseSubjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ChooseSubjects dialog = new ChooseSubjects(new javax.swing.JFrame(), true);
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
    private void updateIzabraniEkvivalenti() {
        Predmet fonPredmet = (Predmet) cmbFon.getSelectedItem();
        Predmet drugiFakultetPredmet = (Predmet) cmbEkvivalenti.getSelectedItem();
        if (fonPredmet != null && drugiFakultetPredmet != null && ekvivalentiMapa.containsKey(fonPredmet) && ekvivalentiMapa.get(fonPredmet).containsKey(drugiFakultetPredmet)) {
            izabrani = ekvivalentiMapa.get(fonPredmet).get(drugiFakultetPredmet);
        } else {
            izabrani = null;  // Resetuje izabrani ekvivalent ako ne postoji validna kombinacija
        }
    }

    private void popuniCmbFon() {
        cmbFon.removeAllItems();
        for (Ekvivalenti e : ekvivalentiZaOdabraniUni) {
            cmbFon.addItem(e.getPredmetFon());
            if (!ekvivalentiMapa.containsKey(e.getPredmetFon())) {
                ekvivalentiMapa.put(e.getPredmetFon(), new HashMap<>());
            }
            ekvivalentiMapa.get(e.getPredmetFon()).put(e.getPredmetDrugiFakultet(), e);
        }
    }

    private void osveziCmbEkvivalenti() {
        Predmet selektovaniPredmet = (Predmet) cmbFon.getSelectedItem();
        if (selektovaniPredmet != null) {
            cmbEkvivalenti.removeAllItems();
            Map<Predmet, Ekvivalenti> map = ekvivalentiMapa.get(selektovaniPredmet);
            if (map != null) {
                for (Predmet p : map.keySet()) {
                    cmbEkvivalenti.addItem(p);
                }
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JComboBox cmbEkvivalenti;
    private javax.swing.JComboBox cmbFon;
    private javax.swing.JComboBox<String> cmbOcena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void ucitajListuEkvivalenata() {
        List<Ekvivalenti> sviEkvivalenti = EkvivalentiKontroler.getInstance().vratiEkvivalente();
        this.ekvivalentiZaOdabraniUni = new ArrayList<>();
        for (Ekvivalenti e : sviEkvivalenti) {
            if (e.getPredmetDrugiFakultet().getUniverzitet().equals(izabraniUniverzitet)) {
                this.ekvivalentiZaOdabraniUni.add(e);
            }
        }
        if(ekvivalentiZaOdabraniUni.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ne postoje uneti predmeti za odabrani univerzitet", "Greska", JOptionPane.WARNING_MESSAGE);
            this.dispose();
        }
    }

}
