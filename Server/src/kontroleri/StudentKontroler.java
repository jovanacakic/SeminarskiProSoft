/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.AbstractDomainObject;
import java.util.List;
import domen.*;
import sistemska_operacija.student.SODodajStudenta;
import sistemska_operacija.student.SONadjiStudente;
import sistemska_operacija.student.SOUcitajListuStudenata;
import sistemska_operacija.student.SOUcitajStudenta;

/**
 *
 * @author jovana
 */
//SERVER
public class StudentKontroler {

    private static StudentKontroler instance;

    public StudentKontroler() {
    }

    public static StudentKontroler getInstance() {
        if (instance == null) {
            instance = new StudentKontroler();
        }
        return instance;
    }

    public List<AbstractDomainObject> ucitajListuSpasioca() {
        SOUcitajListuStudenata so = new SOUcitajListuStudenata();
        so.izvrsiSistemskuOperaciju();
        return so.getStudenti();
    }

    public AbstractDomainObject ucitajSpasioca(Student student) {
        SOUcitajStudenta so = new SOUcitajStudenta(student);
        so.izvrsiSistemskuOperaciju();
        return so.getStudent();
    }

    public boolean dodajStudenta(Student student) {
        SODodajStudenta so = new SODodajStudenta(student);
        so.izvrsiSistemskuOperaciju();
        return so.isUspeh();
    }

//    public boolean azurirajSpasioca(Spasilac spasilac) {
//        SOAzurirajSpasioca so = new SOAzurirajSpasioca(spasilac);
//        so.izvrsiSistemskuOperaciju();
//        return so.isUspeh();
//    }
//
    public List<AbstractDomainObject> pretraziStudente(String kriterijum) {
        SONadjiStudente so = new SONadjiStudente(kriterijum);
        so.izvrsiSistemskuOperaciju();
        return so.getRezultat();
    }

}
