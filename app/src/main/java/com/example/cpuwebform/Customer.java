package com.example.cpuwebform;

/** Customer Class
 *
 */

public class Customer {
    String id;
    String customer_id;
    String customer_type;
    String customer_sub_type;
    String status;
    String num_locations;
    String company_name;
    String contact_name;
    String title;
    String role;
    String phone_number;
    String mobile_number;
    String email_address;
    String address_street;
    String address_city;
    String address_county;
    String address_postcode;
    String annual_revenue;


    public Customer(String id, String customer_id, String customer_type, String customer_sub_type,
                    String status, String num_locations, String company_name, String contact_name,
                    String title, String role, String phone_number, String mobile_number, String email_address,
                    String address_street, String address_postcode, String address_county, String address_city, String annual_revenue) {
        this.id = id;
        this.customer_id = customer_id;
        this.customer_type = customer_type;
        this.customer_sub_type = customer_sub_type;
        this.status = status;
        this.num_locations = num_locations;
        this.company_name = company_name;
        this.contact_name = contact_name;
        this.title = title;
        this.role = role;
        this.phone_number = phone_number;
        this.mobile_number = mobile_number;
        this.email_address = email_address;
        this.address_street = address_street;
        this.address_postcode = address_postcode;
        this.address_county = address_county;
        this.address_city = address_city;
        this.annual_revenue = annual_revenue;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", customer_type='" + customer_type + '\'' +
                ", customer_sub_type='" + customer_sub_type + '\'' +
                ", status='" + status + '\'' +
                ", num_locations='" + num_locations + '\'' +
                ", company_name='" + company_name + '\'' +
                ", contact_name='" + contact_name + '\'' +
                ", title='" + title + '\'' +
                ", role='" + role + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                ", email_address='" + email_address + '\'' +
                ", address_street='" + address_street + '\'' +
                ", address_postcode='" + address_postcode + '\'' +
                ", address_county='" + address_county + '\'' +
                ", address_city='" + address_city + '\'' +
                ", annual_revenue='" + annual_revenue + '\'' +
                '}';


    }
}
