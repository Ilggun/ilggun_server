package com.ilggun.backend.data.domain;

import com.ilggun.backend.config.WriteTimeEntity;
import com.ilggun.backend.product.domain.Product;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Data extends WriteTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private double gas;
    private double humidity;
    private double smoke;
    private double temperature;

    @Builder
    public Data(Product product, double gas, double humidity, double smoke, double temperature) {
        this.product = product;
        this.gas = gas;
        this.humidity = humidity;
        this.smoke = smoke;
        this.temperature = temperature;
    }
}
