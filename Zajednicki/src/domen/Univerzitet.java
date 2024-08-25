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
public class Univerzitet extends AbstractDomainObject {

    private int univerzitetID;
    private String naziv;
    private String grad;

    @Override
    public String toString() {
        return naziv;
    }

    public Univerzitet() {
    }

    public Univerzitet(int univerzitetID, String naziv, String grad) {
        this.univerzitetID = univerzitetID;
        this.naziv = naziv;
        this.grad = grad;
    }

    @Override
    public String getTableName() {
        return "univerzitet";
    }

    @Override
    public String getAlias() {
        return " u ";
    }

    @Override
    public String getJoin() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> getListuSvih(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Univerzitet univerzitet = new Univerzitet(rs.getInt("UniverzitetID"), rs.getString("Naziv"), rs.getString("Grad"));
            lista.add(univerzitet);
        }
        rs.close();
        return lista;
    }

    @Override
    public String getKoloneZaInsert() {
        return "(Naziv, Grad)";
    }

    @Override
    public String getVrednostZaPrimarniKljuc() {
        return " UniverzitetID = " + univerzitetID;
    }

    @Override
    public String getVrednostiZaInsert() {
        return "'" + naziv + "', '" + grad + "'";
    }

    @Override
    public String getVrednostiZaUpdate() {
        return " naziv='" + naziv + "', grad='" + grad +  " ";
    }

    @Override
    public String getUslov() {
        return " ORDER BY u.naziv ASC";
    }

    public int getUniverzitetID() {
        return univerzitetID;
    }

    public void setUniverzitetID(int univerzitetID) {
        this.univerzitetID = univerzitetID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

}
