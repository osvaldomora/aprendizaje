package osvaldo.morales.company.demo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import osvaldo.morales.company.demo.api.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
