package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.Random;

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
    void verifyCreateAndDeleteWorkflow() {
        Iterator<Product> iterator = productRepository.findAll();

        Product newProduct = new Product();
        productRepository.create(newProduct);

        newProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        newProduct.setProductName("Sampo Cap Bambang");
        newProduct.setProductQuantity(100);

        assertTrue(iterator.hasNext());
        productRepository.delete("eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertFalse(iterator.hasNext());
    }

    @Test
    void verifyCreateAndModifyWorkflow() {
        Random randomizer = new Random();
        int randomNumber = randomizer.nextInt(1000);

        Iterator<Product> iterator = productRepository.findAll();

        Product initialProduct = new Product();
        productRepository.create(initialProduct);
        initialProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        initialProduct.setProductName("Sampo Cap Bambang");
        initialProduct.setProductQuantity(100);

        Product modifiedProduct = new Product();
        modifiedProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        modifiedProduct.setProductName("pppp");
        modifiedProduct.setProductQuantity(randomNumber);

        productRepository.edit(modifiedProduct);

        assertEquals(randomNumber, initialProduct.getProductQuantity());
        assertEquals("pppp", initialProduct.getProductName());
    }

    @Test
    void verifyCreateModifyAndDeleteWorkflow() {
        Random randomizer = new Random();
        int randomNumber = randomizer.nextInt(1000);

        Iterator<Product> iterator = productRepository.findAll();

        Product initialProduct = new Product();
        productRepository.create(initialProduct);
        initialProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        initialProduct.setProductName("Sampo Cap Bambang");
        initialProduct.setProductQuantity(100);

        Product modifiedProduct = new Product();
        modifiedProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        modifiedProduct.setProductName("pppp");
        modifiedProduct.setProductQuantity(randomNumber);

        productRepository.edit(modifiedProduct);

        assertEquals(randomNumber, initialProduct.getProductQuantity());
        assertEquals("pppp", initialProduct.getProductName());

        productRepository.delete("eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertFalse(iterator.hasNext());
    }

    @Test
    void verifyEditIfNotFound() {
        Random randomizer = new Random();
        int randomNumber = randomizer.nextInt(1000);

        Product existingProduct = new Product();
        productRepository.create(existingProduct);
        existingProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        existingProduct.setProductName("Sampo Cap Bambang");
        existingProduct.setProductQuantity(100);

        Product modifiedProduct = new Product();
        modifiedProduct.setProductId("");
        modifiedProduct.setProductName("Lalalalala");
        modifiedProduct.setProductQuantity(randomNumber);

        productRepository.edit(modifiedProduct);

        assertNotEquals(randomNumber, existingProduct.getProductQuantity());
        assertNotEquals("Lalalalala", existingProduct.getProductName());
    }

    @Test
    void verifyDeleteIfNotFound() {
        Iterator<Product> iterator = productRepository.findAll();

        Product existingProduct = new Product();
        productRepository.create(existingProduct);
        existingProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        existingProduct.setProductName("Sampo Cap Bambang");
        existingProduct.setProductQuantity(100);

        productRepository.delete("-");
        assertTrue(iterator.hasNext());
    }


}