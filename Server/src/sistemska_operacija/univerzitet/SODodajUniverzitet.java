/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.univerzitet;

import database.DBBroker;
import domen.AbstractDomainObject;
import domen.Univerzitet;
import java.util.ArrayList;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SODodajUniverzitet extends OpstaSO{

    AbstractDomainObject univerzitet;
    boolean uspeh = false;

    public SODodajUniverzitet(AbstractDomainObject univerzitet) {
        this.univerzitet = univerzitet;
    }
    
@Override
protected void izvrsiSpecificnuOperaciju() throws Exception {
    Univerzitet uni = (Univerzitet) univerzitet;
    ArrayList<AbstractDomainObject> sviUniverziteti = DBBroker.getInstance().select(univerzitet);

    boolean postoji = false;
    for (AbstractDomainObject obj : sviUniverziteti) {
        Univerzitet u = (Univerzitet) obj;

        if (u.getNaziv().equalsIgnoreCase(uni.getNaziv()) && u.getGrad().equalsIgnoreCase(uni.getGrad())) {
            postoji = true;
            break;
        }
    }

    if (!postoji) {
        DBBroker.getInstance().insert(univerzitet);
        uspeh = true;
    } else {
        uspeh = false;
        System.err.println("Univerzitet sa istim nazivom i gradom već postoji.");
    }
}


    public boolean isUspeh() {
        return uspeh;
    }
    
}
