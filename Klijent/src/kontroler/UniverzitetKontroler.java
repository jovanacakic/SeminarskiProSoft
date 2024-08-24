/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Univerzitet;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author jovana
 */
//klijent
public class UniverzitetKontroler {
    public static UniverzitetKontroler instance;

    public static UniverzitetKontroler getInstance() {
        if(instance == null){
            instance = new UniverzitetKontroler();
        }
        return instance;
    }

    public boolean dodajUniverzitet(Univerzitet univerzitet) {
        ServerKontroler.getInstance().posaljiZahtev(new KlijentskiZahtev(univerzitet, Operacije.DODAJ_UNIVERZITET));
        ServerskiOdgovor so = ServerKontroler.getInstance().primiOdgovor();
        
        return so.getUspeh() == Operacije.USPEH;
    }
    
}
