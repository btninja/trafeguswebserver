/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "mvec_modelo_veiculo", catalog = "trafegus_transc", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"mvec_descricao"})})
@NamedQueries({
    @NamedQuery(name = "MvecModeloVeiculo.findAll", query = "SELECT m FROM MvecModeloVeiculo m"),
    @NamedQuery(name = "MvecModeloVeiculo.findByMvecCodigo", query = "SELECT m FROM MvecModeloVeiculo m WHERE m.mvecCodigo = :mvecCodigo"),
    @NamedQuery(name = "MvecModeloVeiculo.findByMvecDescricao", query = "SELECT m FROM MvecModeloVeiculo m WHERE m.mvecDescricao = :mvecDescricao"),
    @NamedQuery(name = "MvecModeloVeiculo.findByMvecDataCadastro", query = "SELECT m FROM MvecModeloVeiculo m WHERE m.mvecDataCadastro = :mvecDataCadastro"),
    @NamedQuery(name = "MvecModeloVeiculo.findByMvecCodigoGr", query = "SELECT m FROM MvecModeloVeiculo m WHERE m.mvecCodigoGr = :mvecCodigoGr"),
    @NamedQuery(name = "MvecModeloVeiculo.findByMvecImportado", query = "SELECT m FROM MvecModeloVeiculo m WHERE m.mvecImportado = :mvecImportado")})
public class MvecModeloVeiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mvec_codigo", nullable = false)
    private Integer mvecCodigo;
    @Column(name = "mvec_descricao", length = 50)
    private String mvecDescricao;
    @Column(name = "mvec_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mvecDataCadastro;
    @Column(name = "mvec_codigo_gr")
    private Integer mvecCodigoGr;
    @Column(name = "mvec_importado")
    private Character mvecImportado;
    @OneToMany(mappedBy = "mvecModeloVeiculo")
    private Collection<VeicVeiculo> veicVeiculoCollection;
    @JoinColumn(name = "mvec_mvei_codigo", referencedColumnName = "mvei_codigo")
    @ManyToOne
    private MveiMarcaVeiculo mveiMarcaVeiculo;

    public MvecModeloVeiculo() {
    }

    public MvecModeloVeiculo(Integer mvecCodigo) {
        this.mvecCodigo = mvecCodigo;
    }

    public Integer getMvecCodigo() {
        return mvecCodigo;
    }

    public void setMvecCodigo(Integer mvecCodigo) {
        this.mvecCodigo = mvecCodigo;
    }

    public String getMvecDescricao() {
        return mvecDescricao;
    }

    public void setMvecDescricao(String mvecDescricao) {
        this.mvecDescricao = mvecDescricao;
    }

    public Date getMvecDataCadastro() {
        return mvecDataCadastro;
    }

    public void setMvecDataCadastro(Date mvecDataCadastro) {
        this.mvecDataCadastro = mvecDataCadastro;
    }

    public Integer getMvecCodigoGr() {
        return mvecCodigoGr;
    }

    public void setMvecCodigoGr(Integer mvecCodigoGr) {
        this.mvecCodigoGr = mvecCodigoGr;
    }

    public Character getMvecImportado() {
        return mvecImportado;
    }

    public void setMvecImportado(Character mvecImportado) {
        this.mvecImportado = mvecImportado;
    }

    public Collection<VeicVeiculo> getVeicVeiculoCollection() {
        return veicVeiculoCollection;
    }

    public void setVeicVeiculoCollection(Collection<VeicVeiculo> veicVeiculoCollection) {
        this.veicVeiculoCollection = veicVeiculoCollection;
    }

    public MveiMarcaVeiculo getMveiMarcaVeiculo() {
        return mveiMarcaVeiculo;
    }

    public void setMveiMarcaVeiculo(MveiMarcaVeiculo mveiMarcaVeiculo) {
        this.mveiMarcaVeiculo = mveiMarcaVeiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mvecCodigo != null ? mvecCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MvecModeloVeiculo)) {
            return false;
        }
        MvecModeloVeiculo other = (MvecModeloVeiculo) object;
        if ((this.mvecCodigo == null && other.mvecCodigo != null) || (this.mvecCodigo != null && !this.mvecCodigo.equals(other.mvecCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.MvecModeloVeiculo[mvecCodigo=" + mvecCodigo + "]";
    }

}
