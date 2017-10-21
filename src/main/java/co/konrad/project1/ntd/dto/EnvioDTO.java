/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.project1.ntd.dto;

import co.konrad.project1.ntd.entities.EnvioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dairo
 */
public class EnvioDTO {
    
    private Long id;
    
    private String direccion;
    
    private String ciudad;    
    
    private String pais;

    public EnvioDTO(EnvioEntity envio) {
        this.id = envio.getId();
        this.direccion = envio.getDireccion();
        this.ciudad = envio.getCiudad();
        this.pais = envio.getPais();
    }

    public EnvioEntity toEntity(){
        EnvioEntity envio = new EnvioEntity();
        envio.setId(this.id);
        envio.setDireccion(this.direccion);
        envio.setCiudad(this.ciudad);
        envio.setPais(this.pais);
        return envio;
    }
    
    public static List<EnvioDTO> toEnvioList(List<EnvioEntity> envioList) {
        List<EnvioDTO> listaEnvio = new ArrayList<>();
        for (int i = 0; i < envioList.size(); i++) {
            listaEnvio.add(new EnvioDTO(envioList.get(i)));
        }
        return listaEnvio;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
    
    
    
    
}
