/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.student;

import database.DBBroker;
import domen.AbstractDomainObject;
import domen.Student;
import java.util.ArrayList;
import java.util.List;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SONadjiStudente extends OpstaSO {

    private List<AbstractDomainObject> rezultat;
    private final String kriterijum;

    public SONadjiStudente(String kriterijum) {
        this.kriterijum = kriterijum;
    }

    public List<AbstractDomainObject> getRezultat() {
        return rezultat;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() {
        List<AbstractDomainObject> sviStudenti = DBBroker.getInstance().getAllOpstiDomenskiObjekats(new Student());
        rezultat = new ArrayList<>();

        for (AbstractDomainObject odo : sviStudenti) {
            Student s = (Student) odo;
            if (sadrziKriterijum(s)) {
                rezultat.add(s);
            }
        }
    }

    private boolean sadrziKriterijum(Student s) {
        return s.getIme().toLowerCase().contains(kriterijum.toLowerCase())
                || s.getPrezime().toLowerCase().contains(kriterijum.toLowerCase());
    }

}
