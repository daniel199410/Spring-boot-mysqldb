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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cdusuario", nullable = false, unique = false)
    private Usuario usuario;

    @Column(name = "cdtipo_solicitud", nullable = false, unique = false, precision = 10)
    private String tipo;

    @Column(name = "dsubicacion", nullable = false, unique = true, length = 50)
    private String ubicacion;

    @Column(name = "cdestado", nullable = false, unique = false, precision = 1)
    private Byte estado;

    @Column(name = "nmcantidad_intentos", nullable = false, unique = false, precision = 1)
    private byte cantidadIntentos;

    @Column(name = "fefecha_creacion", nullable = false, unique = false)
    private Date fechaCreacion;

    public Solicitud() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
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

    public Byte getEstado() {
        return estado;
    }

    public void setEstado(Byte estado) {
        this.estado = estado;
    }

    public Byte getCantidadIntentos() {
        return cantidadIntentos;
    }

    public void setCantidadIntentos(Byte cantidadIntentos) {
        this.cantidadIntentos = cantidadIntentos;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
