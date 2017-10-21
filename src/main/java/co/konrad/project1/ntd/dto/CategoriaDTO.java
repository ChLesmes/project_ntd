/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.dto;
import co.konrad.project1.ntd.entities.CategoriaEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dairo
 */
public class CategoriaDTO {
    
    private Long id;
    private String nombre;
    private String categoria;
    private String descripcion;

    public CategoriaDTO(CategoriaEntity categorias) {
        this.id = categorias.getId();
        this.nombre = categorias.getNombre();
        this.categoria = categorias.getCategoria();
        this.descripcion = categorias.getDescripcion();
    }

    
    public CategoriaEntity toEntity(){
        CategoriaEntity categorias = new CategoriaEntity();
        categorias.setId(this.id);
        categorias.setNombre(this.nombre);
        categorias.setCategoria(this.categoria);
        categorias.setDescripcion(this.descripcion);
        
        return categorias;
    }
        
    public static List<CategoriaDTO> toCategoriaList(List<CategoriaEntity> categoriaList) {
        List<CategoriaDTO> listaCategoria = new ArrayList<>();
        for (int i = 0; i < categoriaList.size(); i++) {
            listaCategoria.add(new CategoriaDTO(categoriaList.get(i)));
        }
        return listaCategoria;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
    
    
}
