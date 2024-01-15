package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(nullable=false)
    private String firstName;
    private String lastName;

    @NotEmpty
    @Column(nullable =false, unique = true )
    @Email(message = "{errors.invalid_email}")
    private String email;

    private String password;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name="user_role",
            joinColumns = {@JoinColumn(name="User_ID", referencedColumnName="ID")},
            inverseJoinColumns= {@JoinColumn(name="Role_ID", referencedColumnName="ID")}
    )
    private List<Role> roles;
    public User(User user) {
        this.firstName=user.getFirstName();
        this.lastName=user.getLastName();
        this.email=user.getEmail();
        this.password=user.getPassword();
        this.roles=user.getRoles();
    }
    public User() {

    }
}

