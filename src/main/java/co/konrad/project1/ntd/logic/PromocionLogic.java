/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.logic;


import co.konrad.project1.ntd.entities.PromocionEntity;
import co.konrad.project1.ntd.persistence.PromocionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Dairo
 */
@Stateless
public class PromocionLogic {
    
        /*
    Inyección del persistence de la entidad
     */
    @Inject
    private PromocionPersistence promocionPersistence;
    
    
    /**
     * Obtener todos las promocion
     *
     * @return promocion
     */
    public List<PromocionEntity> getPromociones() {
        List<PromocionEntity> promocion = promocionPersistence.findAll();
        return promocion;
    }
    
    
    /**
     * Ontener un carrito a partir de su id
     *
     * @param id
     * @return promocion
     */
    public PromocionEntity getPromocion(Long id) {
        PromocionEntity promocion = promocionPersistence.find(id);
        if (promocion == null) {
            throw new IllegalArgumentException("El promocion solicitado no existe");
        }
        return promocion;
    }
    
    
    
    /**
     * Crear una nueva promocion
     *
     * @param entity
     * @return entity
     */
    public PromocionEntity createPromocion(PromocionEntity entity) {

        promocionPersistence.create(entity);
        return entity;
    }
    
    
    /**
     * Metodo para actualizar un objeto de la entidad promocion
     *
     * @param id
     * @param entity
     * @return promocion
     */
    public PromocionEntity updatePromocion(Long id, PromocionEntity entity) {
        PromocionEntity promocion = promocionPersistence.update(entity);
        return promocion;
    }
    
    
    /**
     * Metodo para eliminar un objeto de la entidad promocion
     *
     * @param id
     */
    public void deletePromocion(Long id) {
        promocionPersistence.delete(id);
    }
    
    
}
