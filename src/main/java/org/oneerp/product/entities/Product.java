package org.oneerp.product.entities;

//import javax.persistence.*;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Product {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue
    private long id;
    @Column(name="name", length = 50, nullable = false, unique = true)
    private String name;
    private String measurement;
    //Unit<?> measurement;
    private float price;

    /* @Column(name = "desc", length = 50, nullable = false)
    private String desc;
    @Column(name="LAST_NAME", length = 50, nullable = false)
    private String lastName;
    @Column(name="ROLE", length = 50, nullable = false)
    private String role;
    @Column(name = "SSM", length = 12, nullable = false)
    private String ssn;
    */
}
