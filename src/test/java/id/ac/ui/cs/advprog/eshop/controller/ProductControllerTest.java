package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @BeforeEach
    void setUp() {
    }

    @InjectMocks
    ProductController productController;

    @Mock
    ProductServiceImpl productService;

    @Test
    void testCreateProductPage() {
        Model model = mock(Model.class);
        String result = productController.createProductPage(model);
        assertEquals("CreateProduct", result);
    }

    @Test
    void testCreateProductPost() {
        Model model = mock(Model.class);
        Product product = new Product();
        String result = productController.createProductPost(product, model);
        assertEquals("redirect:list", result);
    }

    @Test
    void testProductListPage() {
        Model model = mock(Model.class);
        String result = productController.productListPage(model);
        assertEquals("ProductList", result);
    }

    @Test
    void testDeleteProductPage() {
        Model model = mock(Model.class);
        String result = productController.deleteProductPage(model, "a");
        assertEquals("redirect:../list", result);
    }

    @Test
    void testEditProductPage() {
        Model model = mock(Model.class);
        String result = productController.editProductPage(model, "a");
        assertEquals("EditProduct", result);
    }

    @Test
    void testEditProductPost() {
        Model model = mock(Model.class);
        Product product = new Product();
        String result = productController.editProductPost(product, model, "a");
        assertEquals("redirect:../list", result);
    }
}