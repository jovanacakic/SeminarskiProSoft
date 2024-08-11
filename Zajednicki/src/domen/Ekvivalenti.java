/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jovana
 */
public class Ekvivalenti extends AbstractDomainObject {

    private int id;
    private Predmet predmetFon;
    private Predmet predmetDrugiFakultet;
    int godinaDodavanja;

    public Ekvivalenti() {
    }

    public Ekvivalenti(int id, Predmet predmetFon, Predmet predmetDrugiFakultet, int godinaDodavanja) {
        this.id = id;
        this.predmetFon = predmetFon;
        this.predmetDrugiFakultet = predmetDrugiFakultet;
        this.godinaDodavanja = godinaDodavanja;
    }

    @Override
    public String getTableName() {
        return "ekvivalenti";
    }

    @Override
    public String getParametre() {
        return String.format("%d, %d, %d, %d", id, predmetFon.getId(), predmetDrugiFakultet.getId(), godinaDodavanja);
    }

    @Override
    public String getNaziveParametara() {
        return "id, predmetFon, predmetDrugiFakultet, godinaDodavanja";
    }

    @Override
    public String getNazivPrimarnogKljuca() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer getVrednostPrimarnogKljuca() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSlozeniPrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AbstractDomainObject> konvertujRSUListu(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSelectUpit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSelectUpitPoParametru() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInsertUpit() {
        return "INSERT INTO " + getTableName() + "(" + getNaziveParametara() + ")" + " VALUES (" + getParametre() + ")";
    }

    @Override
    public String getUpdateUpit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateParametre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDeleteUpit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
