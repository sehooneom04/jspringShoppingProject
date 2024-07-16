package com.example.springstudyprojects.item.controller;

import com.example.springstudyprojects.item.model.dto.CreateItemRequest;
import com.example.springstudyprojects.item.model.dto.UpdateItemRequest;
import com.example.springstudyprojects.item.model.entity.Item;
import com.example.springstudyprojects.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    @PostMapping
    public String createItem(@RequestBody CreateItemRequest itemRequest){
        Item item = itemService.createItem(itemRequest);
        return item.getName();
    }
    @GetMapping
    public List<String> getItems(){
        List<Item> items = itemService.getItems();
        return items.stream().map(item -> item.getName()).collect(Collectors.toList());
    }
    @PatchMapping("/{id}")
    public String updateItem(@PathVariable(name = "id") Long id, @RequestBody UpdateItemRequest updateItemRequest){
        Item item = itemService.updateItem(id, updateItemRequest);
        return item.getName();
    }
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable(name = "id") Long id){
        itemService.deleteItem(id);
    }
}
