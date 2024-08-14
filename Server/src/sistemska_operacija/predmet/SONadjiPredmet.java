/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.predmet;

import database.DBBroker;
import domen.AbstractDomainObject;
import domen.Predmet;
import java.util.ArrayList;
import java.util.List;
import sistemska_operacija.OpstaSO;
import java.sql.*;

/**
 *
 * @author jovana
 */
public class SONadjiPredmet extends OpstaSO {

    private List<AbstractDomainObject> rezultat;
    private final String kriterijum;

     public SONadjiPredmet(String kriterijum) {
        this.kriterijum = kriterijum;
    }

    public List<AbstractDomainObject> getRezultat() {
        return rezultat;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() throws SQLException {
        List<AbstractDomainObject> sviPredmeti = DBBroker.getInstance().select(new Predmet());
        rezultat = new ArrayList<>();
        for (AbstractDomainObject odo : sviPredmeti) {
            Predmet p = (Predmet) odo;
            if (sadrziKriterijum(p)) {
                rezultat.add(p);
            }
        }
    }

    private boolean sadrziKriterijum(Predmet p) {
        return p.getNaziv().toLowerCase().contains(kriterijum.toLowerCase())
                || p.getUstanova().toLowerCase().contains(kriterijum.toLowerCase())
                || p.getSemestar().toLowerCase().contains(kriterijum);
    }
}
