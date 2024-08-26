/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import konstante.EkvivalentiRazmenaStatus;

/**
 *
 * @author jovana
 */
public class EkvivalentiRazmena extends AbstractDomainObject {

    private int rb;
    private Razmena razmena;
    private Ekvivalenti ekvivalenti;
    private int ocena;
    private EkvivalentiRazmenaStatus status;

    public EkvivalentiRazmena() {
    }

    public EkvivalentiRazmena(int rb, Razmena razmena, Ekvivalenti ekvivalenti, int ocena) {
        this.rb = rb;
        this.razmena = razmena;
        this.ekvivalenti = ekvivalenti;
        this.ocena = ocena;
    }

    public EkvivalentiRazmena(int rb, Razmena razmena, Ekvivalenti ekvivalenti, int ocena, EkvivalentiRazmenaStatus status) {
        this.rb = rb;
        this.razmena = razmena;
        this.ekvivalenti = ekvivalenti;
        this.ocena = ocena;
        this.status = status;
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
        return "JOIN razmena raz ON er.RazmenaID = raz.RazmenaID "
                + "JOIN ekvivalenti e ON er.EkvivalentiID = e.EkvivalentiID "
                + "JOIN predmet p1 ON e.PredmetFonID = p1.PredmetID "
                + "JOIN predmet p2 ON e.PredmetDrugiUniverzitetID = p2.PredmetID "
                + "JOIN student s ON raz.StudentID = s.StudentID "
                + " JOIN univerzitet u1 ON u1.UniverzitetID = p1.UniverzitetID "
                + " JOIN univerzitet u2 ON u2.UniverzitetID = p2.UniverzitetID ";
    }

    @Override
    public ArrayList<AbstractDomainObject> getListuSvih(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Radnik radnik = new Radnik();
            Univerzitet fon = new Univerzitet(rs.getInt("u1.UniverzitetID"), rs.getString("u1.Naziv"), rs.getString("u1.Grad"));
            Univerzitet drugiUni = new Univerzitet(rs.getInt("u2.UniverzitetID"), rs.getString("u2.Naziv"), rs.getString("u2.Grad"));

            Student student = new Student(
                    rs.getInt("s.StudentID"),
                    rs.getString("s.Ime"),
                    rs.getString("s.Prezime"),
                    rs.getString("s.Index"), radnik);
            Predmet predmetFon = new Predmet(
                    rs.getInt("p1.PredmetID"), rs.getString("p1.Naziv"), fon,
                    rs.getString("p1.Semestar"), rs.getInt("p1.Espb"), radnik);
            Predmet predmetDrugiFakultet = new Predmet(
                    rs.getInt("p2.PredmetID"), rs.getString("p2.Naziv"), drugiUni,
                    rs.getString("p2.Semestar"), rs.getInt("p2.Espb"), radnik);

            Ekvivalenti ekvivalent = new Ekvivalenti(
                    rs.getInt("e.EkvivalentiID"),
                    predmetFon,
                    predmetDrugiFakultet,
                    rs.getInt("e.GodinaDodavanja"));

            Razmena razmena = new Razmena(
                    rs.getInt("raz.RazmenaID"),
                    student,
                    rs.getString("raz.Semestar"),
                    rs.getString("raz.SkolskaGodina"),
                    fon, drugiUni,
                    new ArrayList<>());  // Lista ekvivalenata može biti dodata naknadno ili popunjena ovde ako je potrebno

            int ocena = rs.getInt("er.Ocena");

            EkvivalentiRazmena er = new EkvivalentiRazmena(
                    rs.getInt("er.RB"),
                    razmena,
                    ekvivalent,
                    ocena,
                    EkvivalentiRazmenaStatus.UNCHANGED
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
        return " RB = " + rb + " AND RazmenaID = " + razmena.getRazmenaID();
    }

    @Override
    public String getVrednostiZaInsert() {
        return rb + ", " + razmena.getRazmenaID() + ", " + ekvivalenti.getEkvivalentiID() + ", " + ocena;
    }

    @Override
    public String getVrednostiZaUpdate() {
        return " RazmenaID = " + razmena.getRazmenaID()
                + ", EkvivalentiID = " + ekvivalenti.getEkvivalentiID()
                + ", Ocena = " + ocena;
    }

    @Override
    public String getUslov() {
        return " WHERE er.RazmenaID = " + razmena.getRazmenaID()
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

    public EkvivalentiRazmenaStatus getStatus() {
        return status;
    }

    public void setStatus(EkvivalentiRazmenaStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        EkvivalentiRazmena other = (EkvivalentiRazmena) obj;

        if (razmena == null || other.razmena == null) {
            return false;
        }
        if (razmena.getRazmenaID() != other.razmena.getRazmenaID()) {
            return false;
        }

        if (ekvivalenti == null || other.ekvivalenti == null) {
            return false;
        }
        if (ekvivalenti.getEkvivalentiID() != other.ekvivalenti.getEkvivalentiID()) {
            return false;
        }

        return true;
    }

}
