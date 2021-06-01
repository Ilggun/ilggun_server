package com.ilggun.backend.product.domain;

import com.ilggun.backend.config.BaseTimeEntity;
import com.ilggun.backend.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Product extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 제품의 소유자
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;
    private String certification;

    @Builder
    public Product(String name, String certification, User user) {
        this.name = name;
        this.certification = certification;
        this.user = user;
    }
}
