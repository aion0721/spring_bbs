package com.example.springbbs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.springbbs.Service.ItemService;
import com.example.springbbs.Domain.Item;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainRestController {

    @Autowired
    private ItemService itemService;

    @GetMapping("list")
    public List<Item> list(@ModelAttribute Item item) {
        return itemService.findAll();
    }

    @GetMapping("{parentsId}")
    public List<Item> findByParentsId(@PathVariable("parentsId") Long parentsId) {
        return itemService.findByParentsId(parentsId);
    }

    @PostMapping("add")
    public Item create(@RequestBody Item item) {
        itemService.save(item);
        return item;

    }

}