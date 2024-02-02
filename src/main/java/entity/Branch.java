package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "BRANCH")
public class Branch {
    @Id
    @Column(name = "IDBranch")
    int IDBranch;
    @Column(name = "nameBranch")
    String nameBranch;
}
