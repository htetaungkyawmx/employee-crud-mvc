package com.example.employeecrudmvc;

import com.example.employeecrudmvc.dao.CustomerDao;
import com.example.employeecrudmvc.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class EmployeeCrudMvcApplication {
    private final CustomerDao customerDao;
    @Bean @Profile("dev")
    public ApplicationRunner runner(){
        return r->{
            List.of(
                    new Customer("John","Doe","john@gmail.com","55-555-55", LocalDate.now()),
                    new Customer("John","William","william@gmail.com","55-555-56", LocalDate.now()),
                    new Customer("John","Update","john@gmail.com","55-555-57", LocalDate.now()),
                    new Customer("Charles","Dickens","dickens@gmail.com","55-555-58", LocalDate.now()),
                    new Customer("Thomas","Hardy","hardy@gmail.com","55-555-59", LocalDate.now())
            ).forEach(this.customerDao::save);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeCrudMvcApplication.class, args);
    }

}
