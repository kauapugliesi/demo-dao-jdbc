package Model.Dao;

import Model.Entities.Department;

import java.util.List;

public interface DepartmentDao {

    void insert(Department obj);
    void update(Department obj);
    void DeleteById(Integer id);
    Department findById(Integer id);
    List<Department> findAll();

}
