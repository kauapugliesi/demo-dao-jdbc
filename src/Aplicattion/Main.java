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

        System.out.println("\n=== TEST 3: Seller find All ===");
        List<Seller> listAll = sellerdao.findAll();
        for (Seller obj : listAll){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: Seller Insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com",new Date(), 4000.0, dep);
        sellerdao.insert(newSeller);
        System.out.println("Inserted ! new id = " + newSeller.getId());

        System.out.println("\n=== TEST 5: Seller Update ===");
        seller = sellerdao.findById(1);
        seller.setName("Martha Waine");
        sellerdao.update(seller);
        System.out.println("Update completed");
    }
}