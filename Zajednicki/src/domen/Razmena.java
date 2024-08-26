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
import konstante.EkvivalentiRazmenaStatus;

/**
 *
 * @author jovana
 */
public class Razmena extends AbstractDomainObject {

    private int razmenaID;
    private Student student;
    private String semestar;
    private String skolskaGodina;
    private Univerzitet univerzitetFon;
    private Univerzitet univerzitetDrugi;
    private List<EkvivalentiRazmena> listaEkvivalenata;

    public Razmena() {
    }

    public Razmena(int razmenaID, Student student, String semestar, String skolskaGodina, Univerzitet univerzitetFon, Univerzitet univerzitetDrugi, List<EkvivalentiRazmena> listaEkvivalenata) {
        this.razmenaID = razmenaID;
        this.student = student;
        this.semestar = semestar;
        this.skolskaGodina = skolskaGodina;
        this.univerzitetFon = univerzitetFon;
        this.univerzitetDrugi = univerzitetDrugi;
        this.listaEkvivalenata = listaEkvivalenata;
    }

    public List<EkvivalentiRazmena> getListaEkvivalenata() {
        return listaEkvivalenata;
    }

    public void setListaEkvivalenata(List<EkvivalentiRazmena> listaEkvivalenata) {
        this.listaEkvivalenata = listaEkvivalenata;
    }

    public int getRazmenaID() {
        return razmenaID;
    }

    public void setRazmenaID(int razmenaID) {
        this.razmenaID = razmenaID;
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
        return " raz ";
    }

//    @Override
//    public String getJoin() {
//        // Join sa tabelom studenta i eventualno ekvivalentima
//        return "JOIN student s ON r.StudentID = s.ID";
//    }
    @Override
    public String getJoin() {
        return "JOIN student s ON raz.StudentID = s.StudentID "
                + "LEFT JOIN ekvivalenti_razmena er ON raz.RazmenaID = er.RazmenaID "
                + "LEFT JOIN ekvivalenti e ON er.EkvivalentiID = e.EkvivalentiID "
                + "JOIN predmet p1 ON e.PredmetFonID = p1.PredmetID "
                + "JOIN predmet p2 ON e.PredmetDrugiUniverzitetID = p2.PredmetID"
                + " JOIN univerzitet u1 ON u1.UniverzitetID = p1.UniverzitetID "
                + " JOIN univerzitet u2 ON u2.UniverzitetID = p2.UniverzitetID ";
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
            Radnik radnik = new Radnik();
            int razmenaId = rs.getInt("raz.RazmenaID");
            Razmena razmena = razmene.get(razmenaId);
            Univerzitet fon = new Univerzitet(rs.getInt("u1.UniverzitetID"), rs.getString("u1.Naziv"), rs.getString("u1.Grad"));
            Univerzitet drugiUni = new Univerzitet(rs.getInt("u2.UniverzitetID"), rs.getString("u2.Naziv"), rs.getString("u2.Grad"));

            if (razmena == null) {
                razmena = new Razmena(
                        razmenaId,
                        new Student(rs.getInt("s.StudentID"), rs.getString("s.Ime"), rs.getString("s.Prezime"), rs.getString("s.Index"), radnik),
                        rs.getString("raz.Semestar"),
                        rs.getString("raz.SkolskaGodina"),
                        fon,
                        drugiUni,
                        new ArrayList<>()
                );
                razmene.put(razmenaId, razmena);
            }

            if (rs.getInt("er.EkvivalentiID") != 0) {

                Ekvivalenti ekvivalent = new Ekvivalenti(
                        rs.getInt("e.EkvivalentiID"),
                        new Predmet(rs.getInt("p1.predmetID"), rs.getString("p1.Naziv"), fon, rs.getString("p1.Semestar"), rs.getInt("p1.Espb"), radnik),
                        new Predmet(rs.getInt("p2.predmetID"), rs.getString("p2.Naziv"), drugiUni, rs.getString("p2.Semestar"), rs.getInt("p2.Espb"), radnik),
                        rs.getInt("e.GodinaDodavanja")
                );
                razmena.getListaEkvivalenata().add(new EkvivalentiRazmena(
                        rs.getInt("er.RB"),
                        razmena,
                        ekvivalent,
                        rs.getInt("er.Ocena"),
                        EkvivalentiRazmenaStatus.UNCHANGED
                ));
            }
        }
        rs.close();
        return new ArrayList<>(razmene.values());
    }

    @Override
    public String getKoloneZaInsert() {
        return "(StudentID, Semestar, SkolskaGodina, UniverzitetFonID, UniverzitetDrugiID)";
    }

    @Override
    public String getVrednostZaPrimarniKljuc() {
        return " RazmenaID = " + razmenaID;
    }

    @Override
    public String getVrednostiZaInsert() {
        return student.getStudentID() + ", '" + semestar + "', '" + skolskaGodina + "', " + univerzitetFon.getUniverzitetID() + ", " + univerzitetDrugi.getUniverzitetID();
    }

    @Override
    public String getVrednostiZaUpdate() {
        return " StudentID = " + student.getStudentID()
                + ", Semestar = '" + semestar
                + "', SkolskaGodina = '" + skolskaGodina
                + "', univerzitetFonID = " + univerzitetFon.getUniverzitetID()
                + ", univerzitetDrugiID = " + univerzitetDrugi.getUniverzitetID();
    }

    @Override
    public String getUslov() {
        return " ORDER BY raz.SkolskaGodina DESC, raz.Semestar ASC";
    }

    @Override
    public String toString() {
        return "Razmena: " + student.getIme() + " " + student.getPrezime() + " (" + univerzitetFon.getNaziv() + "-" + univerzitetDrugi.getNaziv() + ") " + " - " + semestar + " " + skolskaGodina;
    }

    public Univerzitet getUniverzitetFon() {
        return univerzitetFon;
    }

    public void setUniverzitetFon(Univerzitet univerzitetFon) {
        this.univerzitetFon = univerzitetFon;
    }

    public Univerzitet getUniverzitetDrugi() {
        return univerzitetDrugi;
    }

    public void setUniverzitetDrugi(Univerzitet univerzitetDrugi) {
        this.univerzitetDrugi = univerzitetDrugi;
    }

}
