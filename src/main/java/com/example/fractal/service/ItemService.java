package com.example.fractal.service;

import com.example.fractal.exception.BaseException;
import com.example.fractal.persistence.entity.ItemEntity;
import com.example.fractal.persistence.repository.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    // Obtener los items de una orden o pedido
    public List<ItemEntity> getItemsByOrder(Long idOrder){
        return this.itemRepository.findItemEntityByOrder_Id(idOrder);
    }

    // Guardar un nuevo item a una orden o pedido
    public ItemEntity saveItem(ItemEntity itemToSave){
        return this.itemRepository.save(itemToSave);
    }

    // Eliminar un item de una orden o pedido
    public void deleteItem(Long id){
        Optional<ItemEntity> optItem = this.itemRepository.findById(id);
        if(!optItem.isPresent())
            throw new BaseException("No existe el item con el ID brindado", HttpStatus.NOT_FOUND);
        this.itemRepository.deleteById(id);
    }
}
