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
            openConnection();
            izvrsiSpecificnuOperaciju();
            commit();
            closeConnection();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            rollback();
            closeConnection();
        }
    }

    protected abstract void izvrsiSpecificnuOperaciju() throws Exception;

    private void openConnection() {
        DBBroker.getInstance().otvoriKonekciju();
    }

    private void closeConnection() {
        DBBroker.getInstance().zatvoriKonekciju();
    }

    private void commit() throws Exception {
        DBBroker.getInstance().commit();
    }
    
    private void rollback() {
        DBBroker.getInstance().rollback();
    }

}
