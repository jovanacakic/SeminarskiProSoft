/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.razmena;

import database.DBBroker;
import domen.AbstractDomainObject;
import domen.EkvivalentiRazmena;
import domen.Razmena;
import java.sql.SQLException;
import sistemska_operacija.OpstaSO;
import java.sql.*;
import java.util.List;

/**
 *
 * @author jovana
 */
public class SODodajRazmenu extends OpstaSO {

    private final Razmena razmena;
    private boolean uspeh = false;

    public SODodajRazmenu(AbstractDomainObject razmena) {
        this.razmena = (Razmena) razmena;
    }

    public boolean isUspeh() {
        return uspeh;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() throws SQLException {
        PreparedStatement ps = DBBroker.getInstance().insert(razmena);
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            razmena.setRazmenaID(id);
        }
        List<EkvivalentiRazmena> ekvivalentiRazmena = razmena.getListaEkvivalenata();
        ekvivalentiRazmena.stream().forEach((ekvivalenti) -> {
            ekvivalenti.setRazmena(razmena);
            try {
                DBBroker.getInstance().insert(ekvivalenti);

                uspeh = true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println("Greska u SODodajRazmenu");
                uspeh = false;
            }

        });

    }

}
