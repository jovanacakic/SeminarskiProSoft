/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Razmena(int id, Student student, String semestar, String skolskaGodina, List<EkvivalentiRazmena> listaEkvNaRazmeni) {
        this.id = id;
        this.student = student;
        this.semestar = semestar;
        this.skolskaGodina = skolskaGodina;
        this.listaEkvivalenata = listaEkvNaRazmeni;
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

//    @Override
//    public String getJoin() {
//        // Join sa tabelom studenta i eventualno ekvivalentima
//        return "JOIN student s ON r.StudentID = s.ID";
//    }
    @Override
    public String getJoin() {
        return "JOIN student s ON r.StudentID = s.ID "
                + "LEFT JOIN ekvivalenti_razmena er ON r.RazmenaID = er.RazmenaID "
                + "LEFT JOIN ekvivalenti e ON er.EkvivalentiID = e.ID "
                + "JOIN predmet p1 ON e.PredmetFon = p1.ID "
                + "JOIN predmet p2 ON e.PredmetDrugiFakultet = p2.ID";
    }
//    @Override
//    public ArrayList<AbstractDomainObject> getListuSvih(ResultSet rs) throws SQLException {
//        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
//        while (rs.next()) {
//            Student student = new Student(
//                    rs.getInt("s.ID"),
//                    rs.getString("s.Ime"),
//                    rs.getString("s.Prezime"),
//                    rs.getString("s.Index"));
//
//            Razmena razmena = new Razmena(
//                    rs.getInt("r.RazmenaID"),
//                    student,
//                    rs.getString("r.Semestar"),
//                    rs.getString("r.SkolskaGodina"),
//                    new ArrayList<>()
//            );
//            lista.add(razmena);
//        }
//        rs.close();
//        return lista;
//    }

    @Override
    public ArrayList<AbstractDomainObject> getListuSvih(ResultSet rs) throws SQLException {
        Map<Integer, Razmena> razmene = new HashMap<>();
        while (rs.next()) {
            int razmenaId = rs.getInt("r.RazmenaID");
            Razmena razmena = razmene.get(razmenaId);
            if (razmena == null) {
                razmena = new Razmena(
                        razmenaId,
                        new Student(rs.getInt("s.ID"), rs.getString("s.Ime"), rs.getString("s.Prezime"), rs.getString("s.Index")),
                        rs.getString("r.Semestar"),
                        rs.getString("r.SkolskaGodina"),
                        new ArrayList<>()
                );
                razmene.put(razmenaId, razmena);
            }

            if (rs.getInt("er.EkvivalentiID") != 0) {
                Ekvivalenti ekvivalent = new Ekvivalenti(
                        rs.getInt("e.ID"),
                        new Predmet(rs.getInt("p1.ID"), rs.getString("p1.Naziv"), rs.getString("p1.Ustanova"), rs.getString("p1.Semestar"), rs.getInt("p1.Espb")),
                        new Predmet(rs.getInt("p2.ID"), rs.getString("p2.Naziv"), rs.getString("p2.Ustanova"), rs.getString("p2.Semestar"), rs.getInt("p2.Espb")),
                        rs.getInt("e.GodinaDodavanja")
                );
                razmena.getListaEkvivalenata().add(new EkvivalentiRazmena(
                        rs.getInt("er.RB"),
                        razmena,
                        ekvivalent,
                        rs.getInt("er.Ocena")
                ));
            }
        }
        rs.close();
        return new ArrayList<>(razmene.values());
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
        return student.getStudentID() + ", '" + semestar + "', '" + skolskaGodina + "'";
    }

    @Override
    public String getVrednostiZaUpdate() {
        return " StudentID = " + student.getStudentID()
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
