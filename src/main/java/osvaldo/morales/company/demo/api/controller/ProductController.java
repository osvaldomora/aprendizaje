package osvaldo.morales.company.demo.api.controller;

import org.springframework.web.bind.annotation.*;
import osvaldo.morales.company.demo.api.ProductService;
    import osvaldo.morales.company.demo.api.entities.Product;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController (ProductService productService){
        this.productService= productService;
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        System.out.println("testing"+product);
//Product.builder().name(product.getName()).build()
        return productService.save(product);
    }

    // Obtener todos
    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.findById(id);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
