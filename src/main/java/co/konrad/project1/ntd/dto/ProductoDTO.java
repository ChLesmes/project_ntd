/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.dto;

import co.konrad.project1.ntd.entities.CategoriaEntity;
import co.konrad.project1.ntd.entities.ComentarioProductoEntity;
import co.konrad.project1.ntd.entities.ProductoEntity;
import co.konrad.project1.ntd.entities.PromocionEntity;
import co.konrad.project1.ntd.entities.ProveedorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO para el mapeo objeto relacional de la entidad Producto
 *
 * @author Dairo, Fabian, Cristian
 * 
 */
public class ProductoDTO {
    
    private Long id;
    
    private String nombre;
    
    private String descripcion;
    
    private String stock;
    
    private Long precio;
    
    private String marca;
    
    private String garantia;
    
    private CategoriaEntity categoria;
    
    private ProveedorEntity proveedor;
    
    private PromocionEntity promocion;
    
    private ComentarioProductoEntity comentario;

    
    /**
     * Constructor
     *
     * @param producto
     */
    public ProductoDTO(ProductoEntity producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.descripcion = producto.getDescripcion();
        this.stock = producto.getStock();
        this.precio = producto.getPrecio();
        this.marca = producto.getMarca();
        this.garantia = producto.getGarantia();
        this.categoria = producto.getCategoria();
        this.proveedor = producto.getProveedor();
        this.promocion = producto.getPromocion();
        this.comentario = producto.getComentario();
    }
    
    public ProductoEntity toEntity(){
        ProductoEntity producto = new ProductoEntity();
        producto.setId(this.id); 
        producto.setNombre(this.nombre);
        producto.setDescripcion(this.descripcion);
        producto.setStock(this.stock);
        producto.setPrecio(this.precio);
        producto.setMarca(this.marca);
        producto.setGarantia(this.garantia);
        producto.setCategoria(this.categoria);
        producto.setProveedor(this.proveedor);
        producto.setPromocion(this.promocion);
        producto.setComentario(this.comentario);
        
        
        return producto;
    }
    
    public static List<ProductoDTO> toProductoList(List<ProductoEntity> productoList) {
        List<ProductoDTO> listaProducto = new ArrayList<>();
        for (int i = 0; i < productoList.size(); i++) {
            listaProducto.add(new ProductoDTO(productoList.get(i)));
        }
        return listaProducto;
    }
    
    
    
    /**
     * Metodos get y est de la entidad Producto
     *
     * @return
     */

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    public ProveedorEntity getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorEntity proveedor) {
        this.proveedor = proveedor;
    }

    public PromocionEntity getPromocion() {
        return promocion;
    }

    public void setPromocion(PromocionEntity promocion) {
        this.promocion = promocion;
    }

    public ComentarioProductoEntity getComentario() {
        return comentario;
    }

    public void setComentario(ComentarioProductoEntity comentario) {
        this.comentario = comentario;
    }
    
    
    
    
    
}
