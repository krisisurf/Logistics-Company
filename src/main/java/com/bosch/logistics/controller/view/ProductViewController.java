package com.bosch.logistics.controller.view;

import com.bosch.logistics.entity.Customer;
import com.bosch.logistics.entity.Product;
import com.bosch.logistics.entity.User;
import com.bosch.logistics.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/product")
public class ProductViewController {

    private ProductService productService;
    private TypeService typeService;
    private StatusService statusService;
    private CustomerService customerService;
    private AddressService addressService;
    private DeliveryTimeService deliveryTimeService;

    public ProductViewController(ProductService productService, TypeService typeService, StatusService statusService, CustomerService customerService, AddressService addressService, DeliveryTimeService deliveryTimeService) {
        this.productService = productService;
        this.typeService = typeService;
        this.statusService = statusService;
        this.customerService = customerService;
        this.addressService = addressService;
        this.deliveryTimeService = deliveryTimeService;
    }

    @GetMapping
    public String productView(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        Customer customer = null;

        if(user.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("CUSTOMER")))
            customer = customerService.getCustomer(user.getId());

        Set<Product> products = (customer == null) ? new HashSet<>(productService.getProducts()) : customer.getAllProducts();

        model.addAttribute("products", products);
        return "/product/product";
    }

    @GetMapping("/find-by-registeredDate/{registeredDate}")
    public String productByRegisteredDateView(Model model, @PathVariable String registeredDate) {
        Set<Product> products = productService.findAllByRegisteredDateOrderByNameAsc(LocalDate.parse(registeredDate));
        model.addAttribute("products", products);
        return "/product/product";
    }
    @GetMapping("find-by-received-date-between/{startDate}/{endDate}")
    public String productsReceivedBetweenDates(Model model, LocalDate startDate, LocalDate endDate){
        Set<Product> products = productService.findAllByReceivedDateBetween(startDate,endDate);
        model.addAttribute("products",products);
        return "/product/product";
    }

    private void addProductAttributes(Model model, Product product) {
        model.addAttribute("product", product);
        model.addAttribute("productTypes", typeService.getTypes());
        model.addAttribute("statuses", statusService.getStatuses());
        model.addAttribute("customers", customerService.getCustomers());
        model.addAttribute("addresses", addressService.getAddresses());
        model.addAttribute("deliveryTimes", deliveryTimeService.getDeliveryTime());
    }

    @GetMapping("/create-product")
    public String showCreateProductForm(Model model) {
        addProductAttributes(model, new Product());
        return "/product/create-product";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product) {
        productService.createProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(Model model, @PathVariable long id) {
        addProductAttributes(model, productService.getProduct(id));
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
