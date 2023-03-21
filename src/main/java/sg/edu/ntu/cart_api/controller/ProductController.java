package sg.edu.ntu.cart_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sg.edu.ntu.cart_api.entity.Product;
import sg.edu.ntu.cart_api.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger    (ProductController.class);

    @Autowired
    ProductService service;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Product findAll() {
        logger.info("GET /products is being called");
        Product product = new Product();
        product.setId(1);
        product.setName("Sample Product");
        product.setDescription("This is a sample product");
        product.setPrice(10.0f);
        return product;
    }


    // @RequestMapping(value="/{id}", method = RequestMethod.GET)
    // public String findById(@PathVariable int id){
    //     return "GET /products/"+id+" is being called";
    // }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable int id) {
        logger.info("GET /products/{} is being called", id);
        if (id == 1) {
            return "This is detail for ID: " + id + " Product Name: Apple";
        } else if (id == 2) {
            return "This is detail for ID: " + id + " Product Name: Banana";
        } else if (id == 3) {
            return "This is detail for ID: " + id + " Product Name: Carrot";
        } else {
            return "No product found";
        }
    }


//    @RequestMapping(method = RequestMethod.POST)
//    public @ResponseBody Product create(@RequestBody Product product){
//        logger.info("POST /products is being called");
//        return product;
//    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Product create(@RequestBody Product product){
        logger.info("POST /products is being called");

        // Create a new Product object with the data from the request body
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());

        // You can also persist the new product in a database using a ProductService or a DAO layer

        // Return the newly created Product object
        return newProduct;
    }


    // Update an entity
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Product update(@RequestBody Product product, @PathVariable int id){
        logger.info("PUT /products/{} is being called", id);
        product.setId(id);
        return product;
    }
    

    // Delete an entity
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        logger.info("DELETE /products/{} is being called", id);
        System.out.println("DELETE /products/"+id+" is being called");        
    }
  
}
//./mvnw spring-boot:run

