/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.logic;


import co.konrad.project1.ntd.entities.CategoriaEntity;
import co.konrad.project1.ntd.persistence.CategoriaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * 
 * @author Dairo, Fabian, Cristian
 * 
 */
@Stateless
public class CategoriaLogic {
    
        /*
    Inyección del persistence de la entidad
     */
    @Inject
    private CategoriaPersistence categoriaPersistence;
    
    
    /**
     * Obtener todos las categorias
     *
     * @return categorias
     */
    public List<CategoriaEntity> getCategorias() {
        List<CategoriaEntity> categorias = categoriaPersistence.findAll();
        return categorias;
    }
    
    
    /**
     * Ontener una categoria a partir de su id
     *
     * @param id
     * @return categoria
     */
    public CategoriaEntity getCategoria(Long id) {
        CategoriaEntity categoria = categoriaPersistence.find(id);
        if (categoria == null) {
            throw new IllegalArgumentException("La categoria solicitado no existe");
        }
        return categoria;
    }
    
    
    
    /**
     * Crear una nueva categoria
     *
     * @param entity
     * @return entity
     */
    public CategoriaEntity createCategoria(CategoriaEntity entity) {

        categoriaPersistence.create(entity);
        return entity;
    }
    
    
    /**
     * Metodo para actualizar un objeto de la entidad categoria
     *
     * @param id
     * @param entity
     * @return categoria
     */
    public CategoriaEntity updateCategoria(Long id, CategoriaEntity entity) {
        CategoriaEntity categoria = categoriaPersistence.update(entity);
        return categoria;
    }
    
    
    /**
     * Metodo para eliminar un objeto de la entidad categoria
     *
     * @param id
     */
    public void deleteCategoria(Long id) {
        categoriaPersistence.delete(id);
    }
    
}
