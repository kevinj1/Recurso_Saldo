/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "equipo_recaudos", catalog = "saldo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipoRecaudos.findAll", query = "SELECT e FROM EquipoRecaudos e")
    , @NamedQuery(name = "EquipoRecaudos.findByIdEquipoRecaudo", query = "SELECT e FROM EquipoRecaudos e WHERE e.idEquipoRecaudo = :idEquipoRecaudo")
    , @NamedQuery(name = "EquipoRecaudos.findByEquipoRecaudo", query = "SELECT e FROM EquipoRecaudos e WHERE e.equipoRecaudo = :equipoRecaudo")
    , @NamedQuery(name = "EquipoRecaudos.findBySaldo", query = "SELECT e FROM EquipoRecaudos e WHERE e.saldo = :saldo")
    , @NamedQuery(name = "EquipoRecaudos.findByFechaHoraRegistro", query = "SELECT e FROM EquipoRecaudos e WHERE e.fechaHoraRegistro = :fechaHoraRegistro")
    , @NamedQuery(name = "EquipoRecaudos.findByIdTipoEquipoRecaudo", query = "SELECT e FROM EquipoRecaudos e WHERE e.idTipoEquipoRecaudo = :idTipoEquipoRecaudo")
    , @NamedQuery(name = "EquipoRecaudos.findByMarca", query = "SELECT e FROM EquipoRecaudos e WHERE e.marca = :marca")
    , @NamedQuery(name = "EquipoRecaudos.findByNumeroSim", query = "SELECT e FROM EquipoRecaudos e WHERE e.numeroSim = :numeroSim")
    , @NamedQuery(name = "EquipoRecaudos.findByUsuarioCreacion", query = "SELECT e FROM EquipoRecaudos e WHERE e.usuarioCreacion = :usuarioCreacion")
    , @NamedQuery(name = "EquipoRecaudos.findByPsamNo", query = "SELECT e FROM EquipoRecaudos e WHERE e.psamNo = :psamNo")
    , @NamedQuery(name = "EquipoRecaudos.findByActualizacionSaldo", query = "SELECT e FROM EquipoRecaudos e WHERE e.actualizacionSaldo = :actualizacionSaldo")
    , @NamedQuery(name = "EquipoRecaudos.findByUsuarioActualizacion", query = "SELECT e FROM EquipoRecaudos e WHERE e.usuarioActualizacion = :usuarioActualizacion")
    , @NamedQuery(name = "EquipoRecaudos.findByFechaHoraActualizacion", query = "SELECT e FROM EquipoRecaudos e WHERE e.fechaHoraActualizacion = :fechaHoraActualizacion")
    , @NamedQuery(name = "EquipoRecaudos.findByIdUsuarioEliminacion", query = "SELECT e FROM EquipoRecaudos e WHERE e.idUsuarioEliminacion = :idUsuarioEliminacion")
    , @NamedQuery(name = "EquipoRecaudos.findByFechaHoraEliminacion", query = "SELECT e FROM EquipoRecaudos e WHERE e.fechaHoraEliminacion = :fechaHoraEliminacion")
    , @NamedQuery(name = "EquipoRecaudos.findByEliminado", query = "SELECT e FROM EquipoRecaudos e WHERE e.eliminado = :eliminado")})
public class EquipoRecaudos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipo_recaudo")
    private Integer idEquipoRecaudo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "equipo_recaudo")
    private long equipoRecaudo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private Double saldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_equipo_recaudo")
    private int idTipoEquipoRecaudo;
    @Size(max = 20)
    @Column(name = "marca")
    private String marca;
    @Size(max = 45)
    @Column(name = "numero_sim")
    private String numeroSim;
    @Column(name = "usuario_creacion")
    private Integer usuarioCreacion;
    @Size(max = 20)
    @Column(name = "psam_no")
    private String psamNo;
    @Column(name = "actualizacion_saldo")
    private Short actualizacionSaldo;
    @Column(name = "usuario_actualizacion")
    private Integer usuarioActualizacion;
    @Column(name = "fecha_hora_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraActualizacion;
    @Column(name = "id_usuario_eliminacion")
    private Integer idUsuarioEliminacion;
    @Column(name = "fecha_hora_eliminacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraEliminacion;
    @Column(name = "eliminado")
    private Integer eliminado;

    public EquipoRecaudos() {
    }

    public EquipoRecaudos(Integer idEquipoRecaudo) {
        this.idEquipoRecaudo = idEquipoRecaudo;
    }

    public EquipoRecaudos(Integer idEquipoRecaudo, long equipoRecaudo, Date fechaHoraRegistro, int idTipoEquipoRecaudo) {
        this.idEquipoRecaudo = idEquipoRecaudo;
        this.equipoRecaudo = equipoRecaudo;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.idTipoEquipoRecaudo = idTipoEquipoRecaudo;
    }

    public Integer getIdEquipoRecaudo() {
        return idEquipoRecaudo;
    }

    public void setIdEquipoRecaudo(Integer idEquipoRecaudo) {
        this.idEquipoRecaudo = idEquipoRecaudo;
    }

    public long getEquipoRecaudo() {
        return equipoRecaudo;
    }

    public void setEquipoRecaudo(long equipoRecaudo) {
        this.equipoRecaudo = equipoRecaudo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public int getIdTipoEquipoRecaudo() {
        return idTipoEquipoRecaudo;
    }

    public void setIdTipoEquipoRecaudo(int idTipoEquipoRecaudo) {
        this.idTipoEquipoRecaudo = idTipoEquipoRecaudo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumeroSim() {
        return numeroSim;
    }

    public void setNumeroSim(String numeroSim) {
        this.numeroSim = numeroSim;
    }

    public Integer getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(Integer usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getPsamNo() {
        return psamNo;
    }

    public void setPsamNo(String psamNo) {
        this.psamNo = psamNo;
    }

    public Short getActualizacionSaldo() {
        return actualizacionSaldo;
    }

    public void setActualizacionSaldo(Short actualizacionSaldo) {
        this.actualizacionSaldo = actualizacionSaldo;
    }

    public Integer getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(Integer usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public Date getFechaHoraActualizacion() {
        return fechaHoraActualizacion;
    }

    public void setFechaHoraActualizacion(Date fechaHoraActualizacion) {
        this.fechaHoraActualizacion = fechaHoraActualizacion;
    }

    public Integer getIdUsuarioEliminacion() {
        return idUsuarioEliminacion;
    }

    public void setIdUsuarioEliminacion(Integer idUsuarioEliminacion) {
        this.idUsuarioEliminacion = idUsuarioEliminacion;
    }

    public Date getFechaHoraEliminacion() {
        return fechaHoraEliminacion;
    }

    public void setFechaHoraEliminacion(Date fechaHoraEliminacion) {
        this.fechaHoraEliminacion = fechaHoraEliminacion;
    }

    public Integer getEliminado() {
        return eliminado;
    }

    public void setEliminado(Integer eliminado) {
        this.eliminado = eliminado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipoRecaudo != null ? idEquipoRecaudo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoRecaudos)) {
            return false;
        }
        EquipoRecaudos other = (EquipoRecaudos) object;
        if ((this.idEquipoRecaudo == null && other.idEquipoRecaudo != null) || (this.idEquipoRecaudo != null && !this.idEquipoRecaudo.equals(other.idEquipoRecaudo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.EquipoRecaudos[ idEquipoRecaudo=" + idEquipoRecaudo + " ]";
    }
    
}
