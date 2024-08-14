/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.predmet;

import database.DBBroker;
import domen.AbstractDomainObject;
import domen.Predmet;
import java.sql.SQLException;
import java.util.List;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SOUcitajListuPredmeta extends OpstaSO {

    private List<AbstractDomainObject> predmeti;

    public List<AbstractDomainObject> getPredmeti() {
        return predmeti;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() throws SQLException {
        predmeti = DBBroker.getInstance().select(new Predmet());
    }
}
