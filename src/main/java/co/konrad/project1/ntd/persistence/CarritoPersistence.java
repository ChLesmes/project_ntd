/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.persistence;

import co.konrad.project1.ntd.entities.CarritoEntity;
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

public class CarritoPersistence {
    
    @PersistenceContext(unitName = "Project1-NTDPU")
    protected EntityManager em;
    
    /**
     * Método para encontrar un objeto de la clase Carrito a través de un id
     *
     * @param id
     * @return carrito *
     */
    public CarritoEntity find(Long id) {
        CarritoEntity carrito = em.find(CarritoEntity.class, id);
        return carrito;
    }
    
    
    /**
     * Obtener todos los objetos encontrados en la tabla Carrito
     *
     * @return listado de datos de la tabla
     *
     */
    public List<CarritoEntity> findAll() {
        Query todos = em.createQuery("select u from CarritoEntity u");
        return todos.getResultList();
    }
    
    
    /**
     * Creación de un nuevo registro
     *
     * @param carrito
     * @return carrito
     *
     */
    public CarritoEntity create(CarritoEntity carrito) {
        em.persist(carrito);
        return carrito;
    }
    
    /*Actualización de la entidad
        @param 
        @return merge entity*/
    public CarritoEntity update(CarritoEntity entity) {

        return em.merge(entity);
    }
    
    /**
     * Eliminar un objeto de la entidad
     *
     * @param id
     * @return carritoUpdate*
     */
    public void delete(Long id) {
        CarritoEntity carritoDelete = em.find(CarritoEntity.class, id);
        em.remove(carritoDelete);
    }
    
    
    
    
    
}
