package sg.edu.ntu.cart_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.cart_api.entity.Product;
import sg.edu.ntu.cart_api.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(){
        return "GET /products is being called";
    }
    
    // @RequestMapping(value="/{id}", method = RequestMethod.GET)
    // public String findById(@PathVariable int id){
    //     return "GET /products/"+id+" is being called";
    // }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable int id) {
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


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Product create(@RequestBody Product product){
        return product;
    }

    // Update an entity
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Product update(@RequestBody Product product, @PathVariable int id){
        product.setId(id);
        return product;
    }
    

    // Delete an entity
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        System.out.println("DELETE /products/"+id+" is being called");        
    }
  
}
/*
*./mvnw spring-boot:run
 */ 