/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Razmena;
import java.util.List;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author jovana
 */
//klijent
public class RazmenaKontroler {

    private static RazmenaKontroler instance;

    public RazmenaKontroler() {
    }

    public static RazmenaKontroler getInstance() {
        if (instance == null) {
            instance = new RazmenaKontroler();
        }
        return instance;
    }

    public boolean dodajRazmenu(Razmena novaRazmena) {
        ServerKontroler.getInstance().posaljiZahtev(new KlijentskiZahtev(novaRazmena, Operacije.DODAJ_RAZMENU));
        ServerskiOdgovor so = ServerKontroler.getInstance().primiOdgovor();

        return so.getUspeh() == Operacije.USPEH;
    }

    public List<Razmena> pretraziRazmene(String kriterijum) {
        ServerKontroler.getInstance().posaljiZahtev(new KlijentskiZahtev(kriterijum, Operacije.PRETRAZI_RAZMENU));
        ServerskiOdgovor so = ServerKontroler.getInstance().primiOdgovor();

        return (List<Razmena>) so.getOdgovor();
    }

    public List<Razmena> ucitajListuRazmena(List<Razmena> razmene) {
        ServerKontroler.getInstance().posaljiZahtev(new KlijentskiZahtev(razmene, Operacije.UCITAJ_LISTU_RAZMENA));
        ServerskiOdgovor so = ServerKontroler.getInstance().primiOdgovor();
        
        return (List<Razmena>) so.getOdgovor();
    }
}
