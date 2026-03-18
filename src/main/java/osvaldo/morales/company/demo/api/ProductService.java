package osvaldo.morales.company.demo.api;

import org.springframework.stereotype.Service;
import osvaldo.morales.company.demo.api.entities.Product;
import osvaldo.morales.company.demo.api.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository productRepository){
        this.repository=productRepository;
    }

    public Product save(Product product){
        return repository.save(product);
    }

    // Obtener todos
    public List<Product> findAll() {
        return repository.findAll();
    }

    // Obtener por ID
    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Eliminar
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
