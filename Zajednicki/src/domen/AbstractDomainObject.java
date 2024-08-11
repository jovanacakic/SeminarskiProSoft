/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jovana
 */
public abstract class AbstractDomainObject implements Serializable {

    public abstract String getTableName();

//    public abstract String getColumnsForInsert();
//
//    public abstract String getParamsForInsert();
//
//    public abstract void setParamsForInsert(PreparedStatement statement, AbstractDomainObject domainObject) throws SQLException;
//
//    public abstract String getColumnsForUpdate();
//
//    public abstract String getParamsForUpdate();
//
//    public abstract void setParamsForUpdate(PreparedStatement statement, AbstractDomainObject domainObject) throws SQLException;
//
//    public abstract Long getPrimaryKeyValue();
//
//    public abstract String alias();
//
//    public abstract String join();
//
//    public abstract List<AbstractDomainObject> getList(ResultSet rs);
//
//    public abstract String getPrimaryKey();
//
//    public abstract void setAutoIncrementPrimaryKey(long generatedKey);
//
//    public abstract String conditon();
//
//    public abstract Long setCondition();

    ///////////////////////
    //public abstract String getNazivTabele();

    public abstract String getParametre();

    public abstract String getNaziveParametara();

    public abstract String getNazivPrimarnogKljuca();

    public abstract Integer getVrednostPrimarnogKljuca();

    public abstract String getSlozeniPrimarniKljuc();

    public abstract List<AbstractDomainObject> konvertujRSUListu(ResultSet rs);

    public abstract String getSelectUpit();

    public abstract String getSelectUpitPoParametru();

    public abstract String getInsertUpit();

    public abstract String getUpdateUpit();

    public abstract String getUpdateParametre();

    public abstract String getDeleteUpit();
}
