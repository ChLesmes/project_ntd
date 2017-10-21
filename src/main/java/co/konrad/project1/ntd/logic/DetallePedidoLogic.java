/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.logic;


import co.konrad.project1.ntd.entities.DetallePedidoEntity;
import co.konrad.project1.ntd.persistence.DetallePedidoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Dairo
 */
@Stateless
public class DetallePedidoLogic {
    
    
        /*
    Inyección del persistence de la entidad
     */
    @Inject
    private DetallePedidoPersistence detallePedidoPersistence;
    
    
    /**
     * Obtener todos lo detallePedido
     *
     * @return detallePedido
     */
    public List<DetallePedidoEntity> getDetallesPedidos() {
        List<DetallePedidoEntity> detallePedido = detallePedidoPersistence.findAll();
        return detallePedido;
    }
    
    
    /**
     * Ontener un detallePedido a partir de su id
     *
     * @param id
     * @return detallePedido
     */
    public DetallePedidoEntity getDetallePedido(Long id) {
        DetallePedidoEntity detallePedido = detallePedidoPersistence.find(id);
        if (detallePedido == null) {
            throw new IllegalArgumentException("El carrito solicitado no existe");
        }
        return detallePedido;
    }
    
    
    
    /**
     * Crear un nuevo detallePedido
     *
     * @param entity
     * @return entity
     */
    public DetallePedidoEntity createDetallePedido(DetallePedidoEntity entity) {

        detallePedidoPersistence.create(entity);
        return entity;
    }
    
    
    /**
     * Metodo para actualizar un objeto de la entidad detallePedido
     *
     * @param id
     * @param entity
     * @return detallePedido
     */
    public DetallePedidoEntity updateDetallePedido(Long id, DetallePedidoEntity entity) {
        DetallePedidoEntity detallePedido = detallePedidoPersistence.update(entity);
        return detallePedido;
    }
    
    
    /**
     * Metodo para eliminar un objeto de la entidad detallePedido
     *
     * @param id
     */
    public void deleteDetallePedido(Long id) {
        detallePedidoPersistence.delete(id);
    }
    
    
}
