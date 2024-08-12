/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.AbstractDomainObject;
import domen.Ekvivalenti;
import java.util.List;
import sistemska_operacija.ekvivalenti.SODodajEkvivalente;
import sistemska_operacija.ekvivalenti.SOVratiEkvivalente;

/**
 *
 * @author jovana
 */
//server
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
        SODodajEkvivalente so = new SODodajEkvivalente(e);
        so.izvrsiSistemskuOperaciju();
        return so.isUspeh();
    }

    public List<AbstractDomainObject> vratiEkvivalente() {
        SOVratiEkvivalente so = new SOVratiEkvivalente();
        so.izvrsiSistemskuOperaciju();
        return so.getEkvivalenti();
    }
}
