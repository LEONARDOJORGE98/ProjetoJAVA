package br.com.leonardojorge98.ProjetoJAVA.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Users")
public class User implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Range(min = 0, max = 20)
    @Column(updatable = false, insertable = false)
    @Id
    private Long id;


    @Column(columnDefinition = "CHAR(36)", unique = true, updatable = false, nullable = false)
    private String uuid = String.valueOf(UUID.fromString(UUID.randomUUID().toString()));

    @Column(columnDefinition = "VARCHAR(150)", unique = true, nullable = false)
    @Size(min = 3, max = 150)
    private String username;

    @Column(columnDefinition = "CHAR(97)", nullable = false)
    @Size(min = 8, max = 97)
    private String password;

    @Column(updatable = false,nullable = false)
    private Instant registeredAt = Instant.now();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }
    public String getUuid() {
        return uuid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Instant getRegisteredAt() {
        return registeredAt;
    }


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", registeredAt=" + registeredAt +
                '}';
    }
}
