package edu.sharif.web.customer;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity(name = "Customer")
@Table(name = "customer")
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sq",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Long id;

    @Column(
        name = "name",
        columnDefinition = "TEXT",
        nullable = false
    )
    private String name;

    @Column(
        name = "email",
        columnDefinition = "TEXT",
        nullable = false,
        unique = true
    )
    private String email;
    
    private LocalDate dob;

    @Transient
    private Integer age;

    public Customer() {
    }

    public Customer(String name, String email, LocalDate dob) {
        this.dob = dob;
        this.email = email;
        this.name = name;
    }

//    public Customer(Long id, String name, String email, LocalDate dob, Integer age) {
//        this.name = name;
//        this.email = email;
//        this.dob = dob;
//        this.age = age;
//        this.id = id;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {

        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
