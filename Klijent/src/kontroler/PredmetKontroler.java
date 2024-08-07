/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Predmet;
import java.util.HashMap;
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
        if(instance == null){
            instance = new PredmetKontroler();
        }
        return instance;
    }
    public boolean dodajPredmet(Predmet p1){
        ServerKontroler.getInstanca().posaljiZahtev(new KlijentskiZahtev(p1, Operacije.DODAJ_PREDMET));
        ServerskiOdgovor so = ServerKontroler.getInstanca().primiOdgovor();
        
        return so.getUspeh() == Operacije.USPEH;
    }

    public List<Predmet> vratiPredmeteFon() {
        ServerKontroler.getInstanca().posaljiZahtev(new KlijentskiZahtev(null, Operacije.VRATI_PRED_FON));
        ServerskiOdgovor so = ServerKontroler.getInstanca().primiOdgovor();
        
        return (List<Predmet>) so.getOdgovor();
    }

    public List<Predmet> vratiPredmeteDrugiFaks() {
        ServerKontroler.getInstanca().posaljiZahtev(new KlijentskiZahtev(null, Operacije.VRATI_PRED_DRUGI));
        ServerskiOdgovor so = ServerKontroler.getInstanca().primiOdgovor();
        
        return (List<Predmet>) so.getOdgovor();
    }
}
