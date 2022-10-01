/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.Account;
import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author leducphi
 */
public class AccountDAO extends DBContext {

    public Account getAccount(String email, String pass) {
        Account account = null;
        try {
            String sql = "select * from Accounts where Email=? and Password=?";
            //Step2: create obj PrepareStatement
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            //Step 3: thuc thti truy van
            ResultSet rs = ps.executeQuery();
            //Step 4: xu ly kq tra  ve
            while (rs.next()) {
                //lay du lieu tu rs gan cho cac bien cuc bo
                int AccountID = rs.getInt("AccountID");
                String Email = rs.getString("Email");
                String Password = rs.getString("Password");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                int Role = rs.getInt("Role");
                account = new Account(AccountID, Email, Password, CustomerID, EmployeeID, Role);
            }
        } catch (SQLException e) {
        }

        return account;
    }
    public static void main(String[] args) {
        Account a = new AccountDAO().getAccount("cust1@gmail.com", "123");
        System.out.println(a);
    }
}
