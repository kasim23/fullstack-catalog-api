package models;

import java.sql.Connection;
import java.time.LocalDateTime;

public class Customer {
    private int customerId;
    private String fName;
    private String lName;
    private String email;
    private LocalDateTime createdAt;

    public Customer(int customerId, String fName, String lName,
                    String email, LocalDateTime createdAt) {
        this.customerId = customerId;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.createdAt = createdAt;
    }

    public Customer(String fName, String lName, String email) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
