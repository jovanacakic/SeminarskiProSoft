/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija;

import database.DBBroker;

/**
 *
 * @author jovana
 */
public abstract class OpstaSO {
    
    public final void izvrsiSistemskuOperaciju() {
        try {
            DBBroker.getInstance().otvoriKonekciju();
            izvrsiSpecificnuOperaciju();
            DBBroker.getInstance().commit();
            DBBroker.getInstance().zatvoriKonekciju();
        } catch (Exception ex) {
            DBBroker.getInstance().rollback();
            DBBroker.getInstance().zatvoriKonekciju();
        }
    }

    protected abstract void izvrsiSpecificnuOperaciju();
}
