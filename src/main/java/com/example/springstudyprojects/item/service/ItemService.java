package com.example.springstudyprojects.item.service;

import com.example.springstudyprojects.item.model.dto.CreateItemRequest;
import com.example.springstudyprojects.item.model.dto.UpdateItemRequest;
import com.example.springstudyprojects.item.model.entity.Item;
import com.example.springstudyprojects.item.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        if(updateItemRequest.getName()!= null) item.setName(updateItemRequest.getName());
        if(updateItemRequest.getCategory()!= null) item.setCategory(updateItemRequest.getCategory());
        if(updateItemRequest.getPrice()!= null)item.setPrice(updateItemRequest.getPrice());
        itemRepository.save(item);
        return item;
    }


    public void deleteItem(Long id) {
        itemRepository.delete(itemRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 상품이 존재하지 않습니다")));
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }
}
