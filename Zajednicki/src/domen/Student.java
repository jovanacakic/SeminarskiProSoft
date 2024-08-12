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
public class Student extends AbstractDomainObject {

    private int id;
    private String ime;
    private String prezime;
    private String index;

    @Override
    public String toString() {
        return ime + " " + prezime + " " + index;
    }

    public Student() {
    }

    public Student(int id, String ime, String prezime, String index) {
        this.id = id;
        this.index = index;
        this.ime = ime;
        this.prezime = prezime;
    }


    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTableName() {
        return "student";
    }
    @Override
    public String getAlijas() {
        return " s ";
    }

    @Override
    public String getJoin() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> getListuSvih(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student(rs.getInt("ID"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("Index"));
            lista.add(student);
        }
        rs.close();
        return lista;
    }

    @Override
    public String getKoloneZaInsert() {
        return "(ime, prezime, `index`)";
    }

    @Override
    public String getVrednostZaPrimarniKljuc() {
        return " id = " + id;
    }

    @Override
    public String getVrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', '" + index + "'";
    }

    @Override
    public String getVrednostiZaUpdate() {
        return " ime='" + ime + "', prezime='" + prezime + "', index='" + index + "' ";
    }

    @Override
    public String getUslov() {
        return " ORDER BY s.ime ASC";
    }

}
