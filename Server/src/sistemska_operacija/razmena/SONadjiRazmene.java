/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.razmena;

import database.DBBroker;
import domen.AbstractDomainObject;
import domen.Razmena;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SONadjiRazmene extends OpstaSO {

    private List<AbstractDomainObject> rezultat;
    private final String kriterijum;

     public SONadjiRazmene(String kriterijum) {
        this.kriterijum = kriterijum;
    }

    public List<AbstractDomainObject> getRezultat() {
        return rezultat;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() throws SQLException {
        List<AbstractDomainObject> sveRazmene = DBBroker.getInstance().select(new Razmena());
        rezultat = new ArrayList<>();
        for (AbstractDomainObject odo : sveRazmene) {
            Razmena r = (Razmena) odo;
            if (sadrziKriterijum(r)) {
                rezultat.add(r);
            }
        }
    }

    private boolean sadrziKriterijum(Razmena r) {
        return r.getStudent().getIme().toLowerCase().contains(kriterijum.toLowerCase())
                || r.getStudent().getPrezime().toLowerCase().contains(kriterijum.toLowerCase())
                || r.getStudent().getIndex().toLowerCase().contains(kriterijum);
    }

}
