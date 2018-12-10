package com.example.springbootmysqldb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TPP_USUARIOS")
public class Usuario {
	
	@Id
	@Column(name = "cdusuario")
	private int idcolumna;
	
	@Column(name = "dstipo_documento")
	private String tipoDocumento;
	
	@Column(name = "dsdocumento")
	private String numeroDocumento;
	
	@Column(name = "dsprimer_nombre")
	private String primerNombre;
	
	@Column(name = "dssegundo_nombre")
	private String segundoNombre;
	
	@Column(name = "dsprimer_apellido")
	private String primerApellido;
	
	@Column(name = "dssegundo_apellido")
	private String segundoApellido;
	
	@Column(name = "dscorreo_electronico")
	private String correoElectronico;
	
	@Column(name = "cdtarea")
	private String codigoTarea;
	
	@Column(name = "cdcargo")
	private String codigoCargo;
	
	@Column(name = "cdrol")
	private String codigoRol;
	
	@Column(name = "dscontrasena")
	private String contrasena;
	
	@Column(name = "fefecha_creacion")
	private String fechaCreacion;
}
