/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Ekvivalenti;
import java.util.List;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author jovana
 */
//klijent
public class EkvivalentiKontroler {

    private static EkvivalentiKontroler instance;

    public EkvivalentiKontroler() {
    }

    public static EkvivalentiKontroler getInstance() {
        if (instance == null) {
            instance = new EkvivalentiKontroler();
        }
        return instance;
    }

    public boolean dodajEkvivalente(Ekvivalenti e) {
        ServerKontroler.getInstance().posaljiZahtev(new KlijentskiZahtev(e, Operacije.DODAJ_EKVIVALENTE));
        ServerskiOdgovor so = ServerKontroler.getInstance().primiOdgovor();

        return so.getUspeh() == Operacije.USPEH;
    }

    public List<Ekvivalenti> vratiEkvivalente() {
        ServerKontroler.getInstance().posaljiZahtev(new KlijentskiZahtev(null, Operacije.VRATI_EKVIVALENTE));
        ServerskiOdgovor so = ServerKontroler.getInstance().primiOdgovor();

        return (List<Ekvivalenti>) so.getOdgovor();
    }
}
