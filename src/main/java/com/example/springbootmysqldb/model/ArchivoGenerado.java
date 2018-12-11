package com.example.springbootmysqldb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TPP_ARCHIVO_GENERADO")
public class ArchivoGenerado {

    @Id
    @GeneratedValue
    @Column(name = "cdarchivo_generado")
    private Integer archivoGenerado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdsolicitud", nullable = false, unique = false)
    private Solicitud solicitud;

    @Column(name = "dstipo_documento_empresa", nullable = true, unique = false, length = 2)
    private String tipoDocumentoEmpresa;

    @Column(name = "dsdocumento_empresa", nullable = true, unique = false, length = 16)
    private String documentoEmpresa;

    @Column(name = "dstipo_planilla", nullable = true, unique = false, length = 1)
    private String tipoPlanilla;

    @Column(name = "dsperiodo_cotizacion", nullable = true, unique = false, length = 15)
    private String periodoCotizacion;

    @Column(name = "dsperiodo_servicio", nullable = true, unique = false, length = 15)
    private String periodoServicio;

    @Column(name = "cdtipo_archivo", nullable = false, unique = false, precision = 10)
    private Integer tipoArchivo;

    @Column(name = "dsubicacion", nullable = false, unique = true, length = 50)
    private String ubicacion;

    @Column(name = "fefecha_creacion", nullable = false, unique = false)
    private Date fechaCracion;

    public ArchivoGenerado() {
    }

    public Integer getArchivoGenerado() {
        return archivoGenerado;
    }

    public void setArchivoGenerado(Integer archivoGenerado) {
        this.archivoGenerado = archivoGenerado;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
    public String getTipoDocumentoEmpresa() {
        return tipoDocumentoEmpresa;
    }

    public void setTipoDocumentoEmpresa(String tipoDocumentoEmpresa) {
        this.tipoDocumentoEmpresa = tipoDocumentoEmpresa;
    }

    public String getDocumentoEmpresa() {
        return documentoEmpresa;
    }

    public void setDocumentoEmpresa(String documentoEmpresa) {
        this.documentoEmpresa = documentoEmpresa;
    }

    public String getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(String tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public String getPeriodoCotizacion() {
        return periodoCotizacion;
    }

    public void setPeriodoCotizacion(String periodoCotizacion) {
        this.periodoCotizacion = periodoCotizacion;
    }

    public String getPeriodoServicio() {
        return periodoServicio;
    }

    public void setPeriodoServicio(String periodoServicio) {
        this.periodoServicio = periodoServicio;
    }

    public Integer getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(Integer tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaCracion() {
        return fechaCracion;
    }

    public void setFechaCracion(Date fechaCracion) {
        this.fechaCracion = fechaCracion;
    }
}
