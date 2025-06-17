package Aplicattion;

import DB.DbException;
import DB.db;
import Model.Entities.Department;

import java.sql.Connection;
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
        System.out.println(obj);


    }
}