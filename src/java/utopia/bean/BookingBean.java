/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utopia.bean;

/**
 *
 * @author aafq7
 */
public class BookingBean {
    private String name;
    private String email;
    private String phone_no;
    private String cust_ic;
    private String type;
    private int num_ticket;
    private double price;

    public BookingBean() {
    }

    public BookingBean(String name, String email, String phone_no, String cust_ic, String type, int nt) {
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.cust_ic = cust_ic;
        this.type = type;
        this.num_ticket = nt;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getCust_ic() {
        return cust_ic;
    }

    public void setCust_ic(String cust_ic) {
        this.cust_ic = cust_ic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice(String t) {
        
        if(t.equalsIgnoreCase("child")) {
            this.price = 40;
        } else if(t.equalsIgnoreCase("student")) {
            this.price = 70;
        } else if(t.equalsIgnoreCase("adult")) {
            this.price = 90;
        } else if(t.equalsIgnoreCase("senior citizen")){
            this.price = 65;
        }
        
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum_ticket() {
        return num_ticket;
    }

    public void setNum_ticket(int num_ticket) {
        this.num_ticket = num_ticket;
    }
    
    public double getTotalPrice(String t, int num_ticket) {
        double countPrice = 0.0;
        
        if (t.equalsIgnoreCase("child")){
            countPrice = num_ticket * getPrice(t);
        } else if (t.equalsIgnoreCase("Student")) {
            countPrice = num_ticket * getPrice(t);
        } else if (t.equalsIgnoreCase("Adult")) {
            countPrice = num_ticket * getPrice(t);
        } else if (t.equalsIgnoreCase("Senior Citizen")) {
            countPrice = num_ticket * getPrice(t);
        }
        
        return countPrice;
    }
    
}
