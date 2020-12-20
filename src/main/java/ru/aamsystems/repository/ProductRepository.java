package ru.aamsystems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.aamsystems.model.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.name = :name")
    Optional<Product> findByName(@Param("name") String name);

    @Modifying
    @Query("update Product p set p.name = :name, p.info = :info where p.id = :id")
    void updateById(@Param("name") String name, @Param("info") String info, @Param("id") long id);
}
