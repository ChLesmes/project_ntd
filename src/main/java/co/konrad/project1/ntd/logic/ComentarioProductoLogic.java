/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.logic;


import co.konrad.project1.ntd.entities.ComentarioProductoEntity;
import co.konrad.project1.ntd.persistence.ComentarioProductoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Dairo
 */
@Stateless
public class ComentarioProductoLogic {
    
    
        /*
    Inyección del persistence de la entidad
     */
    @Inject
    private ComentarioProductoPersistence comentarioProductoPersistence;
    
    
    /**
     * Obtener todos lo comentarioProducto
     *
     * @return comentarioProducto
     */
    public List<ComentarioProductoEntity> getComentariosProducto() {
        List<ComentarioProductoEntity> comentariosProductos = comentarioProductoPersistence.findAll();
        return comentariosProductos;
    }
    
    
    /**
     * Ontener un comentarioProducto a partir de su id
     *
     * @param id
     * @return comentarioProducto
     */
    public ComentarioProductoEntity getComentarioProducto(Long id) {
        ComentarioProductoEntity comentarioProducto = comentarioProductoPersistence.find(id);
        if (comentarioProducto == null) {
            throw new IllegalArgumentException("El comentario solicitado no existe");
        }
        return comentarioProducto;
    }
    
    
    
    /**
     * Crear un nuevo comentarioProducto
     *
     * @param entity
     * @return entity
     */
    public ComentarioProductoEntity createComentarioProducto(ComentarioProductoEntity entity) {

        comentarioProductoPersistence.create(entity);
        return entity;
    }
    
    
    /**
     * Metodo para actualizar un objeto de la entidad comentarioProducto
     *
     * @param id
     * @param entity
     * @return comentarioProducto
     */
    public ComentarioProductoEntity updateComentarioProducto(Long id, ComentarioProductoEntity entity) {
        ComentarioProductoEntity comentarioProducto = comentarioProductoPersistence.update(entity);
        return comentarioProducto;
    }
    
    
    /**
     * Metodo para eliminar un objeto de la entidad carrito
     *
     * @param id
     */
    public void deleteComentarioProducto(Long id) {
        comentarioProductoPersistence.delete(id);
    }
    
}
