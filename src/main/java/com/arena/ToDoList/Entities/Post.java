package com.arena.ToDoList.Entities;

import javax.persistence.*;

@Entity
@Table(name="Posts")
public class Post {
    private Long id;
    private String content;

    public Post() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
