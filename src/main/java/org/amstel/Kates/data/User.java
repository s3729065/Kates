package org.amstel.Kates.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.StringUtils;

@AllArgsConstructor @NoArgsConstructor @Builder @Data @Entity(name = "userEntity")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NotNull @Size(min = 2, max = 16, message = "firstName.size") @Column(name = "firstName", nullable = false)
    private String firstName;

    @NotNull @Size(min = 2, max = 16, message = "lastName.size") @Column(name = "lastName", nullable = false)
    private String lastName;

    @NotNull @Size(min = 2, max = 16, message = "username.size")
    private String username;

    @NotNull @Size(min = 8, max = 16, message = "password.size")
    private String password;

    @NotNull @Email
    private String emailAddress;

    public User(String firstName, String lastName, String username, String password, String emailAddress) {
        this.id = null; this.firstName = firstName; this.lastName = lastName; this.password = password; this.emailAddress = emailAddress;
    }
}
