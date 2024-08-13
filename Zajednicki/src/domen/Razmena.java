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
public class Razmena extends AbstractDomainObject {

    private int id;
    private Student student;
    private String semestar;
    private String skolskaGodina;
    private List<EkvivalentiRazmena> listaEkvivalenata;

    public Razmena() {
    }

    public Razmena(int id, Student student, String semestar, String skolskaGodina, List<EkvivalentiRazmena> listaPredmeta) {
        this.id = id;
        this.student = student;
        this.semestar = semestar;
        this.skolskaGodina = skolskaGodina;
        this.listaEkvivalenata = listaPredmeta;
    }

    public List<EkvivalentiRazmena> getListaEkvivalenata() {
        return listaEkvivalenata;
    }

    public void setListaEkvivalenata(List<EkvivalentiRazmena> listaEkvivalenata) {
        this.listaEkvivalenata = listaEkvivalenata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSemestar() {
        return semestar;
    }

    public void setSemestar(String semestar) {
        this.semestar = semestar;
    }

    public String getSkolskaGodina() {
        return skolskaGodina;
    }

    public void setSkolskaGodina(String skolskaGodina) {
        this.skolskaGodina = skolskaGodina;
    }

    @Override
    public String getTableName() {
        return "razmena";
    }

    @Override
    public String getAlias() {
        return " r ";
    }

    @Override
    public String getJoin() {
        // Join sa tabelom studenta i eventualno ekvivalentima
        return "JOIN student s ON r.StudentID = s.ID";
    }

    @Override
    public ArrayList<AbstractDomainObject> getListuSvih(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student(
                    rs.getInt("s.ID"),
                    rs.getString("s.Ime"),
                    rs.getString("s.Prezime"),
                    rs.getString("s.Index"));

            Razmena razmena = new Razmena(
                    rs.getInt("r.RazmenaID"),
                    student,
                    rs.getString("r.Semestar"),
                    rs.getString("r.SkolskaGodina"),
                    new ArrayList<>()
            );
            lista.add(razmena);
        }
        rs.close();
        return lista;
    }

    @Override
    public String getKoloneZaInsert() {
        return "(StudentID, Semestar, SkolskaGodina)";
    }

    @Override
    public String getVrednostZaPrimarniKljuc() {
        return " RazmenaID = " + id;
    }

    @Override
    public String getVrednostiZaInsert() {
        return student.getId() + ", '" + semestar + "', '" + skolskaGodina + "'";
    }

    @Override
    public String getVrednostiZaUpdate() {
        return " StudentID = " + student.getId()
                + ", Semestar = '" + semestar
                + "', SkolskaGodina = '" + skolskaGodina + "' ";
    }

    @Override
    public String getUslov() {
        return " ORDER BY r.SkolskaGodina DESC, r.Semestar ASC";
    }

    @Override
    public String toString() {
        return "Razmena: " + student.getIme() + " " + student.getPrezime() + " - " + semestar + " " + skolskaGodina;
    }

}
