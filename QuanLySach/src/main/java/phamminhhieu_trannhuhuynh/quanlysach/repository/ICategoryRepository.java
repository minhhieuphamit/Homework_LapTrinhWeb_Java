package phamminhhieu_trannhuhuynh.quanlysach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phamminhhieu_trannhuhuynh.quanlysach.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
