/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author emerson
 */
@Entity
@Table(name = "tvei_tipo_veiculo")
@NamedQueries({
    @NamedQuery(name = "TveiTipoVeiculo.findAll", query = "SELECT t FROM TveiTipoVeiculo t")})
public class TveiTipoVeiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tvei_codigo")
    private Integer tveiCodigo;
    @Column(name = "tvei_descricao")
    private String tveiDescricao;
    @OneToMany(mappedBy = "tveiTipoVeiculo")
    private Set<VeicVeiculo> veicVeiculoSet;

    public TveiTipoVeiculo() {
    }

    public TveiTipoVeiculo(Integer tveiCodigo) {
        this.tveiCodigo = tveiCodigo;
    }

    public Integer getTveiCodigo() {
        return tveiCodigo;
    }

    public void setTveiCodigo(Integer tveiCodigo) {
        this.tveiCodigo = tveiCodigo;
    }

    public String getTveiDescricao() {
        return tveiDescricao;
    }

    public void setTveiDescricao(String tveiDescricao) {
        this.tveiDescricao = tveiDescricao;
    }

    public Set<VeicVeiculo> getVeicVeiculoSet() {
        return veicVeiculoSet;
    }

    public void setVeicVeiculoSet(Set<VeicVeiculo> veicVeiculoSet) {
        this.veicVeiculoSet = veicVeiculoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tveiCodigo != null ? tveiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TveiTipoVeiculo)) {
            return false;
        }
        TveiTipoVeiculo other = (TveiTipoVeiculo) object;
        if ((this.tveiCodigo == null && other.tveiCodigo != null) || (this.tveiCodigo != null && !this.tveiCodigo.equals(other.tveiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.TveiTipoVeiculo[tveiCodigo=" + tveiCodigo + "]";
    }

}
