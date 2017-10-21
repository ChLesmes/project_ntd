/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.logic;


import co.konrad.project1.ntd.entities.ProveedorEntity;
import co.konrad.project1.ntd.persistence.ProveedorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Dairo
 */
@Stateless
public class ProveedorLogic {
    
        /*
    Inyección del persistence de la entidad
     */
    @Inject
    private ProveedorPersistence proveedorPersistence;
    
    
    /**
     * Obtener todos los proveedores
     *
     * @return proveedor
     */
    public List<ProveedorEntity> getProveedores() {
        List<ProveedorEntity> proveedor = proveedorPersistence.findAll();
        return proveedor;
    }
    
    
    /**
     * Ontener un carrito a partir de su id
     *
     * @param id
     * @return proveedor
     */
    public ProveedorEntity getProveedor(Long id) {
        ProveedorEntity proveedor = proveedorPersistence.find(id);
        if (proveedor == null) {
            throw new IllegalArgumentException("El proveedor solicitado no existe");
        }
        return proveedor;
    }
    
    
    
    /**
     * Crear un nuevo proveedor
     *
     * @param entity
     * @return entity
     */
    public ProveedorEntity createProveedor(ProveedorEntity entity) {

        proveedorPersistence.create(entity);
        return entity;
    }
    
    
    /**
     * Metodo para actualizar un objeto de la entidad proveedor
     *
     * @param id
     * @param entity
     * @return proveedor
     */
    public ProveedorEntity updateProveedor(Long id, ProveedorEntity entity) {
        ProveedorEntity proveedor = proveedorPersistence.update(entity);
        return proveedor;
    }
    
    
    /**
     * Metodo para eliminar un objeto de la entidad proveedor
     *
     * @param id
     */
    public void deleteProveedor(Long id) {
        proveedorPersistence.delete(id);
    }
    
}
