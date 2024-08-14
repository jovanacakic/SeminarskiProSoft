/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Predmet;
import java.util.List;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author jovana
 */
//klijent
public class PredmetKontroler {

    private static PredmetKontroler instance;

    public PredmetKontroler() {
    }

    public static PredmetKontroler getInstance() {
        if (instance == null) {
            instance = new PredmetKontroler();
        }
        return instance;
    }

    public boolean dodajPredmet(Predmet p1) {
        ServerKontroler.getInstance().posaljiZahtev(new KlijentskiZahtev(p1, Operacije.DODAJ_PREDMET));
        ServerskiOdgovor so = ServerKontroler.getInstance().primiOdgovor();

        return so.getUspeh() == Operacije.USPEH;
    }

    public List<Predmet> vratiPredmeteFon() {
        ServerKontroler.getInstance().posaljiZahtev(new KlijentskiZahtev(null, Operacije.VRATI_PRED_FON));
        ServerskiOdgovor so = ServerKontroler.getInstance().primiOdgovor();

        return (List<Predmet>) so.getOdgovor();
    }

    public List<Predmet> vratiPredmeteDrugiFaks() {
        ServerKontroler.getInstance().posaljiZahtev(new KlijentskiZahtev(null, Operacije.VRATI_PRED_DRUGI));
        ServerskiOdgovor so = ServerKontroler.getInstance().primiOdgovor();

        return (List<Predmet>) so.getOdgovor();
    }

    public boolean obrisiPredmet(Predmet p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean azurirajPredmet(Predmet p) {
        ServerKontroler.getInstance().posaljiZahtev(new KlijentskiZahtev(p, Operacije.AZURIRAJ_PREDMET));
        ServerskiOdgovor so = ServerKontroler.getInstance().primiOdgovor();

        return so.getUspeh() == Operacije.USPEH;
    }

    public List<Predmet> pretraziPredmete(String kriterijum) {
        ServerKontroler.getInstance().posaljiZahtev(new KlijentskiZahtev(kriterijum, Operacije.PRETRAZI_PREDMETE));
        ServerskiOdgovor so = ServerKontroler.getInstance().primiOdgovor();

        return (List<Predmet>) so.getOdgovor();
    }

    public List<Predmet> ucitajListuPredmeta(List<Predmet> predmeti) {
        ServerKontroler.getInstance().posaljiZahtev(new KlijentskiZahtev(null, Operacije.UCITAJ_LISTU_PREDMETA));
        ServerskiOdgovor so = ServerKontroler.getInstance().primiOdgovor();

        return (List<Predmet>) so.getOdgovor();
    }
}
