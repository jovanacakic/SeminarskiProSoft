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

    private AbstractDomainObject radnikSaKredencijalima;
    private AbstractDomainObject prijavljeni;

    public SOPrijaviRadnika(AbstractDomainObject radnik) {
        this.radnikSaKredencijalima = radnik;
        prijavljeni = null;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() throws SQLException {
        List<AbstractDomainObject> radnici = DBBroker.getInstance().select(radnikSaKredencijalima);
        Radnik uneti = (Radnik) radnikSaKredencijalima;
        for (AbstractDomainObject odo : radnici) {
            Radnik r = (Radnik) odo;
            if (r.getUsername().equals(uneti.getUsername()) && r.getPassword().equals(uneti.getPassword())) {
                this.prijavljeni = r;
                Radnik provera = (Radnik) prijavljeni;
            }
        }
    }

    public AbstractDomainObject getPrijavljeni() {
        return prijavljeni;
    }

}
