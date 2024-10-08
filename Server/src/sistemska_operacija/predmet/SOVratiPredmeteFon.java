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
public class SOVratiPredmeteFon extends OpstaSO {

    private List<AbstractDomainObject> predmeti;

    public SOVratiPredmeteFon() {
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
            if (p.getUniverzitet().getNaziv().equals("Fakultet Organizacionih Nauka")) {
                predmeti.add(ado);
            }
        }
    }
//    @Override
//    protected void izvrsiSpecificnuOperaciju() throws SQLException {
//        Predmet p = new Predmet(-1, "", "Fakultet Organizacionih Nauka", "", 0);
//        predmeti= DBBroker.getInstance().select(p);
//        
//
//    }

}
