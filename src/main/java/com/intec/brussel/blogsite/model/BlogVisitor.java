package com.intec.brussel.blogsite.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Data
@Entity
@Table(name = "visitors")
public class BlogVisitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
     Long id;

    @Column(name = "email")
     String email;

    @Column(name = "user_name")
     String username;

    @OneToOne
    @JoinColumn (name = "visitor_rating")
    Rating rating;


}
