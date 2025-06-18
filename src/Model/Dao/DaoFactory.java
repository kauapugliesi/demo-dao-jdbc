package Model.Dao;


import Model.Dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao(){ //metodo retorna um tipo da interface
        return new SellerDaoJDBC();//internamente instância uma implementação
    }


}
