/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jovana
 */
public class Ekvivalenti extends AbstractDomainObject {

    private int ekvivalentiID;
    private Predmet predmetFon;
    private Predmet predmetDrugiFakultet;
    int godinaDodavanja;

    public Ekvivalenti() {
    }

    public Ekvivalenti(int ekvivalentiID, Predmet predmetFon, Predmet predmetDrugiFakultet, int godinaDodavanja) {
        this.ekvivalentiID = ekvivalentiID;
        this.predmetFon = predmetFon;
        this.predmetDrugiFakultet = predmetDrugiFakultet;
        this.godinaDodavanja = godinaDodavanja;
    }

    public int getEkvivalentiID() {
        return ekvivalentiID;
    }

    public void setEkvivalentiID(int ekvivalentiID) {
        this.ekvivalentiID = ekvivalentiID;
    }

    public Predmet getPredmetFon() {
        return predmetFon;
    }

    public void setPredmetFon(Predmet predmetFon) {
        this.predmetFon = predmetFon;
    }

    public Predmet getPredmetDrugiFakultet() {
        return predmetDrugiFakultet;
    }

    public void setPredmetDrugiFakultet(Predmet predmetDrugiFakultet) {
        this.predmetDrugiFakultet = predmetDrugiFakultet;
    }

    public int getGodinaDodavanja() {
        return godinaDodavanja;
    }

    public void setGodinaDodavanja(int godinaDodavanja) {
        this.godinaDodavanja = godinaDodavanja;
    }

    @Override
    public String getTableName() {
        return "ekvivalenti";
    }

    @Override
    public String getAlias() {
        return " e ";
    }

    @Override
    public String getJoin() {
        return " JOIN predmet p1 ON e.predmetFonID = p1.predmetID "
                + " JOIN predmet p2 ON e.predmetDrugiUniverzitetID = p2.predmetID "
                + " JOIN univerzitet u1 ON u1.UniverzitetID = p1.UniverzitetID "
                + " JOIN univerzitet u2 ON u2.UniverzitetID = p2.UniverzitetID ";
    }

    @Override
    public ArrayList<AbstractDomainObject> getListuSvih(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Univerzitet fon = new Univerzitet(rs.getInt("u1.UniverzitetID"), rs.getString("u1.Naziv"), rs.getString("u1.Grad"));
            Univerzitet drugiUni = new Univerzitet(rs.getInt("u2.UniverzitetID"), rs.getString("u2.Naziv"), rs.getString("u2.Grad"));
            Radnik radnik = new Radnik();
            Predmet predmetFon = new Predmet(
                    rs.getInt("p1.PredmetID"), rs.getString("p1.Naziv"), fon,
                    rs.getString("p1.Semestar"), rs.getInt("p1.Espb"), radnik);
            Predmet predmetDrugiFakultet = new Predmet(
                    rs.getInt("p2.PredmetID"), rs.getString("p2.Naziv"), drugiUni,
                    rs.getString("p2.Semestar"), rs.getInt("p2.Espb"), radnik);

            Ekvivalenti ekvivalent = new Ekvivalenti(
                    rs.getInt("e.ekvivalentiID"), predmetFon, predmetDrugiFakultet, rs.getInt("e.GodinaDodavanja"));
            lista.add(ekvivalent);
        }
        rs.close();
        return lista;
    }

    @Override
    public String getKoloneZaInsert() {
        return "(PredmetFonID, PredmetDrugiUniverzitetID, GodinaDodavanja)";
    }

    @Override
    public String getVrednostZaPrimarniKljuc() {
        return " ekvivalentiID = " + ekvivalentiID;
    }

    @Override
    public String getVrednostiZaInsert() {
        return predmetFon.getPredmetID() + ", " + predmetDrugiFakultet.getPredmetID() + ", " + godinaDodavanja;
    }

    @Override
    public String getVrednostiZaUpdate() {
        return " PredmetFonID = " + predmetFon.getPredmetID()
                + ", PredmetDrugiUniverzitetID = " + predmetDrugiFakultet.getPredmetID()
                + ", GodinaDodavanja = " + godinaDodavanja;
    }

    @Override
    public String getUslov() {
        return " ORDER BY e.GodinaDodavanja DESC, p1.Naziv ASC, p2.Naziv ASC";
    }

    @Override
    public String toString() {
        return predmetFon.getNaziv() + " <-> " + predmetDrugiFakultet.getNaziv()
                + " (" + godinaDodavanja + ")";
    }

}
