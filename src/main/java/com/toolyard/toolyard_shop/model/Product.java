package com.toolyard.toolyard_shop.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {
    private static final String SEQ_NAME = "products_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private long id;
    @Column(length = 500)
    private String title;
    private BigDecimal price;
    @Column(length = 1500)
    private String description;
    @Column(length = 1500)
    private String characteristics;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Review> reviews;

    @ElementCollection
    @CollectionTable(name = "product_documentation", joinColumns = @JoinColumn(name = "product_id"))
    private List<DocumentationMetadata> documentationMetadata;
    private int amount;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "products_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;
}
