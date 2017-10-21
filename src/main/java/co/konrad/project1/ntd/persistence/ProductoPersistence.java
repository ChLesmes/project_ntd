/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.persistence;


import co.konrad.project1.ntd.entities.ProductoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Dairo
 */
@Stateless
public class ProductoPersistence {
    
    @PersistenceContext(unitName = "Project1-NTDPU")
    protected EntityManager em;
    
    /**
     * Método para encontrar un objeto de la clase producto a través de un id
     *
     * @param id
     * @return producto *
     */
    public ProductoEntity find(Long id) {
        ProductoEntity producto = em.find(ProductoEntity.class, id);
        return producto;
    }
    
    
    /**
     * Obtener todos los objetos encontrados en la tabla producto
     *
     * @return listado de datos de la tabla
     *
     */
    public List<ProductoEntity> findAll() {
        Query todos = em.createQuery("select u from ProductoEntity u");
        return todos.getResultList();
    }
    
    
    /**
     * Creación de un nuevo registro
     *
     * @param producto
     * @return producto
     *
     */
    public ProductoEntity create(ProductoEntity producto) {
        em.persist(producto);
        return producto;
    }
    
    /*Actualización de la entidad
        @param 
        @return merge entity*/
    public ProductoEntity update(ProductoEntity entity) {

        return em.merge(entity);
    }
    
    /**
     * Eliminar un objeto de la entidad
     *
     * @param id
     * @return productoUpdate*
     */
    public void delete(Long id) {
        ProductoEntity productoDelete = em.find(ProductoEntity.class, id);
        em.remove(productoDelete);
    }
    
}
