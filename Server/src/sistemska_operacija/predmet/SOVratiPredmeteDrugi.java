/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.predmet;

import database.DBBroker;
import domen.AbstractDomainObject;
import domen.Predmet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SOVratiPredmeteDrugi extends OpstaSO{
    
    private List<AbstractDomainObject> predmeti;

    public SOVratiPredmeteDrugi() {
    }

    public List<AbstractDomainObject> getPredmeti() {
        return predmeti;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() throws SQLException {
        List<AbstractDomainObject> sviPredmeti = DBBroker.getInstance().select(new Predmet());
        predmeti = new ArrayList<>();  // Ovo osigurava da je lista inicijalizovana
        for (AbstractDomainObject ado : sviPredmeti) {
            Predmet p = (Predmet) ado;
            if (!p.getUstanova().equals("Fakultet Organizacionih Nauka")) {
                predmeti.add(ado);
            }
        }
    }

}
