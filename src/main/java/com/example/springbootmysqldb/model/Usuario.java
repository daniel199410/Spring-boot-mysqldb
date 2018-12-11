package com.example.springbootmysqldb.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TPP_USUARIO")
public class Usuario {
    @Id
    @GeneratedValue
    @Column(name = "cdUsuario")
    private long id;
    @Column(name = "dstipo_codumento", nullable = false)
    private String tipoDocumento;
    @Column(name = "dsdocumento", nullable = false, unique = true)
    private String documento;
    @Column(name = "dsprimer_nombre", nullable = false)
    private String primerNombre;
    @Column(name = "dssegundo_nombre")
    private String segundoNombre;
    @Column(name = "dsprimer_apellido", nullable = false)
    private String primerApellido;
    @Column(name = "dssegundo_apellido", nullable = false)
    private String segundoApellido;
    @Column(name = "dscorreo_electronico", nullable = false)
    private String correo;
    @Column(name = "cdarea", nullable = false)
    private Integer area;
    @Column(name = "cdcargo", nullable = false)
    private Integer cargo;
    @Column(name = "cdrol", nullable = false)
    private Byte rol;
    @Column(name = "dscontrasena", nullable = false)
    private String contrasena;
    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Solicitud> solicitudes;

    public Usuario(long user_id) {
        this.id = user_id;
    }

    public Usuario() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        for(Solicitud solicitud: solicitudes) {
            this.solicitudes.add(solicitud);
            solicitud.setUser(this);
        }
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getCargo() {
        return cargo;
    }

    public void setCargo(Integer cargo) {
        this.cargo = cargo;
    }

    public Byte getRol() {
        return rol;
    }

    public void setRol(Byte rol) {
        this.rol = rol;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
