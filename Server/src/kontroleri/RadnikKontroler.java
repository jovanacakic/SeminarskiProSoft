/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.AbstractDomainObject;
import java.util.List;
import sistemska_operacija.radnik.SOPrijaviRadnika;
import domen.*;
import sistemska_operacija.radnik.SOUcitajListuRadnika;
import sistemska_operacija.radnik.SOUcitajRadnika;
/**
 *
 * @author jovana
 */
public class RadnikKontroler {
    //server
    private static RadnikKontroler instancе;

    private RadnikKontroler() {
    }

    public static RadnikKontroler getInstancе() {
        if (instancе == null) {
            instancе = new RadnikKontroler();
        }
        return instancе;
    }

    public AbstractDomainObject prijaviRadnika(Radnik radnik) {
        SOPrijaviRadnika so = new SOPrijaviRadnika(radnik);
        so.izvrsiSistemskuOperaciju();
        return so.getRadnik();
    }

    public AbstractDomainObject ucitajRadnika(Radnik radnik) {
        SOUcitajRadnika so = new SOUcitajRadnika(radnik);
        so.izvrsiSistemskuOperaciju();
        return so.getRadnik();
    }

    public List<AbstractDomainObject> ucitajListuRadnika() {
        SOUcitajListuRadnika so = new SOUcitajListuRadnika();
        so.izvrsiSistemskuOperaciju();
        return so.getRadnici();
    }
}
