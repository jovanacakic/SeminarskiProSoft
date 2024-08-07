/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Predmet;
import sistemska_operacija.predmet.SODodajPredmet;

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
}
