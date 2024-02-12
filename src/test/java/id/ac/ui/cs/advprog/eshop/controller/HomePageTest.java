package id.ac.ui.cs.advprog.eshop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class HomePageTest {

    @Test
    void testCreateProductPage() {
        // Create an instance of the HomePage class
        HomePage homePage = new HomePage();

        // Create a mock Model object
        Model model = mock(Model.class);

        // Call the method under test
        String viewName = homePage.createProductPage(model);

        // Verify that the correct view name is returned
        assertEquals("homepage", viewName);
    }
}
