package com.ilggun.backend.data.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
//    @Query(
////            value = "SELECT p FROM data p where p.product_id=:searchParam"
//            value = "SELECT u FROM data u where u.product_id = :searchParam",
//            countQuery = "SELECT count(*) FROM data",
//            nativeQuery = true
//    )
//    Page<Data> findByProductId(@Param("searchParam") Long product_id, Pageable pageable);

    Page<Data> findAllByProductId(Long productId, Pageable pageable);
    Page<Data> findByProductIdLike(Long productId, Pageable pageable);
    List<Data> findByProductId(Long productId);
}

