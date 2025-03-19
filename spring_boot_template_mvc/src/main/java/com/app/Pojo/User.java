//package com.app.Pojo;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;
//import lombok.Data;
//
//@Data
//@Entity
//public class User {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//
//	private String firstName;
//
//	private String lastName;
//
//	private String emailId;
//
//	@JsonIgnore
//	private String password;
//
//	private String phoneNo;
//
//	private String role;
//
//	@OneToOne
//	@JoinColumn(name = "address_id")
//	private Address address;
//
//	private String status;
//	
//
//}



package com.app.Pojo;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneNo;
	@JsonIgnore
	private String password;
    private String role;
    private String status;
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
//    @ManyToMany
//    @JoinTable(
//        name = "user_products",
//        joinColumns = @JoinColumn(name = "user_id"),
//        inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
//    private List<Product> products;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_products",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
    
}

