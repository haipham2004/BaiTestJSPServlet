package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "STATUSa")
public class Statusa implements Serializable {
    @Id
    @Column(name="IDStatus")
    int IDStatus;
    @Column(name="nameStatus")
    String nameStatus;
    public Statusa(int IDStatus) {
        this.IDStatus = IDStatus;
    }


}

