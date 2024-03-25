package Aibles_Training.java.client1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {
    @Id
    private String id;
    private String name;
    private String email;
    private String address;
    private String gender;
    @PrePersist
    public void init() {
        this.id = Objects.isNull(this.id) ? UUID.randomUUID().toString() : this.id;
    }


}
