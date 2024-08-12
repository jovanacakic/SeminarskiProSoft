/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.student;

import database.DBBroker;
import domen.AbstractDomainObject;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SODodajStudenta extends OpstaSO {

    private final AbstractDomainObject student;
    private boolean uspeh = false;

    public SODodajStudenta(AbstractDomainObject student) {
        this.student = student;
    }

    public boolean isUspeh() {
        return uspeh;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() throws Exception {
        //uspeh = DBBroker.getInstance().insert(student);
        DBBroker.getInstance().insert(student);
        uspeh = true;
    }

}
