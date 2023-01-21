package it.academy.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "app_user")
@Getter
@Setter
public class AppUser {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;


    @Column(name = "USER_NAME")
    @NotEmpty(message = "User name should not be empty")
    @Size(min = 2, max = 15, message = "User name should be between 2 and 15 characters")
    private String username;

    @NotEmpty(message = "Password should not be empty")
    @Size(min = 4, max = 15, message = "Password should be between 2 and 15 characters")
    @Column(name = "USER_PASSWORD")
    private String password;

    @Column(name = "USER_ROLE")
    private String role;

    @Override
    public String toString() {
        return "AppUser{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
