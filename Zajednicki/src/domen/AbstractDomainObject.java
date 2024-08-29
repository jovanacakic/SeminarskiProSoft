/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jovana
 */
public abstract class AbstractDomainObject implements Serializable {

    public abstract String getTableName();

    public abstract String getAlias();

    public abstract String getJoin();

    public abstract ArrayList<AbstractDomainObject> getListuSvih(ResultSet rs) throws SQLException;

    public abstract String getKoloneZaInsert();

    public abstract String getVrednostZaPrimarniKljuc();

    public abstract String getVrednostiZaInsert();

    public abstract String getVrednostiZaUpdate();

    public abstract String getUslov();
}
