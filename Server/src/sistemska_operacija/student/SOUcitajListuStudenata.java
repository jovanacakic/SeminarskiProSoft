/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.student;

import database.DBBroker;
import domen.AbstractDomainObject;
import domen.Student;
import java.util.List;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SOUcitajListuStudenata extends OpstaSO{
    
    private List<AbstractDomainObject> studenti;

    public List<AbstractDomainObject> getStudenti() {
        return studenti;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() {
        studenti = DBBroker.getInstance().getAllOpstiDomenskiObjekats(new Student());
    }

}
