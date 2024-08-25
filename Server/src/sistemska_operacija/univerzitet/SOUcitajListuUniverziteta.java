/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.univerzitet;

import database.DBBroker;
import domen.AbstractDomainObject;
import domen.Univerzitet;
import java.util.ArrayList;
import java.util.List;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SOUcitajListuUniverziteta extends OpstaSO {

    List<AbstractDomainObject> lista;

    public SOUcitajListuUniverziteta() {
        lista = new ArrayList<>();
    }

    public List<AbstractDomainObject> getLista() {
        return lista;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() throws Exception {
        lista = DBBroker.getInstance().select(new Univerzitet());
    }

}
