/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.dto;

import co.konrad.project1.ntd.entities.ComentarioProductoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO para el mapeo objeto relacional de la entidad ComentarioProducto
 *
 * @author Dairo, Fabian, Cristian
 * 
 */
public class ComentarioProductoDTO {
    
    private Long id;
    
    private String comentario;
    
    private int valoracion;

    /**
     * Constructor
     *
     * @param comentarioProducto
     */
    public ComentarioProductoDTO(ComentarioProductoEntity comentarioProducto) {
        this.id = comentarioProducto.getId();
        this.comentario = comentarioProducto.getComentario();
        this.valoracion = comentarioProducto.getValoracion();
    }

    public ComentarioProductoEntity toEntity(){
        ComentarioProductoEntity comentarioProducto = new ComentarioProductoEntity();
        comentarioProducto.setId(this.id);  
        comentarioProducto.setComentario(this.comentario);
        comentarioProducto.setValoracion(this.valoracion);
        
        return comentarioProducto;
    }
    
    public static List<ComentarioProductoDTO> toComentarioList(List<ComentarioProductoEntity> comentarioList) {
        List<ComentarioProductoDTO> listaComentario = new ArrayList<>();
        for (int i = 0; i < comentarioList.size(); i++) {
            listaComentario.add(new ComentarioProductoDTO(comentarioList.get(i)));
        }
        return listaComentario;
    }
    
    /**
     * Metodos get y est de la entidad ComentarioProducto
     *
     * @return
     */
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
    
    
    
    
    
    
}
