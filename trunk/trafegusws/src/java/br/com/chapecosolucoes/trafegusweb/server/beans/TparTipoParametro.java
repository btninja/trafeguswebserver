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
@Table(name = "tpar_tipo_parametro")
@NamedQueries({
    @NamedQuery(name = "TparTipoParametro.findAll", query = "SELECT t FROM TparTipoParametro t"),
    @NamedQuery(name = "TparTipoParametro.findByTparCodigo", query = "SELECT t FROM TparTipoParametro t WHERE t.tparCodigo = :tparCodigo"),
    @NamedQuery(name = "TparTipoParametro.findByTparDescricao", query = "SELECT t FROM TparTipoParametro t WHERE t.tparDescricao = :tparDescricao")})
public class TparTipoParametro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tpar_codigo")
    private Integer tparCodigo;
    @Column(name = "tpar_descricao")
    private String tparDescricao;
    @OneToMany(mappedBy = "tparTipoParametro", fetch = FetchType.EAGER)
    private List<PaipPgAssociaItemParam> paipPgAssociaItemParamList;
    @OneToMany(mappedBy = "tparTipoParametro", fetch = FetchType.EAGER)
    private List<PipaPgItemParametro> pipaPgItemParametroList;

    public TparTipoParametro() {
    }

    public TparTipoParametro(Integer tparCodigo) {
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

    public List<PaipPgAssociaItemParam> getPaipPgAssociaItemParamList() {
        return paipPgAssociaItemParamList;
    }

    public void setPaipPgAssociaItemParamList(List<PaipPgAssociaItemParam> paipPgAssociaItemParamList) {
        this.paipPgAssociaItemParamList = paipPgAssociaItemParamList;
    }

    public List<PipaPgItemParametro> getPipaPgItemParametroList() {
        return pipaPgItemParametroList;
    }

    public void setPipaPgItemParametroList(List<PipaPgItemParametro> pipaPgItemParametroList) {
        this.pipaPgItemParametroList = pipaPgItemParametroList;
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
        if (!(object instanceof TparTipoParametro)) {
            return false;
        }
        TparTipoParametro other = (TparTipoParametro) object;
        if ((this.tparCodigo == null && other.tparCodigo != null) || (this.tparCodigo != null && !this.tparCodigo.equals(other.tparCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.TparTipoParametro[tparCodigo=" + tparCodigo + "]";
    }

}