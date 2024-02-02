package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "CATEGORY")
public class Category {
    @Id
    @Column(name = "IDCategory")
    int IDCategory;
    @Column(name = "codeCate")
    String codeCate;
    @Column(name = "nameCate")
    String nameCate;
}
