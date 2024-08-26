/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.exchange;

import domen.Ekvivalenti;
import domen.EkvivalentiRazmena;
import domen.Razmena;
import domen.Student;
import domen.Univerzitet;
import java.time.Year;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import konstante.EkvivalentiRazmenaStatus;
import kontroler.RazmenaKontroler;
import kontroler.UniverzitetKontroler;
import model.EkvivalentiTableModel;

/**
 *
 * @author jovana
 */
public class UpdateExchange extends javax.swing.JFrame {

    Student izabrani;
    int rb;
    SearchExchange parent;
    int razmenaID;
    Razmena izabranaRazmena;
    Univerzitet izabraniUniverzitet;
    Univerzitet fon;
    List<EkvivalentiRazmena> prvobitnaLista;

    /**
     * Creates new form UpdateExchange
     */
    public UpdateExchange(SearchExchange parent, Razmena razmena) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Ažuriranje razmene");

        podesiPrvuKolonu();

        this.parent = parent;
        txtStudent.setEditable(false);
        tblEkvivalenti.setModel(new EkvivalentiTableModel(razmena.getListaEkvivalenata()));

        razmenaID = razmena.getRazmenaID();
        rb = razmena.getListaEkvivalenata().size();
        prvobitnaLista = razmena.getListaEkvivalenata();
        this.izabranaRazmena = razmena;

        popuniPolja(razmena);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnPromeni = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSkolskaGodina = new javax.swing.JTextField();
        txtStudent = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEkvivalenti = new javax.swing.JTable();
        btnDodajPredmet = new javax.swing.JButton();
        btnObrisiPredmete = new javax.swing.JButton();
        rbLetnji = new javax.swing.JRadioButton();
        rbZimski = new javax.swing.JRadioButton();
        cmbUniverziteti = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        btnAzurirajOcenu = new javax.swing.JButton();
        btnAzuriraj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Izmena podataka o razmeni"));

        jLabel2.setText("Semestar:");

        btnPromeni.setText("Promeni studenta");
        btnPromeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniActionPerformed(evt);
            }
        });

        jLabel3.setText("Školska godina:");

        jLabel1.setText("Student:");

        txtSkolskaGodina.setText("2023/2024");

        txtStudent.setText("Izaberite studenta!");

        tblEkvivalenti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblEkvivalenti);

        btnDodajPredmet.setText("Dodajte predmet");
        btnDodajPredmet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajPredmetActionPerformed(evt);
            }
        });

        btnObrisiPredmete.setText("Obrisite predmet");
        btnObrisiPredmete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiPredmeteActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbLetnji);
        rbLetnji.setText("letnji");

        buttonGroup1.add(rbZimski);
        rbZimski.setText("zimski");

        cmbUniverziteti.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Biranje univerziteta:");

        btnAzurirajOcenu.setText("Azurirajte ocenu");
        btnAzurirajOcenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzurirajOcenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(txtStudent)
                            .addGap(32, 32, 32)
                            .addComponent(btnPromeni))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel2)
                                    .addGap(24, 24, 24)
                                    .addComponent(rbZimski, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rbLetnji, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtSkolskaGodina, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(65, 65, 65))
                        .addComponent(cmbUniverziteti, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(444, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodajPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObrisiPredmete, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAzurirajOcenu, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPromeni))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbLetnji)
                    .addComponent(rbZimski)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtSkolskaGodina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addComponent(cmbUniverziteti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAzurirajOcenu)
                        .addGap(18, 18, 18)
                        .addComponent(btnDodajPredmet)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisiPredmete)
                        .addGap(115, 115, 115))))
        );

        btnAzuriraj.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAzuriraj.setText("Ažuriraj razmenu");
        btnAzuriraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzurirajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(429, 429, 429)
                .addComponent(btnAzuriraj, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnAzuriraj)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPromeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniActionPerformed
        new ChooseStudent(this, true).setVisible(true);
    }//GEN-LAST:event_btnPromeniActionPerformed

    private void btnDodajPredmetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajPredmetActionPerformed
        if (!proveriSemestar()) {
            JOptionPane.showMessageDialog(null, "Ne možete promeniti semestar ako su neki predmeti već dodati.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!proveriUniverzitet()) {
            JOptionPane.showMessageDialog(null, "Ne možete promeniti univerzitet ako su neki predmeti već dodati.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Univerzitet u = (Univerzitet) cmbUniverziteti.getSelectedItem();

        new ChooseSubjects(this, true, rbZimski.isSelected(), u).setVisible(true);
    }//GEN-LAST:event_btnDodajPredmetActionPerformed

    private void btnObrisiPredmeteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiPredmeteActionPerformed
        int row = tblEkvivalenti.getSelectedRow();
        if (row != -1) {
            EkvivalentiTableModel etb = (EkvivalentiTableModel) tblEkvivalenti.getModel();
            etb.obrisiEkvivalente(row);
            etb.resetujRB();

            EkvivalentiRazmena obrisan = etb.getEkvivalentiRazmena(row);
            statusDeleted(obrisan);
        }
    }//GEN-LAST:event_btnObrisiPredmeteActionPerformed

    private void btnAzurirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzurirajActionPerformed
        //int studentId = izabrani.getId();
        //List<Ekvivalenti> listaEkvivalenata = etb.getLista();
        String skolskaGodina = txtSkolskaGodina.getText();
        if (!isValidSkolskaGodina(skolskaGodina)) {
            JOptionPane.showMessageDialog(this, "Skolska godina mora da bude u odgovarajucem formatu.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String semestar = rbZimski.isSelected() ? "Zimski" : "Letnji";

        EkvivalentiTableModel etb = (EkvivalentiTableModel) tblEkvivalenti.getModel();
        List<EkvivalentiRazmena> listaEkvNaRazmeni = etb.getLista();
        if (listaEkvNaRazmeni.size() < 3) {
            JOptionPane.showMessageDialog(this, "Razmena mora da ima bar 3 predmeta.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (EkvivalentiRazmena ekvivalentiRazmena : listaEkvNaRazmeni) {
            System.out.println(ekvivalentiRazmena.getEkvivalenti().getPredmetFon() + " " + ekvivalentiRazmena.getEkvivalenti().getPredmetDrugiFakultet());
        }

        this.izabraniUniverzitet = (Univerzitet) cmbUniverziteti.getSelectedItem();

        Razmena razmena = new Razmena(razmenaID, izabrani, semestar, skolskaGodina, fon, izabraniUniverzitet, listaEkvNaRazmeni);

        if (RazmenaKontroler.getInstance().azurirajRazmenu(razmena)) {
            JOptionPane.showMessageDialog(this, "Sistem je azurirao razmenu", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
            //dialog.popuniTabelu(null);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da azurira razmenu", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAzurirajActionPerformed

    private void btnAzurirajOcenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzurirajOcenuActionPerformed
        int row = tblEkvivalenti.getSelectedRow();
        if (row != -1) {
            EkvivalentiTableModel etb = (EkvivalentiTableModel) tblEkvivalenti.getModel();
            EkvivalentiRazmena er = etb.getEkvivalentiRazmena(row);
            new UpdateGrade(this, true, er).setVisible(true);
        }
    }//GEN-LAST:event_btnAzurirajOcenuActionPerformed

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
//            java.util.logging.Logger.getLogger(UpdateExchange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(UpdateExchange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(UpdateExchange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UpdateExchange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UpdateExchange().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAzuriraj;
    private javax.swing.JButton btnAzurirajOcenu;
    private javax.swing.JButton btnDodajPredmet;
    private javax.swing.JButton btnObrisiPredmete;
    private javax.swing.JButton btnPromeni;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbUniverziteti;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbLetnji;
    private javax.swing.JRadioButton rbZimski;
    private javax.swing.JTable tblEkvivalenti;
    private javax.swing.JTextField txtSkolskaGodina;
    private javax.swing.JTextField txtStudent;
    // End of variables declaration//GEN-END:variables

    private boolean proveriSemestar() {
        EkvivalentiTableModel etb = (EkvivalentiTableModel) tblEkvivalenti.getModel();
        if (etb.getLista().isEmpty()) {
            return true;
        }
        String semestar = rbZimski.isSelected() ? "Zimski" : "Letnji";

        return etb.getLista().getLast().getEkvivalenti().getPredmetDrugiFakultet().getSemestar().equals(semestar);
    }

    private void popuniPolja(Razmena razmena) {
        txtSkolskaGodina.setText(razmena.getSkolskaGodina());
        txtStudent.setText(razmena.getStudent().toString());
        izabrani = razmena.getStudent();
        popuniUniverzitete();
        cmbUniverziteti.setSelectedItem(razmena.getUniverzitetDrugi());
        rbZimski.setSelected(razmena.getSemestar().equals("Zimski"));
        //popuniTabelu(razmena.getListaEkvivalenata());

    }

//    private void popuniTabelu(List<EkvivalentiRazmena> listaEkvivalenata) {
//        EkvivalentiTableModel etm = (EkvivalentiTableModel) tblEkvivalenti.getModel();
//        etm.setLista(listaEkvivalenata);
//    }
    void dodajEkvivalente(Ekvivalenti e) {
        EkvivalentiTableModel etb = (EkvivalentiTableModel) tblEkvivalenti.getModel();
        EkvivalentiRazmena e2 = new EkvivalentiRazmena(++rb, izabranaRazmena, e, 0, EkvivalentiRazmenaStatus.NEW);
        etb.dodajRed(e2);
        etb.resetujRB();
        //statusNew(e2);
    }

    private boolean proveriUniverzitet() {
        EkvivalentiTableModel etb = (EkvivalentiTableModel) tblEkvivalenti.getModel();
        if (etb.getLista().isEmpty()) {
            return true;
        }
        Univerzitet u = (Univerzitet) cmbUniverziteti.getSelectedItem();

        return etb.getLista().getLast().getEkvivalenti().getPredmetDrugiFakultet().getUniverzitet().equals(u);
    }

    private void popuniUniverzitete() {
        List<Univerzitet> listaUniverziteta = UniverzitetKontroler.getInstance().ucitajListuUniverziteta();
        cmbUniverziteti.removeAllItems();
        for (Univerzitet u : listaUniverziteta) {
            if (u.getNaziv().equals("Fakultet Organizacionih Nauka")) {
                this.fon = u;
            } else {
                cmbUniverziteti.addItem(u);
            }
        }
    }

    private void statusDeleted(EkvivalentiRazmena obrisan) {
        for (EkvivalentiRazmena er : prvobitnaLista) {
            if (er.getEkvivalenti().getEkvivalentiID() == obrisan.getEkvivalenti().getEkvivalentiID()) {
                er.setStatus(EkvivalentiRazmenaStatus.DELETED);
            }
        }
    }

    private void statusChanged(EkvivalentiRazmena izmenjen) {
        for (EkvivalentiRazmena er : prvobitnaLista) {
            if (er.getEkvivalenti().getEkvivalentiID() == izmenjen.getEkvivalenti().getEkvivalentiID()) {
                er.setStatus(EkvivalentiRazmenaStatus.UPDATED);
            }
        }
    }

//    private void statusNew(EkvivalentiRazmena promenjen) {
//        for (EkvivalentiRazmena er : prvobitnaLista) {
//            if (er.getEkvivalenti().getEkvivalentiID() == promenjen.getEkvivalenti().getEkvivalentiID()) {
//                er.setStatus(EkvivalentiRazmenaStatus.NEW);
//            }
//        }
//    }
    void azurirajOcenu(EkvivalentiRazmena izabrani, int ocena) {
        EkvivalentiTableModel etb = (EkvivalentiTableModel) tblEkvivalenti.getModel();

        etb.azurirajOcenu(ocena, izabrani);
        statusChanged(izabrani);
        etb.resetujRB();
    }

    public boolean isValidSkolskaGodina(String skolskaGodina) {
        // Regex za format "godina/godina"
        String regex = "^(20\\d{2})/(20\\d{2})$";

        // Proveri da li uneti string odgovara regexu
        if (skolskaGodina.matches(regex)) {
            // Dobij trenutnu godinu
            int currentYear = Year.now().getValue();

            // Podeli string na dve godine
            String[] godine = skolskaGodina.split("/");
            int prvaGodina = Integer.parseInt(godine[0]);
            int drugaGodina = Integer.parseInt(godine[1]);

            // Proveri da li su godine u validnom opsegu i da li je razlika između njih tačno 1
            if (prvaGodina >= 2000 && drugaGodina <= currentYear && drugaGodina - prvaGodina == 1) {
                return true;
            }
        }

        return false;
    }

    private void podesiPrvuKolonu() {
        TableColumn firstColumn = tblEkvivalenti.getColumnModel().getColumn(0);
        firstColumn.setMinWidth(50);
        firstColumn.setMaxWidth(50);
        firstColumn.setPreferredWidth(50);
    }


}
