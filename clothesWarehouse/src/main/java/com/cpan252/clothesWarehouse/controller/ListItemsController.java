package com.cpan252.clothesWarehouse.controller;

import com.cpan252.clothesWarehouse.Data.ItemRepository;
import com.cpan252.clothesWarehouse.model.ItemModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@Slf4j

//This class is a controller that handles HTTP requests related to displaying a paginated list of items.
// It uses an ItemRepository to fetch the items from a database and then renders the items in a Thymeleaf template.
// It also supports pagination and searching for items based on a search term.

public class ListItemsController {



        @Autowired
        private ItemRepository itemRepository;

    public ListItemsController(ItemRepository itemRepository) {
        this.itemRepository= itemRepository;
    }
    @GetMapping("/listItems")
    @ModelAttribute
    public String getItemModels(
            @RequestParam(name = "searchTerm", required = false) String searchTerm,
            @PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable,
            Model model) {
        Page<ItemModel> page;
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            page = itemRepository.findAll(pageable);
        } else {
            page = itemRepository.findByNameContainingIgnoreCase(searchTerm, pageable);
        }

        model.addAttribute("itemModels", page);
        model.addAttribute("currentPage", page.getNumber());
        model.addAttribute("totalPages", page.getTotalPages());
        return "listItems";
    }
    @GetMapping("/listItems/switchPage")
    public String switchPage(@RequestParam("pageToSwitch") int pageToSwitch, Model model) {
        // your logic to switch page
        return "redirect:/listItems?page=" + pageToSwitch;
    }


    @GetMapping
        public String showDesign() {
            return "listItems";
        }
    }


















