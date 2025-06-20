package Aplicattion;

import DB.DbException;
import DB.db;
import Model.Dao.DaoFactory;
import Model.Dao.SellerDao;
import Model.Entities.Department;
import Model.Entities.Seller;

import java.util.Date;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("=== TEST 1: Seller find by id ===");
        SellerDao sellerdao = DaoFactory.createSellerDao();
        Seller seller = sellerdao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: Seller find by Department ===");
        Department dep = new Department(2, null);
        List<Seller> list = sellerdao.findByDepartment(dep);
        for (Seller s : list){
            System.out.println(s);
        }
    }
}