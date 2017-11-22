package mum.edu.controller;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
public class RestaurantControllerTest {
    @Mock
    private RestaurantService restaurantService;
    @Mock
    private Restaurant restaurant;
    
    @Before
    public void setupMock() {
    		restaurantService = new RestaurantService();
    		restaurant = mock(Restaurant.class);
    }
    
    @Test
    public void testMockCreation(){
        assertNotNull(restaurant);
        assertNotNull(restaurantService);
    }
    
    @Test
    public void testGetRestaurant() {
        when(restaurantService.findByUsername('restaurant@gmail.com')).thenReturn(1);
        assertEquals(1,restaurantService.findByUsername('restaurant@gmail.com'));
    }
}