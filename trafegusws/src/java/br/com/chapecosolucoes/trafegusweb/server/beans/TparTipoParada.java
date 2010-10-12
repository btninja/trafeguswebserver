/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "tpar_tipo_parada")
@NamedQueries({
    @NamedQuery(name = "TparTipoParada.findAll", query = "SELECT t FROM TparTipoParada t"),
    @NamedQuery(name = "TparTipoParada.findByTparCodigo", query = "SELECT t FROM TparTipoParada t WHERE t.tparCodigo = :tparCodigo"),
    @NamedQuery(name = "TparTipoParada.findByTparDescricao", query = "SELECT t FROM TparTipoParada t WHERE t.tparDescricao = :tparDescricao")})
public class TparTipoParada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tpar_codigo")
    private Integer tparCodigo;
    @Column(name = "tpar_descricao")
    private String tparDescricao;
    @OneToMany(mappedBy = "tparTipoParada", fetch = FetchType.EAGER)
    private List<RponRotaPonto> rponRotaPontoList;
    @OneToMany(mappedBy = "tparTipoParada", fetch = FetchType.EAGER)
    private List<VlocViagemLocal> vlocViagemLocalList;

    public TparTipoParada() {
    }

    public TparTipoParada(Integer tparCodigo) {
        this.tparCodigo = tparCodigo;
    }

    public Integer getTparCodigo() {
        return tparCodigo;
    }

    public void setTparCodigo(Integer tparCodigo) {
        this.tparCodigo = tparCodigo;
    }

    public String getTparDescricao() {
        return tparDescricao;
    }

    public void setTparDescricao(String tparDescricao) {
        this.tparDescricao = tparDescricao;
    }

    public List<RponRotaPonto> getRponRotaPontoList() {
        return rponRotaPontoList;
    }

    public void setRponRotaPontoList(List<RponRotaPonto> rponRotaPontoList) {
        this.rponRotaPontoList = rponRotaPontoList;
    }

    public List<VlocViagemLocal> getVlocViagemLocalList() {
        return vlocViagemLocalList;
    }

    public void setVlocViagemLocalList(List<VlocViagemLocal> vlocViagemLocalList) {
        this.vlocViagemLocalList = vlocViagemLocalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tparCodigo != null ? tparCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TparTipoParada)) {
            return false;
        }
        TparTipoParada other = (TparTipoParada) object;
        if ((this.tparCodigo == null && other.tparCodigo != null) || (this.tparCodigo != null && !this.tparCodigo.equals(other.tparCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.TparTipoParada[tparCodigo=" + tparCodigo + "]";
    }

}