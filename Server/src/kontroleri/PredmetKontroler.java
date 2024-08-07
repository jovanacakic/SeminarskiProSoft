/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.AbstractDomainObject;
import domen.Predmet;
import java.util.List;
import sistemska_operacija.predmet.SODodajPredmet;
import sistemska_operacija.predmet.SOVratiPredmeteDrugi;
import sistemska_operacija.predmet.SOVratiPredmeteFon;

/**
 *
 * @author jovana
 */
//server
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
    public boolean dodajPredmet(Predmet predmet){
        SODodajPredmet so = new SODodajPredmet(predmet);
        so.izvrsiSistemskuOperaciju();
        return so.isUspeh();
    }

    public List<AbstractDomainObject> vratiPredmeteFon() {
        SOVratiPredmeteFon so = new SOVratiPredmeteFon();
        so.izvrsiSistemskuOperaciju();
        return so.getPredmeti();
    }

    public List<AbstractDomainObject> vratiPredmeteDrugi() {
        SOVratiPredmeteDrugi so = new SOVratiPredmeteDrugi();
        so.izvrsiSistemskuOperaciju();
        return so.getPredmeti();
    }
}
