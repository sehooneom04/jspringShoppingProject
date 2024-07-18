package com.example.springstudyprojects.item.service;

import com.example.springstudyprojects.item.model.dto.CreateItemRequest;
import com.example.springstudyprojects.item.model.dto.UpdateItemRequest;
import com.example.springstudyprojects.item.model.entity.Item;
import com.example.springstudyprojects.item.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Item createItem(CreateItemRequest itemRequest) {
        Item item = Item.builder().
                price(itemRequest.getPrice()).
                name(itemRequest.getName()).
                category(itemRequest.getCategory()).build();
        itemRepository.save(item);
        return item;
    }
    @Transactional
    public Item updateItem(Long id, UpdateItemRequest updateItemRequest) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        Item newItem = Item.builder().
                id(item.getId()).
                price(updateItemRequest.getPrice()).
                name(updateItemRequest.getName()).
                category(updateItemRequest.getCategory()).build();
        itemRepository.save(newItem);
        return item;
    }

    public List<Item> findItemsOver10000(){
        List<Item> itemsOver10000 = itemRepository.findAll();
        for(Item i:itemsOver10000){
            if(i.getPrice() <= 10000){
                itemsOver10000.remove(i);
            }
        }
        return itemsOver10000;
    }

    public void deleteItem(Long id) {
        itemRepository.delete(itemRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 상품이 존재하지 않습니다")));
    }

    public Item findItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        return item;
    }
}
