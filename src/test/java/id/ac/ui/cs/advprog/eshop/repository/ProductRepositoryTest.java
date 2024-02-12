package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp(){}

    @Test
    void testCreateAndFind(){
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(savedProduct.getProductId(), product.getProductId());
        assertEquals(savedProduct.getProductName(), product.getProductName());
        assertEquals(savedProduct.getProductQuantity(), product.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty(){
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct(){
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de45-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);
    }

    @Test
    public void testEditProduct() {
        Product originalProduct = new Product();
        originalProduct.setProductName("OriginalProduct");
        originalProduct.setProductQuantity(5);

        productRepository.create(originalProduct);

        Product updatedProduct = new Product();
        updatedProduct.setProductId(originalProduct.getProductId());
        updatedProduct.setProductName("UpdatedProduct");
        updatedProduct.setProductQuantity(15);

        Product editedProduct = productRepository.updateProduct(updatedProduct);

        assertNotNull(editedProduct);
        assertEquals("UpdatedProduct", editedProduct.getProductName());
        assertEquals(15, editedProduct.getProductQuantity());
    }

    @Test
    public void testEditNonExistingProduct() {
        Product newProduct = new Product();
        newProduct.setProductName("NewProduct");
        newProduct.setProductQuantity(10);
        Product createdProduct = productRepository.create(newProduct);

        // Attempt to edit a product that does not exist
        Product nonExistingProduct = new Product();
        nonExistingProduct.setProductName("NonExistingProduct");
        nonExistingProduct.setProductQuantity(10);
        Product editedProduct = productRepository.updateProduct(nonExistingProduct);

        // Assert that editing a non-existing product returns null
        assertNull(editedProduct);
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product();
        product.setProductName("ProductToDelete");
        product.setProductQuantity(8);

        productRepository.create(product);

        Product deletedProduct = productRepository.deleteProduct(product.getProductId());

        assertNotNull(deletedProduct);
        assertEquals("ProductToDelete", deletedProduct.getProductName());

        // Ensure the product is no longer in the repository
        Iterator<Product> iterator = productRepository.findAll();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testDeleteNonExistingProduct() {
        Product newProduct = new Product();
        newProduct.setProductName("NewProduct");
        newProduct.setProductQuantity(10);
        Product createdProduct = productRepository.create(newProduct);

        Product deletedProduct = productRepository.deleteProduct("NonExistingProductId");
        assertNull(deletedProduct);
    }

    @Test
    public void testDeleteMultipleProducts() {
        // Create two products
        Product product1 = new Product();
        product1.setProductName("Product1");
        product1.setProductQuantity(3);
        Product product2 = new Product();
        product2.setProductName("Product2");
        product2.setProductQuantity(7);

        productRepository.create(product1);
        productRepository.create(product2);

        // Delete the first product and assert the returned product matches the deleted one
        Product deletedProduct1 = productRepository.deleteProduct(product1.getProductId());
        assertNotNull(deletedProduct1);
        assertEquals("Product1", deletedProduct1.getProductName());

        // Delete the second product and assert the returned product matches the deleted one
        Product deletedProduct2 = productRepository.deleteProduct(product2.getProductId());
        assertNotNull(deletedProduct2);
        assertEquals("Product2", deletedProduct2.getProductName());

        // Ensure the repository is empty after deleting both products
        Iterator<Product> iterator = productRepository.findAll();
        assertFalse(iterator.hasNext());
    }

    @Test
    void testFindById() {
        // Create some products and add them to the repository
        Product product1 = new Product();
        product1.setProductId("1");
        product1.setProductName("Product 1");
        product1.setProductQuantity(10);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("2");
        product2.setProductName("Product 2");
        product2.setProductQuantity(20);
        productRepository.create(product2);

        // Test finding existing product by ID
        Product foundProduct = productRepository.findById("1");
        assertNotNull(foundProduct);
        assertEquals("Product 1", foundProduct.getProductName());
        assertEquals(10, foundProduct.getProductQuantity());

        // Test finding non-existing product by ID
        Product nonExistingProduct = productRepository.findById("3");
        assertNull(nonExistingProduct);
    }



}
