package theo.dev.manageMaster.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import theo.dev.manageMaster.entities.Product;
import theo.dev.manageMaster.entities.TenantsUser;
import theo.dev.manageMaster.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            return productRepository.save(updatedProduct);
        }
        return null; // Handle this with exceptions or error responses in the real app
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }


    public List<Product> findByOwnerId(Long ownerId) {
        return productRepository.findByOwnerId(ownerId);
    }
}

