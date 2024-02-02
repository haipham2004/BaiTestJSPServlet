package entity;

import jakarta.persistence.*;
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
@Table(name = "SubCategory")
public class SubCategory implements Serializable {
    @Id
    @Column(name = "IDSubCategory")
    int IDSubCategory;
    @Column(name = "codeSubCate")
    String codeSubCate;
    @Column(name = "nameSubCate")
    String nameSubCate;
    @ManyToOne
    @JoinColumn(name = "IDCategory")
    Category category;

    public SubCategory(int IDSubCategory) {
        this.IDSubCategory = IDSubCategory;
    }
}
