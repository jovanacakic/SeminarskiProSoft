/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.razmena;

import database.DBBroker;
import domen.AbstractDomainObject;
import domen.EkvivalentiRazmena;
import domen.Razmena;
import sistemska_operacija.OpstaSO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jovana
 */
public class SOAzurirajRazmenu extends OpstaSO {

    Razmena razmena;
    boolean uspeh = false;

    public SOAzurirajRazmenu(Razmena razmena) {
        this.razmena = razmena;
    }

    public boolean isUspeh() {
        return uspeh;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() throws Exception {
        for (EkvivalentiRazmena er : razmena.getListaEkvivalenata()) {
            switch (er.getStatus()) {
                case NEW:
                    DBBroker.getInstance().insert(er);
                    break;
                case UPDATED:
                    DBBroker.getInstance().update(er);
                    break;
                case DELETED:
                    DBBroker.getInstance().delete(er);
                    break;
                case UNCHANGED:
                    // nista ne radimo
                    break;
            }

        }

    }
//
//    @Override
//    protected void izvrsiSpecificnuOperaciju() throws Exception {
//        ArrayList<AbstractDomainObject> listaubazi = new ArrayList<>();
//        listaubazi = DBBroker.getInstance().select(new EkvivalentiRazmena(0, razmena, null, 0));
//        for (int i = 0; i < listaubazi.size(); i++) {
//
//            EkvivalentiRazmena er = new EkvivalentiRazmena();
//            er.setRazmena(razmena);
//            er.setRb(i + 1);
//            uspeh = DBBroker.getInstance().delete(er);
//        }
//        for (EkvivalentiRazmena er : razmena.getListaEkvivalenata()) {
//            DBBroker.getInstance().insert(er);
//        }
//
//    }
//    @Override
//    protected void izvrsiSpecificnuOperaciju() throws Exception {
//        try {
//            ArrayList<AbstractDomainObject> listaubazi = new ArrayList<>();
//            try {
//                
//            listaubazi = DBBroker.getInstance().select(new EkvivalentiRazmena(0, razmena, null, 0));
//            } catch (Exception e) {
//                System.out.println("traaaaaaaalalalalallalalala");
//            }
//
//            int razlika = listaubazi.size() - razmena.getListaEkvivalenata().size();
//            if (razlika < 0) {
//
//                for (EkvivalentiRazmena er : razmena.getListaEkvivalenata()) {
//                    System.out.println(er.getRb() + " " + er.getEkvivalenti().getId());
//                    uspeh = DBBroker.getInstance().update(er);
//                    if (!uspeh) {
//                        System.err.println("Update nije uspeo za EkvivalentiRazmena: RB = " + er.getRb());
//                        DBBroker.getInstance().insert(er);
//                    }
//                }
//            } else {
//
//                for (EkvivalentiRazmena er : razmena.getListaEkvivalenata()) {
//                    System.out.println(er.getRb() + " " + er.getEkvivalenti().getId());
//                    uspeh = DBBroker.getInstance().update(er);
//                    if (!uspeh) {
//                        System.err.println("Update nije uspeo za EkvivalentiRazmena: RB = " + er.getRb());
//                        DBBroker.getInstance().insert(er);
//                    }
//                }
//
//                for (int i = razmena.getListaEkvivalenata().size()-1; i < listaubazi.size()-1; i++) {
//                    uspeh = DBBroker.getInstance().delete(razmena.getListaEkvivalenata().get(i));
//                }
//            }
//            uspeh = DBBroker.getInstance().update(razmena);
//            if (!uspeh) {
//                System.err.println("Update nije uspeo za Razmena: ID = " + razmena.getId());
//            }
//        } catch (SQLException e) {
//            System.err.println("SQL Exception: " + e.getMessage());
//            throw e;
//        } catch (Exception e) {
//            System.err.println("General Exception: " + e.getMessage());
//            throw e;
//        }
//    }

}
