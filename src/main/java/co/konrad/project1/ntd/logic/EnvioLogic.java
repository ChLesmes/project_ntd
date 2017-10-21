/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.logic;


import co.konrad.project1.ntd.entities.EnvioEntity;
import co.konrad.project1.ntd.persistence.EnvioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * 
 * @author Dairo, Fabian, Cristian
 * 
 */
@Stateless
public class EnvioLogic {
    
    
    /*
    Inyección del persistence de la entidad
     */
    @Inject
    private EnvioPersistence envioPersistence;
    
    
    /**
     * Obtener todos los envios
     *
     * @return envios
     */
    public List<EnvioEntity> getEnvios() {
        List<EnvioEntity> envios = envioPersistence.findAll();
        return envios;
    }
    
    
    /**
     * Ontener un envio a partir de su id
     *
     * @param id
     * @return envio
     */
    public EnvioEntity getEnvio(Long id) {
        EnvioEntity envio = envioPersistence.find(id);
        if (envio == null) {
            throw new IllegalArgumentException("El envio solicitado no existe");
        }
        return envio;
    }
    
    
    
    /**
     * Crear un nuevo envio
     *
     * @param entity
     * @return entity
     */
    public EnvioEntity createEnvio(EnvioEntity entity) {

        envioPersistence.create(entity);
        return entity;
    }
    
    
    /**
     * Metodo para actualizar un objeto de la entidad envio
     *
     * @param id
     * @param entity
     * @return envio
     */
    public EnvioEntity updateEnvio(Long id, EnvioEntity entity) {
        EnvioEntity envio = envioPersistence.update(entity);
        return envio;
    }
    
    
    /**
     * Metodo para eliminar un objeto de la entidad envio
     *
     * @param id
     */
    public void deleteEnvio(Long id) {
        envioPersistence.delete(id);
    }
    
}
