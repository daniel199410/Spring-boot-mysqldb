package com.example.springbootmysqldb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
public class ArchivoGenerado {

    @Id
    @GeneratedValue
    @Column(name = "cdarchivo_generado")
    private int archivoGenerado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdconsulta")
    private Solicitud consulta;

    @Column(name = "dstipo_documento_empresa")
    private String tipoDocumentoEmpresa;

    @Column(name = "dsdocumento_empresa")
    private int documentoEmpresa;

    @Column(name = "dstipo_planilla", nullable = false)
    private String tipoPlanilla;

    @Column(name = "dsperiodo_cotizacion")
    private String periodoCotizacion;

    @Column(name = "dsperiodo_servicio")
    private String periodoServicio;

    @Column(name = "cdtipo_archivo", nullable = false)
    private int tipoArchivo;

    @Column(name = "dsubicacion", nullable = false, unique = true)
    private String ubicacion;

    @Column(name = "fefecha_creacion", nullable = false)
    private Date fechaCracion;

    public ArchivoGenerado() {
    }

    public ArchivoGenerado(Solicitud consulta, String tipoDocumentoEmpresa, int documentoEmpresa, String tipoPlanilla, String periodoCotizacion, String periodoServicio, int tipoArchivo, String ubicacion, Date fechaCracion) {
        this.consulta = consulta;
        this.tipoDocumentoEmpresa = tipoDocumentoEmpresa;
        this.documentoEmpresa = documentoEmpresa;
        this.tipoPlanilla = tipoPlanilla;
        this.periodoCotizacion = periodoCotizacion;
        this.periodoServicio = periodoServicio;
        this.tipoArchivo = tipoArchivo;
        this.ubicacion = ubicacion;
        this.fechaCracion = fechaCracion;
    }

    public int getArchivoGenerado() {
        return archivoGenerado;
    }

    public void setArchivoGenerado(int archivoGenerado) {
        this.archivoGenerado = archivoGenerado;
    }

    public Solicitud getConsulta() {
        return consulta;
    }

    public void setConsulta(Solicitud consulta) {
        this.consulta = consulta;
    }

    public String getTipoDocumentoEmpresa() {
        return tipoDocumentoEmpresa;
    }

    public void setTipoDocumentoEmpresa(String tipoDocumentoEmpresa) {
        this.tipoDocumentoEmpresa = tipoDocumentoEmpresa;
    }

    public int getDocumentoEmpresa() {
        return documentoEmpresa;
    }

    public void setDocumentoEmpresa(int documentoEmpresa) {
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

    public int getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(int tipoArchivo) {
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
