/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Student;
import java.util.List;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
//klijent

/**
 *
 * @author jovana
 */
public class StudentKontroler {

    private static StudentKontroler instance;

    public StudentKontroler() {
    }

    public static StudentKontroler getInstance() {
        if (instance == null) {
            instance = new StudentKontroler();
        }
        return instance;
    }

    public boolean dodajStudenta(Student s) {
        ServerKontroler.getInstance().posaljiZahtev(new KlijentskiZahtev(s, Operacije.DODAJ_STUDENTA));
        ServerskiOdgovor so = ServerKontroler.getInstance().primiOdgovor();

        return so.getUspeh() == Operacije.USPEH;

    }

    public List<Student> pretraziStudente(String kriterijum) {
        ServerKontroler.getInstance().posaljiZahtev(new KlijentskiZahtev(kriterijum, Operacije.PRETRAZI_STUDENTE));
        ServerskiOdgovor o = ServerKontroler.getInstance().primiOdgovor();

        return (List<Student>) o.getOdgovor();
    }

    public List<Student> ucitajListuStudenata(List<Student> studenti) {
        ServerKontroler.getInstance().posaljiZahtev(new KlijentskiZahtev(studenti, Operacije.UCITAJ_LISTU_STUDENATA));
        ServerskiOdgovor o = ServerKontroler.getInstance().primiOdgovor();

        return (List<Student>) o.getOdgovor();
    }

    public Student ucitajSpasioca(Student student) {
        ServerKontroler.getInstance().posaljiZahtev(new KlijentskiZahtev(student, Operacije.UCITAJ_STUDENTA));
        ServerskiOdgovor o = ServerKontroler.getInstance().primiOdgovor();

        return (Student) o.getOdgovor();
    }

    public boolean azurirajStudenta(Student student) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
