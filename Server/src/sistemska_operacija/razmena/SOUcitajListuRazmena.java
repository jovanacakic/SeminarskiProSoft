/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.razmena;

import database.DBBroker;
import domen.AbstractDomainObject;
import domen.Razmena;
import java.sql.SQLException;
import java.util.List;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SOUcitajListuRazmena extends OpstaSO {

    private List<AbstractDomainObject> razmene;

    public List<AbstractDomainObject> getRazmene() {
        return razmene;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() throws SQLException {
        razmene = DBBroker.getInstance().select(new Razmena());
    }
}
