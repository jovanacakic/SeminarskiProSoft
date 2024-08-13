/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.AbstractDomainObject;
import domen.Razmena;
import java.util.List;
import sistemska_operacija.razmena.SODodajRazmenu;
import sistemska_operacija.razmena.SONadjiRazmene;
import sistemska_operacija.razmena.SOUcitajListuRazmena;

/**
 *
 * @author jovana
 */
//server
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

    public List<AbstractDomainObject> pretraziRazmene(String kriterijum) {
        SONadjiRazmene so = new SONadjiRazmene(kriterijum);
        so.izvrsiSistemskuOperaciju();
        if(so.getRezultat() == null)System.out.println("HELLO");
        return so.getRezultat();
    }

    public List<AbstractDomainObject> ucitajListuRazmena() {
        SOUcitajListuRazmena so = new SOUcitajListuRazmena();
        so.izvrsiSistemskuOperaciju();
        return so.getRazmene();
    }
}
