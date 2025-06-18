package Model.Dao;

import Model.Entities.Seller;

import java.util.List;

public interface SellerDao {
    void insert(Seller obj);
    void update(Seller obj);
    void DeleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();

}
