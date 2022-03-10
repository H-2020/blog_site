package com.intec.brussel.blogsite.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Objects;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Email
    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "user_name", nullable = false)
    String userName;


    @Column(name = "password", nullable = false)
    String password;

    @Transient
     String passwordConfirm;

    @Enumerated(value=EnumType.STRING)
    Role role;

    boolean authenticated;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User author = (User) o;
        return Objects.equals(getId(), author.getId()) && Objects.equals(getEmail(), author.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail());
    }

    @Override
    public String toString() {
        return this.getEmail();
    }
}