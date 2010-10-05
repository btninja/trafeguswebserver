/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author emerson
 */
@Entity
@Table(name = "mvei_marca_veiculo")
@NamedQueries({
    @NamedQuery(name = "MveiMarcaVeiculo.findAll", query = "SELECT m FROM MveiMarcaVeiculo m")})
public class MveiMarcaVeiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mvei_codigo")
    private Integer mveiCodigo;
    @Column(name = "mvei_descricao")
    private String mveiDescricao;
    @Column(name = "mvei_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mveiDataCadastro;
    @Column(name = "mvei_codigo_gr")
    private Integer mveiCodigoGr;
    @Column(name = "mvei_importado")
    private Character mveiImportado;
    @OneToMany(mappedBy = "mveiMarcaVeiculo")
    private Set<MvecModeloVeiculo> mvecModeloVeiculoSet;

    public MveiMarcaVeiculo() {
    }

    public MveiMarcaVeiculo(Integer mveiCodigo) {
        this.mveiCodigo = mveiCodigo;
    }

    public Integer getMveiCodigo() {
        return mveiCodigo;
    }

    public void setMveiCodigo(Integer mveiCodigo) {
        this.mveiCodigo = mveiCodigo;
    }

    public String getMveiDescricao() {
        return mveiDescricao;
    }

    public void setMveiDescricao(String mveiDescricao) {
        this.mveiDescricao = mveiDescricao;
    }

    public Date getMveiDataCadastro() {
        return mveiDataCadastro;
    }

    public void setMveiDataCadastro(Date mveiDataCadastro) {
        this.mveiDataCadastro = mveiDataCadastro;
    }

    public Integer getMveiCodigoGr() {
        return mveiCodigoGr;
    }

    public void setMveiCodigoGr(Integer mveiCodigoGr) {
        this.mveiCodigoGr = mveiCodigoGr;
    }

    public Character getMveiImportado() {
        return mveiImportado;
    }

    public void setMveiImportado(Character mveiImportado) {
        this.mveiImportado = mveiImportado;
    }

    public Set<MvecModeloVeiculo> getMvecModeloVeiculoSet() {
        return mvecModeloVeiculoSet;
    }

    public void setMvecModeloVeiculoSet(Set<MvecModeloVeiculo> mvecModeloVeiculoSet) {
        this.mvecModeloVeiculoSet = mvecModeloVeiculoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mveiCodigo != null ? mveiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MveiMarcaVeiculo)) {
            return false;
        }
        MveiMarcaVeiculo other = (MveiMarcaVeiculo) object;
        if ((this.mveiCodigo == null && other.mveiCodigo != null) || (this.mveiCodigo != null && !this.mveiCodigo.equals(other.mveiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.MveiMarcaVeiculo[mveiCodigo=" + mveiCodigo + "]";
    }

}
