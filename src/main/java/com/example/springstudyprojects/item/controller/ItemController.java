package com.example.springstudyprojects.item.controller;

import com.example.springstudyprojects.item.model.dto.CreateItemRequest;
import com.example.springstudyprojects.item.model.dto.UpdateItemRequest;
import com.example.springstudyprojects.item.model.entity.Items;
import com.example.springstudyprojects.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Items")
@RequiredArgsConstructor
public class ItemController {
    private ItemService itemService;
    @PostMapping
    public String createItem(@RequestBody CreateItemRequest itemRequest){
        Items item = itemService.createItem(itemRequest);
        return item.getName();
    }
    @GetMapping
    public List<String> getItems(){
        List<Items> items = itemService.getItems();
        return items.stream().map(item -> item.getName()).collect(Collectors.toList());
    }
    @PatchMapping("/Items/{id}")
    public String updateItem(@RequestParam Long id, @RequestBody UpdateItemRequest updateItemRequest){
        Items item = itemService.updateItem(id, updateItemRequest);
        return item.getName();
    }
    @DeleteMapping
    public void deleteItem(@RequestParam Long id){
        itemService.deleteItem(id);
    }
}
