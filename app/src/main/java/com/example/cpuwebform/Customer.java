package com.example.cpuwebform;

/**
 * Represents a customer entity with various attributes such as ID, name, contact information, etc.
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


    /**
     * Constructor to initialize a Customer object.
     *
     * @param id               The ID of the customer.
     * @param customer_id      The customer ID.
     * @param customer_type    The type of the customer.
     * @param customer_sub_type The sub type of the customer.
     * @param status           The status of the customer.
     * @param num_locations    The number of locations of the customer.
     * @param company_name     The company name of the customer.
     * @param contact_name     The contact name of the customer.
     * @param title            The title of the contact person.
     * @param role             The role of the contact person.
     * @param phone_number     The phone number of the contact person.
     * @param mobile_number    The mobile number of the contact person.
     * @param email_address    The email address of the contact person.
     * @param address_street   The street address of the customer.
     * @param address_postcode The postcode of the customer.
     * @param address_county   The county of the customer.
     * @param address_city     The city of the customer.
     * @param annual_revenue   The annual revenue of the customer.
     */
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

    /**
     * Get a string representation of the Customer object.
     *
     * @return A string representation of the Customer object.
     */
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
