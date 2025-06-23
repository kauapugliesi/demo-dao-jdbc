package Model.Dao.impl;

import DB.DbException;
import DB.db;
import Model.Dao.DepartmentDao;
import Model.Entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn){
        this.conn =  conn;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException{
        Department dep = new Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));
        return dep;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("insert into department(name) values (?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getName());

            int rowsAffected = st.executeUpdate();

            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
            }else {
                throw new DbException("Unexpected error! No rows affected!");
            }


        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            db.closeStatment(st);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "UPDATE department " +
                            "SET Name = ? " +
                            "WHERE Id = ?");

            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());

            st.executeUpdate();

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            db.closeStatment(st);
        }
    }

    @Override
    public void DeleteById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("Delete from department where id = ?");
            st.setInt(1,id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            db.closeStatment(st);
            db.closeResultSet(rs);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
           st = conn.prepareStatement("Select * from department where id = ?");
           st.setInt(1,id);
           rs = st.executeQuery();
           if(rs.next()){
               Department obj = new Department();
               obj.setId(rs.getInt("Id"));
               obj.setName(rs.getString("Name"));
               return obj;
           }

            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            db.closeStatment(st);
            db.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("select * from department");
            rs = st.executeQuery();

            List<Department> list = new ArrayList<>();

            while(rs.next()){
                Department obj = new Department();
                obj.setId(rs.getInt("Id"));
                obj.setName(rs.getString("Name"));
                list.add(obj);
            }
            return list;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            db.closeStatment(st);
            db.closeResultSet(rs);
        }
    }
}
