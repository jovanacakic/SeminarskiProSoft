/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.radnik;

import database.DBBroker;
import domen.AbstractDomainObject;
import java.util.List;
import domen.*;
import java.sql.SQLException;
import sistemska_operacija.OpstaSO;
/**
 *
 * @author jovana
 */
public class SOPrijaviRadnika extends OpstaSO {

    private AbstractDomainObject radnik;
    private AbstractDomainObject prijavljeni;

    public SOPrijaviRadnika(AbstractDomainObject radnik) {
        this.radnik = radnik;
        prijavljeni = null;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() throws SQLException {
        List<AbstractDomainObject> radnici = DBBroker.getInstance().select(radnik);
        Radnik uneti = (Radnik) radnik;
        for (AbstractDomainObject odo : radnici) {
            Radnik r = (Radnik) odo;
            if (r.getUsername().equals(uneti.getUsername()) && r.getPassword().equals(uneti.getPassword())) {
                this.prijavljeni = r;
            }
        }
    }

    public AbstractDomainObject getRadnik() {
        return prijavljeni;
    }

}
