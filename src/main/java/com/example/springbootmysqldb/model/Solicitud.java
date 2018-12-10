package com.example.springbootmysqldb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Solicitud {
    @Id
    @GeneratedValue
    @Column(name = "cdSolicitud")
    private Long cdSolicitud;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdusuario")
    private Users user;
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

    public Long getCdSolicitud() {
        return cdSolicitud;
    }

    public void setCdSolicitud(Long cdSolicitud) {
        this.cdSolicitud = cdSolicitud;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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
