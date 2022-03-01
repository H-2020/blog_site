package com.intec.brussel.blogsite.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String slug;
    String title;
    String content;

   Date published;


    @ManyToOne
    @JoinColumn(name = "author_id")
    User author;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(getId(), post.getId()) && Objects.equals(getSlug(), post.getSlug());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSlug());
    }

    @Override
    public String toString() {
        return this.getSlug();
    }
}