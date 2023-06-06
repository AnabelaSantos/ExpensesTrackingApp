package com.ExpensesTrackingApp.Repository;

import com.ExpensesTrackingApp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("select b from Category b where b.description = :description")
    Optional<Category> findByDescription(@Param("description") String description);

}
