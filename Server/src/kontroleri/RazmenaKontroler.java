/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Razmena;
import konstante.Operacije;
import sistemska_operacija.razmena.SODodajRazmenu;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author jovana
 */
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
        SODodajRazmenu so = new SODodajRazmenu(novaRazmena);
        so.izvrsiSistemskuOperaciju();
        return so.isUspeh();
    }
}
