/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Student;
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
        ServerKontroler.getInstanca().posaljiZahtev(new KlijentskiZahtev(s, Operacije.DODAJ_STUDENTA));
        ServerskiOdgovor so = ServerKontroler.getInstanca().primiOdgovor();

        return so.getUspeh() == Operacije.USPEH;

    }
}
