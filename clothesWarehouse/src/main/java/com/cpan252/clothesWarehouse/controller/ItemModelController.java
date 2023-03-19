package com.cpan252.clothesWarehouse.controller;

import com.cpan252.clothesWarehouse.Data.ItemRepository;
import com.cpan252.clothesWarehouse.model.Brand;
import com.cpan252.clothesWarehouse.model.ItemModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


//This class is a controller that handles the creation of new items in the clothes warehouse application.
// It maps HTTP requests to methods that add brands to the model, initialize a new ItemModel object, and process a submitted ItemModel object.
// It also uses the ItemRepository to save the new ItemModel to the database.
@Controller
@Slf4j
@RequestMapping("/addItem")
public class ItemModelController {
    @Autowired
    private ItemRepository itemRepo;

    @Autowired
    public ItemModelController(ItemRepository itemRepo) {
        this.itemRepo = itemRepo;
    }

    @ModelAttribute
    public void addBrands(Model model) {
        var brands = List.of(Brand.values()).stream().map(Brand::name).collect(Collectors.toList());
        model.addAttribute("brands", brands);
        log.info("Added Item to model");
    }

    @ModelAttribute(name = "itemModel")
    public ItemModel itemModel() {
        return new ItemModel();
    }


    @PostMapping
    public String processDesign(@ModelAttribute @Valid ItemModel itemModel, BindingResult result) {
        if (result.hasErrors()) {
            return "addItem";
        }
        log.info("Processing addItem: " + itemModel);
        itemRepo.save(itemModel);
        return "redirect:/listItems";
    }

    @GetMapping
    public String showDesign() {
        return "addItem";

    }
}












