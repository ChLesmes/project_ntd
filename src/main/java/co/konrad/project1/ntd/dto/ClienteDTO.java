
package co.konrad.project1.ntd.dto;
import co.konrad.project1.ntd.entities.CarritoEntity;
import co.konrad.project1.ntd.entities.ClienteEntity;
import co.konrad.project1.ntd.entities.EnvioEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * DTO para el mapeo objeto relacional de la entidad Cliente
 *
 * @author Dairo, Fabian, Cristian
 * 
 */
public class ClienteDTO {
    
    private Long id;
    
    private String tipoDocumento;
    
    private Long numeroDocumento;
    
    private String nombre;
    
    private String apellido;
    
    private Long telefono;
    
    private String email;
    
    private Date fechaNacimiento;
    
    private String direccion;
    
    private String ciudad;
    
    private String pais;
    
    private String usuario;
    
    private String password;
    
    private byte[] imagen;
    
    private EnvioEntity envio;
    
    private CarritoEntity carrito;

    /**
     * Constructor
     *
     * @param cliente
     */
    
    public ClienteDTO(ClienteEntity cliente) {
        this.id = cliente.getId();
        this.tipoDocumento = cliente.getTipoDocumento();
        this.numeroDocumento = cliente.getNumeroDocumento();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.telefono = cliente.getTelefono();
        this.email = cliente.getEmail();
        this.fechaNacimiento = cliente.getFechaNacimiento();
        this.direccion = cliente.getDireccion();
        this.ciudad = cliente.getCiudad();
        this.pais = cliente.getCiudad();
        this.usuario = cliente.getUsuario();
        this.password = cliente.getPassword();
        this.imagen = cliente.getImagen();
        this.envio = cliente.getEnvio();
        this.carrito = cliente.getCarrito();
    }

    public ClienteEntity toEntity() {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setId(this.id);
        cliente.setTipoDocumento(this.tipoDocumento);
        cliente.setNumeroDocumento(numeroDocumento);
        cliente.setNombre(this.nombre);
        cliente.setApellido(this.apellido);
        cliente.setTelefono(this.telefono);
        cliente.setEmail(this.email);
        cliente.setFechaNacimiento(this.fechaNacimiento);
        cliente.setDireccion(this.direccion);
        cliente.setCiudad(this.ciudad);
        cliente.setPais(this.pais);
        cliente.setUsuario(this.usuario);
        cliente.setPassword(this.password);
        cliente.setImagen(this.imagen);
        cliente.setEnvio(this.envio);
        cliente.setCarrito(this.carrito);
        
        return cliente;
    }
    
    public static List<ClienteDTO> toClienteList(List<ClienteEntity> clienteList) {
        List<ClienteDTO> listaClientes = new ArrayList<>();
        for (int i = 0; i < clienteList.size(); i++) {
            listaClientes.add(new ClienteDTO(clienteList.get(i)));
        }
        return listaClientes;
    }
    
    
    /**
     * Metodos get y set de la entidad Cliente
     *
     * @return
     */
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public EnvioEntity getEnvio() {
        return envio;
    }

    public void setEnvio(EnvioEntity envio) {
        this.envio = envio;
    }

    public CarritoEntity getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoEntity carrito) {
        this.carrito = carrito;
    }
    
    
    
    
}
