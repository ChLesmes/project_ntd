/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.logic;

import co.konrad.project1.ntd.entities.CarritoEntity;
import co.konrad.project1.ntd.persistence.CarritoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * 
 * @author Dairo, Fabian, Cristian
 * 
 */

@Stateless
public class CarritoLogic {
    
    
    /*
    Inyección del persistence de la entidad
     */
    @Inject
    private CarritoPersistence carritoPersistence;
    
    
    /**
     * Obtener todos lo carritos
     *
     * @return carritos
     */
    public List<CarritoEntity> getCarritos() {
        List<CarritoEntity> carritos = carritoPersistence.findAll();
        return carritos;
    }
    
    
    /**
     * Ontener un carrito a partir de su id
     *
     * @param id
     * @return carrito
     */
    public CarritoEntity getCarrito(Long id) {
        CarritoEntity carrito = carritoPersistence.find(id);
        if (carrito == null) {
            throw new IllegalArgumentException("El carrito solicitado no existe");
        }
        return carrito;
    }
    
    
    
    /**
     * Crear un nuevo carrito
     *
     * @param entity
     * @return entity
     */
    public CarritoEntity createCarrito(CarritoEntity entity) {

        carritoPersistence.create(entity);
        return entity;
    }
    
    
    /**
     * Metodo para actualizar un objeto de la entidad carrito
     *
     * @param id
     * @param entity
     * @return carrito
     */
    public CarritoEntity updateCarrito(Long id, CarritoEntity entity) {
        CarritoEntity carrito = carritoPersistence.update(entity);
        return carrito;
    }
    
    
    /**
     * Metodo para eliminar un objeto de la entidad carrito
     *
     * @param id
     */
    public void deleteCarrito(Long id) {
        carritoPersistence.delete(id);
    }
    
    
    
}
