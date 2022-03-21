package org.kalike.springboot.user.entities;

import javax.persistence.*;

@Entity
@Table//(name="USER")
public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue
    private long id;
    @Column(name="USER_NAME", length = 50, nullable = false, unique = true)
    private String username;
    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstname;
    @Column(name="LAST_NAME", length = 50, nullable = false)
    private String lastName;
    @Column(name="ROLE", length = 50, nullable = false)
    private String role;
    @Column(name = "SSM", length = 12, nullable = false)
    private String ssn;

    public User() {
    }

    public User(long id, String username, String firstname, String lastName, String role, String ssn) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastName = lastName;
        this.role = role;
        this.ssn = ssn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
