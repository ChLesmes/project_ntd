/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.logic;


import co.konrad.project1.ntd.entities.MetodoPagoEntity;
import co.konrad.project1.ntd.persistence.MetodoPagoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Dairo
 */
@Stateless
public class MetodoPagoLogic {
    
    
        /*
    Inyección del persistence de la entidad
     */
    @Inject
    private MetodoPagoPersistence metodoPagoEntityPersistence;
    
    
    /**
     * Obtener todos lo carritos
     *
     * @return carritos
     */
    public List<MetodoPagoEntity> getMetodosPagos() {
        List<MetodoPagoEntity> metodoPago = metodoPagoEntityPersistence.findAll();
        return metodoPago;
    }
    
    
    /**
     * Ontener un metodoPago a partir de su id
     *
     * @param id
     * @return metodoPago
     */
    public MetodoPagoEntity getMetodoPago(Long id) {
        MetodoPagoEntity metodoPago = metodoPagoEntityPersistence.find(id);
        if (metodoPago == null) {
            throw new IllegalArgumentException("El metodoPago solicitado no existe");
        }
        return metodoPago;
    }
    
    
    
    /**
     * Crear un nuevo carrito
     *
     * @param entity
     * @return entity
     */
    public MetodoPagoEntity createMetodoPago(MetodoPagoEntity entity) {

        metodoPagoEntityPersistence.create(entity);
        return entity;
    }
    
    
    /**
     * Metodo para actualizar un objeto de la entidad metodoPago
     *
     * @param id
     * @param entity
     * @return metodoPago
     */
    public MetodoPagoEntity updateMetodoPago(Long id, MetodoPagoEntity entity) {
        MetodoPagoEntity metodoPago = metodoPagoEntityPersistence.update(entity);
        return metodoPago;
    }
    
    
    /**
     * Metodo para eliminar un objeto de la entidad metodoPago
     *
     * @param id
     */
    public void deleteMetodoPago(Long id) {
        metodoPagoEntityPersistence.delete(id);
    }
    
}
