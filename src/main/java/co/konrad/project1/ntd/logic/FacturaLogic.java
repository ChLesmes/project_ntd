/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.logic;


import co.konrad.project1.ntd.entities.FacturaEntity;
import co.konrad.project1.ntd.persistence.FacturaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * 
 * @author Dairo, Fabian, Cristian
 * 
 */
@Stateless
public class FacturaLogic {
    
    
        /*
    Inyección del persistence de la entidad
     */
    @Inject
    private FacturaPersistence facturaPersistence;
    
    
    /**
     * Obtener todas las facturas
     *
     * @return facturas
     */
    public List<FacturaEntity> getFacturas() {
        List<FacturaEntity> facturas = facturaPersistence.findAll();
        return facturas;
    }
    
    
    /**
     * Ontener una factura a partir de su id
     *
     * @param id
     * @return factura
     */
    public FacturaEntity getFactura(Long id) {
        FacturaEntity factura = facturaPersistence.find(id);
        if (factura == null) {
            throw new IllegalArgumentException("El factura solicitado no existe");
        }
        return factura;
    }
    
    
    
    /**
     * Crear una nueva factura
     *
     * @param entity
     * @return entity
     */
    public FacturaEntity createFactura(FacturaEntity entity) {

        facturaPersistence.create(entity);
        return entity;
    }
    
    
    /**
     * Metodo para actualizar un objeto de la entidad factura
     *
     * @param id
     * @param entity
     * @return factura
     */
    public FacturaEntity updateFactura(Long id, FacturaEntity entity) {
        FacturaEntity factura = facturaPersistence.update(entity);
        return factura;
    }
    
    
    /**
     * Metodo para eliminar un objeto de la entidad factura
     *
     * @param id
     */
    public void deleteFactura(Long id) {
        facturaPersistence.delete(id);
    }
}
