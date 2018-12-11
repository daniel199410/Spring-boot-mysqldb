package com.example.springbootmysqldb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TPP_SOLICITUD")
public class Solicitud {
    @Id
    @GeneratedValue
    @Column(name = "cdsolicitud")
    private Long codigo;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdusuario")
    private Usuario usuario;
    @Column(name = "cdtipo_solicitud", nullable = false)
    private String tipo;
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
        return usuario;
    }

    public void setUser(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
