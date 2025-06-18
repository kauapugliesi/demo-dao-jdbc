package Aplicattion;

import DB.DbException;
import DB.db;
import Model.Entities.Department;
import Model.Entities.Seller;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        Department obj = new Department(1, "Books");
        Seller seller = new Seller(21, "bob", "bob@gmaik.com", new Date(), 3000.0, obj);
        System.out.println(seller);




    }
}