/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

/**
 *
 * @author ALaa
 */
@Named("custBean")
@SessionScoped
public class CustomerBean implements Serializable {

    private DataModel<Customer> customers;
    private CustomerDao custDao;
//     @Inject
    private Customer customer ;
    
     public CustomerBean(){
        customer = new Customer();
        custDao = new CustomerDao();
        customers = new ListDataModel<>();
        customers.setWrappedData(custDao.getAllCustomer());
    }

    public DataModel<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(DataModel<Customer> customers) {
        this.customers = customers;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addCustomer() {
        System.out.println("ay 7aga");

        int rowsInserted = custDao.addCustomer(customer);

        if (rowsInserted > 0) {
            System.out.println("A new customer was inserted successfully!");
             customers.setWrappedData(custDao.getAllCustomer());
        }
    }

    public void updateCustomer() {
        Customer customer = customers.getRowData();
        System.out.println("# " + customer);
        int rowsUpdated = custDao.updateCustomer(customer);

        if (rowsUpdated > 0) {
            System.out.println("A customer was updated successfully!");
             customers.setWrappedData(custDao.getAllCustomer());
        }

    }

    public void deleteCustomer() {
        int rowsDeleted = custDao.deleteCustomer(customers.getRowData().getId());

        if (rowsDeleted > 0) {
            System.out.println("A customer was Deleted successfully!");
            customers.setWrappedData(custDao.getAllCustomer());
        }

    }
}
