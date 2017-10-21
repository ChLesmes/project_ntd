/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.dto;

import co.konrad.project1.ntd.entities.MetodoPagoEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dairo
 */
public class MetodoPagoDTO {
    
    private Long id;
    
    private String nombre;
    
    private String detalle;
    
    private String banco;
    
    private Long numeroCuenta;
    
    private Date fechaVencimiento;
    
    private Long clave;

    public MetodoPagoDTO(MetodoPagoEntity metodoPago) {
        this.id = metodoPago.getId();
        this.nombre = metodoPago.getNombre();
        this.detalle = metodoPago.getDetalle();
        this.banco = metodoPago.getBanco();
        this.numeroCuenta = metodoPago.getNumeroCuenta();
        this.fechaVencimiento = metodoPago.getFechaVencimiento();
        this.clave = metodoPago.getClave();
    }
    
    public MetodoPagoEntity toEntity(){
        MetodoPagoEntity metodoPago = new MetodoPagoEntity();
        metodoPago.setId(this.id);
        metodoPago.setNombre(this.nombre);
        metodoPago.setDetalle(this.detalle);
        metodoPago.setBanco(this.banco);
        metodoPago.setNumeroCuenta(this.numeroCuenta);
        metodoPago.setFechaVencimiento(this.fechaVencimiento);
        metodoPago.setClave(this.clave);
        
        return metodoPago;
    }
    
    public static List<MetodoPagoDTO> toMetodoList(List<MetodoPagoEntity> metodoList) {
        List<MetodoPagoDTO> listaMetodo = new ArrayList<>();
        for (int i = 0; i < metodoList.size(); i++) {
            listaMetodo.add(new MetodoPagoDTO(metodoList.get(i)));
        }
        return listaMetodo;
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getClave() {
        return clave;
    }

    public void setClave(Long clave) {
        this.clave = clave;
    }
    
    
    
    
    
}
