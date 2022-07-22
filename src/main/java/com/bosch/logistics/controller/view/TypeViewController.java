package com.bosch.logistics.controller.view;

import com.bosch.logistics.entity.ProductType;
import com.bosch.logistics.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/type")
public class TypeViewController {

    private TypeService typeService;

    public TypeViewController(TypeService typeservice) {
        this.typeService = typeservice;
    }

    @GetMapping
    public String TypeView(Model model){
        model.addAttribute("types", typeService.getTypes());
        return "/type/type";
    }

    @GetMapping("/create-type")
    public String showCreateTypeForm(Model model) {
        model.addAttribute("productType", new ProductType());
        return "/type/create-type";
    }

    @PostMapping("/create")
    public String createType(@ModelAttribute ProductType type) {
        typeService.create(type);
        return "redirect:/type";
    }

    @GetMapping("/edit/{id}")
    public String showEditTypeForm(Model model, @PathVariable long id) {
        model.addAttribute("productType", typeService.getType(id));
        return "/type/edit-type";
    }

    @PostMapping("/update/{id}")
    public String updateTypeForm(@PathVariable long id, ProductType productType) {
        typeService.update(productType, id);
        return "redirect:/type";
    }

    @GetMapping("/delete/{id}")
    public String deleteType(@PathVariable long id) {
        typeService.delete(id);

        return "redirect:/type";
    }


}
