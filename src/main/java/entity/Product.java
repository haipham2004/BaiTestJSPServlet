package entity;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "PRODUCT")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDProduct")
    private int IDProduct;
    @ManyToOne
    @JoinColumn(name = "IDSubCategory")
    private SubCategory subcategory;
    @Column(name = "nameProduct")
    private String nameProduct;
    @Column(name = "color")
    private String color;
    @Column(name = "quality")
    private int quality;
    @Column(name = "sellPrice")
    private int sellPrice;
    @Column(name = "originPrice")
    private int originPrice;
    @Column(name = "descriptions")
    private String descriptions;
    @ManyToOne
    @JoinColumn(name = "IDStatus")
    private Statusa statusa;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "ProductBranch",
//            joinColumns = @JoinColumn(name = "IDProduct"),
//            inverseJoinColumns = @JoinColumn(name = "IDBranch"))
//    private List<Branch> branch;


    public Product(int IDProduct, SubCategory subcategory, String nameProduct, String color, int quality, int sellPrice, int originPrice,Statusa statusa) {
        this.IDProduct=IDProduct;
        this.subcategory = subcategory;
        this.nameProduct = nameProduct;
        this.color = color;
        this.quality = quality;
        this.sellPrice = sellPrice;
        this.originPrice = originPrice;
        this.statusa=statusa;
    }
    public Product(SubCategory subcategory, String nameProduct, String color, int quality, int sellPrice, int originPrice,Statusa statusa) {
        this.subcategory = subcategory;
        this.nameProduct = nameProduct;
        this.color = color;
        this.quality = quality;
        this.sellPrice = sellPrice;
        this.originPrice = originPrice;
        this.statusa=statusa;
    }

}
