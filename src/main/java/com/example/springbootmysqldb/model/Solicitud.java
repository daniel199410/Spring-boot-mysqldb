package com.example.springbootmysqldb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PPT_SOLICITUD")
public class Solicitud {
    @Id
    @GeneratedValue
    @Column(name = "cdsolicitud")
    private Long codigo;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdusuario")
    private Usuario user;
    @Column(name = "cdtipo_solicitud", nullable = false)
    private String tipoSolicitud;
    @Column(name = "dsubicacion", unique = true, nullable = false)
    private String ubicacion;
    @Column(name = "nmcantidad_intentos", nullable = false)
    private Long cantidadIntentos;
    @Column(name = "fefecha_creacion", nullable = false)
    private Date fechaCreacion;

    public Solicitud() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario usuario) {
        this.user = usuario;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Long getCantidadIntentos() {
        return cantidadIntentos;
    }

    public void setCantidadIntentos(Long cantidadIntentos) {
        this.cantidadIntentos = cantidadIntentos;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
