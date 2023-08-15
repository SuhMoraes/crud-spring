package com.suhmoraes.javaspringexpert.services;

import com.suhmoraes.javaspringexpert.dto.ProductDTO;
import com.suhmoraes.javaspringexpert.entities.Product;
import com.suhmoraes.javaspringexpert.repository.ProductRepository;
import com.suhmoraes.javaspringexpert.services.exception.DatabaseException;
import com.suhmoraes.javaspringexpert.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    public ProductRepository repository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(PageRequest pageRequest){
        Page<Product> list = repository.findAll(pageRequest);
       return list.map(ProductDTO::new);
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Product Not Found."));
        return new ProductDTO(entity, entity.getCategories());
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        copyEntityToDto(entity, dto);
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(Long id ,ProductDTO dto) {
        try {
            Product entity = repository.getReferenceById(id);
            copyEntityToDto(entity, dto);
            entity.setName(dto.getName());
            entity = repository.save(entity);
            return new ProductDTO(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("ID not Found " + id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyEntityToDto(Product entity, ProductDTO dto) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setDescription(dto.getDescription());
        entity.setImgUrl(dto.getImgUrl());
    }


}