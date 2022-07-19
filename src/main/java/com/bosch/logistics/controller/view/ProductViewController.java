package com.bosch.logistics.controller.view;

import com.bosch.logistics.entity.Product;
import com.bosch.logistics.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductViewController {

    private ProductService productService;

    public ProductViewController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String productView(Model model){
        model.addAttribute("products", productService.getProducts());
        return "/product/product";
    }

    @GetMapping("/create-product")
    public String showCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "/product/create-product";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product) {
        productService.createProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(Model model, @PathVariable long id) {
        model.addAttribute("product", productService.getProduct(id));
        return "/product/edit-product";
    }

    @PostMapping("/update/{id}")
    public String updateProductForm(@PathVariable long id, Product product) {
        productService.updateProduct(product, id);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);

        return "redirect:/product";
    }
}
