package com.intec.brussel.blogsite.model;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "author")
@Data


public class Author {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Mail", nullable = false)
    private String email;


    @Column(name = "first_name", nullable = false)
    private String fistName;


    @Column(name = "last_name", nullable = false)
    private String lastName;


    @Column(name = "password", nullable = false)
    private String password;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id.equals(author.id) && email.equals(author.email) && fistName.equals(author.fistName) && lastName.equals(author.lastName) && password.equals(author.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, fistName, lastName, password);
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}