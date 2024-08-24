/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Univerzitet;
import sistemska_operacija.univerzitet.SODodajUniverzitet;

/**
 *
 * @author jovana
 */
//server
public class UniverzitetKontroler {

    public static UniverzitetKontroler instance;

    public static UniverzitetKontroler getInstance() {
        if (instance == null) {
            instance = new UniverzitetKontroler();
        }
        return instance;
    }

    public boolean dodajUniverzitet(Univerzitet univerzitet) {
        SODodajUniverzitet so = new SODodajUniverzitet(univerzitet);
        so.izvrsiSistemskuOperaciju();

        return so.isUspeh();
    }

}
