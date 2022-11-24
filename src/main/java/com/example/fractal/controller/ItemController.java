package com.example.fractal.controller;

import com.example.fractal.persistence.entity.ItemEntity;
import com.example.fractal.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    // Obtener items u productos por orden o pedido
    @GetMapping("order/{orderId}")
    public ResponseEntity<List<ItemEntity>> getItemsByOrder(@PathVariable("orderId") Long orderId){
        List<ItemEntity> itemList = itemService.getItemsByOrder(orderId);
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    // Guardar un nuevo item o producto en una orden o pedido
    @PostMapping
    public ResponseEntity<ItemEntity> saveItem(@RequestBody ItemEntity itemToSave){
        ItemEntity item = this.itemService.saveItem(itemToSave);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    // Eliminar un item o producto de una orden o pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable("id") Long id){
        this.itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
