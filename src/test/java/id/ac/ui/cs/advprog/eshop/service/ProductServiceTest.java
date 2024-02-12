package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl service;
    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        when(productRepository.create(product)).thenReturn(product);
        service.create(product);

        when(productRepository.findAll()).thenReturn(List.of(product).iterator());
        Iterator<Product> productIterator = service.findAll().iterator();

        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }


    @Test
    void testEditProduct(){
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        when(productRepository.create(product)).thenReturn(product);
        service.create(product);

        when(productRepository.updateProduct(product)).thenReturn(product);
        Product resultEdit = service.updateProduct(product);

        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", resultEdit.getProductId());
        assertEquals("Sampo Cap Bambang", resultEdit.getProductName());
        assertEquals(100, resultEdit.getProductQuantity());
    }

    @Test
    void testDeleteProduct(){
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        when(productRepository.create(product)).thenReturn(product);
        service.create(product);

        when(productRepository.deleteProduct("eb558e9f-1c39-460e-8860-71af6af63bd6")).thenReturn(product);
        Product resultDelete = service.deleteProduct("eb558e9f-1c39-460e-8860-71af6af63bd6");

        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", resultDelete.getProductId());
        assertEquals("Sampo Cap Bambang", resultDelete.getProductName());
        assertEquals(100, resultDelete.getProductQuantity());
    }

    @Test
    void testFindProductById() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        String productId ="eb558e9f-1c39-460e-8860-71af6af63bd6";
        when(productRepository.findById(productId)).thenReturn(product);

        Product foundProduct = service.findById(productId);

        assertEquals(product, foundProduct);
        verify(productRepository, times(1)).findById(productId);
    }



}