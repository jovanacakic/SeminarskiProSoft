/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Radnik;
import java.util.List;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
//KLIJENT
/**
 *
 * @author jovana
 */
public class RadnikKontroler {

    private static RadnikKontroler instance;

    public RadnikKontroler() {
    }

    public static RadnikKontroler getInstance() {
        if (instance == null) {
            instance = new RadnikKontroler();
        }
        return instance;
    }

    public boolean prijaviRadnika(Radnik radnik) {
        ServerKontroler.getInstanca().posaljiZahtev(new KlijentskiZahtev(radnik, Operacije.PRIJAVI_RADNIKA));
        ServerskiOdgovor odgovor = ServerKontroler.getInstanca().primiOdgovor();

        return odgovor.getUspeh() == Operacije.USPEH;
    }

    public Radnik ucitajRadnika(Radnik radnik) {
        ServerKontroler.getInstanca().posaljiZahtev(new KlijentskiZahtev(radnik, Operacije.UCITAJ_RADNIKA));
        ServerskiOdgovor odgovor = ServerKontroler.getInstanca().primiOdgovor();

        return (Radnik) odgovor.getOdgovor();
    }

    public List<Radnik> ucitajListuKoordinatora(List<Radnik> radnici) {
        ServerKontroler.getInstanca().posaljiZahtev(new KlijentskiZahtev(radnici, Operacije.UCITAJ_LISTU_RADNIKA));
        ServerskiOdgovor odgovor = ServerKontroler.getInstanca().primiOdgovor();

        return (List<Radnik>) odgovor.getOdgovor();
    }

}
