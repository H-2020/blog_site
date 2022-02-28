package com.intec.brussel.blogsite.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "post")


public class Post {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "post_subject")
    private String postSubject;

    @Column(name = "post_number")
    private String postNumber;


    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    private Date date;
    private String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id.equals(post.id) && postSubject.equals(post.postSubject) && postNumber.equals(post.postNumber) && author.equals(post.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postSubject, postNumber, author);
    }


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postSubject='" + postSubject + '\'' +
                ", postNumber='" + postNumber + '\'' +
                ", author=" + author +
                '}';
    }
}