package com.mcdonald.mcdonald.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcdonald.mcdonald.Models.ProductModel;
import com.mcdonald.mcdonald.Models.UserModel;
import com.mcdonald.mcdonald.Services.ProductService;
import com.mcdonald.mcdonald.Services.UserService;

@RestController
@RequestMapping("api/mcdonald")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;
    

    @PostMapping("user")
    public String addUser(@RequestHeader String userName, @RequestHeader String password) {
        UserModel user = new UserModel();
        user.setUserName(userName);
        user.setPassword(password);
        return userService.addUserService(user);
    }

    @GetMapping("login/{username}")
    public String login(@PathVariable("username") String userName, @RequestHeader String password) {
        UserModel user = new UserModel();
        user.setUserName(userName);
        user.setPassword(password);
        return userService.loginService(user);
    }

        @PutMapping("/updateuser")
	    public UserModel updateUser(@RequestBody UserModel user) {
	        return userService.updateUser(user);
	    }
        @DeleteMapping("/deleteuser/{userName}")
	    public String deletetUser(@PathVariable String  userName) {
	        return userService.deleteUser(userName);
	    }

        @PostMapping("/addproduct")
        public String addProduct(@RequestHeader String name, @RequestHeader double price) {
        ProductModel product = new ProductModel();
        product.setName(name);
        product.setPrice(price);
        return productService.addProduct(product);
    }
       @GetMapping("/menu")
       public List<ProductModel> viewMenu(){
        return productService.viewMenu();
       }
}

