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

    private int studentID;
    private String ime;
    private String prezime;
    private String index;
    private Radnik radnik;

    @Override
    public String toString() {
        return ime + " " + prezime + " " + index;
    }

    public Student() {
    }

    public Student(int studentID, String ime, String prezime, String index, Radnik radnik) {
        this.studentID = studentID;
        this.ime = ime;
        this.prezime = prezime;
        this.index = index;
        this.radnik = radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public Radnik getRadnik() {
        return radnik;
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

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int StudentID) {
        this.studentID = StudentID;
    }

    @Override
    public String getTableName() {
        return "student";
    }

    @Override
    public String getAlias() {
        return " s ";
    }

    @Override
    public String getJoin() {
        return "JOIN radnik rad ON s.radnikID = rad.radnikID ";
    }

    @Override
    public ArrayList<AbstractDomainObject> getListuSvih(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Radnik radnik = new Radnik(rs.getInt("rad.RadnikID"), rs.getString("rad.Username"), rs.getString("rad.Password"), rs.getString("rad.Ime"), rs.getString("rad.Prezime"));
            Student student = new Student(rs.getInt("s.StudentID"), rs.getString("s.Ime"), rs.getString("s.Prezime"), rs.getString("s.Index"), radnik);
            lista.add(student);
        }
        rs.close();
        return lista;
    }

    @Override
    public String getKoloneZaInsert() {
        return "(ime, prezime, `index`, radnikID)";
    }

    @Override
    public String getVrednostZaPrimarniKljuc() {
        return " StudentID = " + studentID;
    }

    @Override
    public String getVrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', '" + index + "', " + radnik.getRadnikID() + "";
    }

    @Override
    public String getVrednostiZaUpdate() {
        return " ime='" + ime + "', prezime='" + prezime + "', index='" + index + "', radnikID='" + radnik.getRadnikID() + "' ";
    }

    @Override
    public String getUslov() {
        return " ORDER BY s.ime ASC";
    }

}
