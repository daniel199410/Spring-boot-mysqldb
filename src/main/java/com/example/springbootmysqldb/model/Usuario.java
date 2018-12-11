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
    @Column(name = "cdusuario")
    private Long codigo;
    @Column(name = "dstipo_codumento", nullable = false, unique = false, length = 2)
    private String tipoDocumento;
    @Column(name = "dsdocumento", nullable = false, unique = true, length = 16)
    private String documento;
    @Column(name = "dsprimer_nombre", nullable = false, unique = false, length = 30)
    private String primerNombre;
    @Column(name = "dssegundo_nombre", nullable = true, unique = false, length = 30)
    private String segundoNombre;
    @Column(name = "dsprimer_apellido", nullable = false, unique = false, length = 30)
    private String primerApellido;
    @Column(name = "dssegundo_apellido", nullable = true, unique = false, length = 30)
    private String segundoApellido;
    @Column(name = "dscorreo_electronico", nullable = false, unique = false, length = 50)
    private String correo;
    @Column(name = "cdarea", nullable = false, unique = false, precision = 20)
    private Integer area;
    @Column(name = "cdcargo", nullable = false, unique = false, precision = 20)
    private Integer cargo;
    @Column(name = "cdrol", nullable = false, unique = false, precision = 20)
    private Byte rol;
    @Column(name = "dscontrasena", nullable = false, unique = false, length = 50)
    private String contrasena;
    @Column(name = "fefecha_creacion", nullable = false, unique = false)
    private Date fechaCreacion;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Solicitud> solicitudes;

    public Usuario(Long codigo) {
        this.codigo = codigo;
    }

    public Usuario() { }


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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
