/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jovana
 */
public class EkvivalentiRazmena extends AbstractDomainObject {

    private int rb;
    private Razmena razmena;
    private Ekvivalenti ekvivalenti;
    private int ocena;

    public EkvivalentiRazmena() {
    }

    public EkvivalentiRazmena(int rb, Razmena razmena, Ekvivalenti ekvivalenti, int ocena) {
        this.rb = rb;
        this.razmena = razmena;
        this.ekvivalenti = ekvivalenti;
        this.ocena = ocena;
    }

    @Override
    public String getTableName() {
        return "ekvivalenti_razmena";
    }

    @Override
    public String getAlias() {
        return " er ";
    }

    @Override
    public String getJoin() {
        // Join sa tabelom razmene, ekvivalenti, studenti i predmeti
        return "JOIN razmena r ON er.RazmenaID = r.RazmenaID "
                + "JOIN ekvivalenti e ON er.EkvivalentiID = e.EkvivalentiID "
                + "JOIN predmet p1 ON e.PredmetFon = p1.PredmetID "
                + "JOIN predmet p2 ON e.PredmetDrugiFakultet = p2.PredmetID "
                + "JOIN student s ON r.StudentID = s.ID "
                + " JOIN univerzitet u1 ON u1.UniverzitetID = p1.UniverzitetID "
                + " JOIN univerzitet u2 ON u2.UniverzitetID = p2.UniverzitetID ";
    }

    @Override
    public ArrayList<AbstractDomainObject> getListuSvih(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Radnik radnik = new Radnik();
            Univerzitet fon = new Univerzitet(rs.getInt("u1.UniverzitetID"), rs.getString("u1.Naziv"), rs.getString("u1.Grad"));
            Univerzitet drugiUni = new Univerzitet(rs.getInt("u1.UniverzitetID"), rs.getString("u1.Naziv"), rs.getString("u1.Grad"));

            Student student = new Student(
                    rs.getInt("s.ID"),
                    rs.getString("s.Ime"),
                    rs.getString("s.Prezime"),
                    rs.getString("s.Index"), radnik); // Ažurirano za uključivanje informacija o studentu

            Predmet predmetFon = new Predmet(
                    rs.getInt("p1.PredmetID"), rs.getString("p1.Naziv"), fon,
                    rs.getString("p1.Semestar"), rs.getInt("p1.Espb"), radnik);
            Predmet predmetDrugiFakultet = new Predmet(
                    rs.getInt("p2.PredmetID"), rs.getString("p2.Naziv"), drugiUni,
                    rs.getString("p2.Semestar"), rs.getInt("p2.Espb"), radnik);

            Ekvivalenti ekvivalent = new Ekvivalenti(
                    rs.getInt("e.ID"),
                    predmetFon,
                    predmetDrugiFakultet,
                    rs.getInt("e.GodinaDodavanja"));

            Razmena razmena = new Razmena(
                    rs.getInt("r.RazmenaID"),
                    student,
                    rs.getString("r.Semestar"),
                    rs.getString("r.SkolskaGodina"),
                    new ArrayList<>());  // Lista ekvivalenata može biti dodata naknadno ili popunjena ovde ako je potrebno

            int ocena = rs.getInt("er.Ocena");

            EkvivalentiRazmena er = new EkvivalentiRazmena(
                    rs.getInt("er.RB"),
                    razmena,
                    ekvivalent,
                    ocena
            );
            lista.add(er);
        }
        rs.close();
        return lista;
    }

    @Override
    public String getKoloneZaInsert() {
        return "(RB, RazmenaID, EkvivalentiID, Ocena)";
    }

    @Override
    public String getVrednostZaPrimarniKljuc() {
        return " RB = " + rb + " AND RazmenaID = " + razmena.getId();
    }

    @Override
    public String getVrednostiZaInsert() {
        return rb + ", " + razmena.getId() + ", " + ekvivalenti.getEkvivalentiID() + ", " + ocena;
    }

    @Override
    public String getVrednostiZaUpdate() {
        return " RazmenaID = " + razmena.getId()
                + ", EkvivalentiID = " + ekvivalenti.getEkvivalentiID()
                + ", Ocena = " + ocena;
    }

    @Override
    public String getUslov() {
        return " WHERE er.RazmenaID = " + razmena.getId()
                + " ORDER BY RB ASC";
    }

    @Override
    public String toString() {
        return "Ekvivalent: " + ekvivalenti.toString()
                + ", Razmena: " + razmena.toString()
                + ", Ocena: " + ocena;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public Razmena getRazmena() {
        return razmena;
    }

    public void setRazmena(Razmena razmena) {
        this.razmena = razmena;
    }

    public Ekvivalenti getEkvivalenti() {
        return ekvivalenti;
    }

    public void setEkvivalenti(Ekvivalenti ekvivalenti) {
        this.ekvivalenti = ekvivalenti;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

}
