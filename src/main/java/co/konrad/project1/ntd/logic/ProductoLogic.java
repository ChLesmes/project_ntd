/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.logic;


import co.konrad.project1.ntd.entities.ProductoEntity;
import co.konrad.project1.ntd.persistence.ProductoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * 
 * @author Dairo, Fabian, Cristian
 * 
 */
@Stateless
public class ProductoLogic {
    
    
        /*
    Inyección del persistence de la entidad
     */
    @Inject
    private ProductoPersistence productoEntityPersistence;
    
    
    /**
     * Obtener todos lo producto
     *
     * @return producto
     */
    public List<ProductoEntity> getProductos() {
        List<ProductoEntity> producto = productoEntityPersistence.findAll();
        return producto;
    }
    
    
    /**
     * Ontener un carrito a partir de su id
     *
     * @param id
     * @return producto
     */
    public ProductoEntity getProducto(Long id) {
        ProductoEntity producto = productoEntityPersistence.find(id);
        if (producto == null) {
            throw new IllegalArgumentException("El producto solicitado no existe");
        }
        return producto;
    }
    
    
    
    /**
     * Crear un nuevo producto
     *
     * @param entity
     * @return entity
     */
    public ProductoEntity createProducto(ProductoEntity entity) {

        productoEntityPersistence.create(entity);
        return entity;
    }
    
    
    /**
     * Metodo para actualizar un objeto de la entidad producto
     *
     * @param id
     * @param entity
     * @return producto
     */
    public ProductoEntity updateProducto(Long id, ProductoEntity entity) {
        ProductoEntity producto = productoEntityPersistence.update(entity);
        return producto;
    }
    
    
    /**
     * Metodo para eliminar un objeto de la entidad Producto
     *
     * @param id
     */
    public void deleteProducto(Long id) {
        productoEntityPersistence.delete(id);
    }
    
}
