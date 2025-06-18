package Model.Dao;


import DB.db;
import Model.Dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao(){ //metodo retorna um tipo da interface
        return new SellerDaoJDBC(db.getConn());//internamente instância uma implementação
    }


}
