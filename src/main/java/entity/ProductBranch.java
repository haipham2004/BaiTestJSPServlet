package entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "PRODUCT_BRANCH")
@Embeddable
public class ProductBranch implements Serializable {
    @Id
    @Column(name = "IDProduct")
    private  int IDProduct;
    @Id
    @Column(name = "IDBranch")
   private int IDBranch;
}

