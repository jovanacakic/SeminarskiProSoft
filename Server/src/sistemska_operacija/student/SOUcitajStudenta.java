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
public class SOUcitajStudenta extends OpstaSO {

    private AbstractDomainObject student;

    public SOUcitajStudenta(AbstractDomainObject student) {
        this.student = student;
    }

    public AbstractDomainObject getStudent() {
        return student;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() {
        student = DBBroker.getInstance().getOpstiDomenskiObjekatPoParametru(student);
    }

}
