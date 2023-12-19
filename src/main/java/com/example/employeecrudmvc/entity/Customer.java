package com.example.employeecrudmvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "firstName cannot be empty!")
    @NotBlank(message = "firstName cannot be blank.")
    private String firstName;
    @NotEmpty(message = "lastName cannot be empty!")
    @NotBlank(message = "lastName cannot be blank.")
    private String lastName;
    @Email(message = "Invalid Email Format!")
    @NotEmpty(message = "email cannot be empty!")
    @NotBlank(message = "email cannot be blank.")
    private String email;
    @NotEmpty(message = "PhoneNumber cannot be empty!")
    @NotBlank(message = "PhoneNumber cannot be blank.")
    @Pattern(regexp = "[a-zA-Z0-9 ]*",message = "PhoneNumber cannot contain illegal characters.")
    private String phoneNumber;
    @Past(message = "Date of Birth must be past.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    public Customer(String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }
}
