package br.com.leonardojorge98.ProjetoJAVA.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "CHAR(36)", unique = true, updatable = false, nullable = false)
    private String uuid = String.valueOf(UUID.fromString(UUID.randomUUID().toString()));

    @Column(columnDefinition = "VARCHAR(70)",unique = true,nullable = false)
    @Size(min=30, max=70)
    private String title;

    @Column(columnDefinition = "VARCHAR(100)",nullable = false)
    @Size(min=50, max=100)
    private String resume;

    @Column(columnDefinition = "LONGTEXT",nullable = false)
    @Size(min=200)
    private String text;

    @Column(columnDefinition = "VARCHAR(140)",nullable = false)
    private String slug;

    @Column(updatable = false)
    private Instant registeredAt = Instant.now();


    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    public Article(String title, String resume, String text, User user) {
        this.title = title;
        this.resume = resume;
        this.text = text;
        this.user = user;
        this.calculateSlug();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.calculateSlug();
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSlug() {
        return slug;
    }
    private void calculateSlug(){
        this.slug = title.toLowerCase().replace(' ', '-');
    }

    public Instant getRegisteredAt() {
        return registeredAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "id=" + id +
                ", uuid:'" + getUuid() + '\'' +
                ", title:'" + title + '\'' +
                ", resume:'" + resume + '\'' +
                ", text:'" + text + '\'' +
                ", slug:'" + slug + '\'' +
                ", registeredAt=" + registeredAt +
                ", uuid:" + getUuid() + '\'' +
                ", username:" + user.getUsername() +
                '}';
    }
}
