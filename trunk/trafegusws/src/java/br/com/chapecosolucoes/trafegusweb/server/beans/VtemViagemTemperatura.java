/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author emerson
 */
@Entity
@Table(name = "vtem_viagem_temperatura")
@NamedQueries({
    @NamedQuery(name = "VtemViagemTemperatura.findAll", query = "SELECT v FROM VtemViagemTemperatura v")})
public class VtemViagemTemperatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "vtem_codigo")
    private Integer vtemCodigo;
    @Column(name = "vtem_valor_minimo")
    private Integer vtemValorMinimo;
    @Column(name = "vtem_valor_maximo")
    private Integer vtemValorMaximo;
    @Column(name = "vtem_ativo")
    private String vtemAtivo;
    @Column(name = "vtem_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vtemDataCadastro;
    @Column(name = "vtem_importado")
    private Character vtemImportado;
    @Column(name = "vtem_codigo_gr")
    private Integer vtemCodigoGr;
    @JoinColumn(name = "vtem_viag_codigo", referencedColumnName = "viag_codigo")
    @ManyToOne
    private ViagViagem viagViagem;

    public VtemViagemTemperatura() {
    }

    public VtemViagemTemperatura(Integer vtemCodigo) {
        this.vtemCodigo = vtemCodigo;
    }

    public Integer getVtemCodigo() {
        return vtemCodigo;
    }

    public void setVtemCodigo(Integer vtemCodigo) {
        this.vtemCodigo = vtemCodigo;
    }

    public Integer getVtemValorMinimo() {
        return vtemValorMinimo;
    }

    public void setVtemValorMinimo(Integer vtemValorMinimo) {
        this.vtemValorMinimo = vtemValorMinimo;
    }

    public Integer getVtemValorMaximo() {
        return vtemValorMaximo;
    }

    public void setVtemValorMaximo(Integer vtemValorMaximo) {
        this.vtemValorMaximo = vtemValorMaximo;
    }

    public String getVtemAtivo() {
        return vtemAtivo;
    }

    public void setVtemAtivo(String vtemAtivo) {
        this.vtemAtivo = vtemAtivo;
    }

    public Date getVtemDataCadastro() {
        return vtemDataCadastro;
    }

    public void setVtemDataCadastro(Date vtemDataCadastro) {
        this.vtemDataCadastro = vtemDataCadastro;
    }

    public Character getVtemImportado() {
        return vtemImportado;
    }

    public void setVtemImportado(Character vtemImportado) {
        this.vtemImportado = vtemImportado;
    }

    public Integer getVtemCodigoGr() {
        return vtemCodigoGr;
    }

    public void setVtemCodigoGr(Integer vtemCodigoGr) {
        this.vtemCodigoGr = vtemCodigoGr;
    }

    public ViagViagem getViagViagem() {
        return viagViagem;
    }

    public void setViagViagem(ViagViagem viagViagem) {
        this.viagViagem = viagViagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vtemCodigo != null ? vtemCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtemViagemTemperatura)) {
            return false;
        }
        VtemViagemTemperatura other = (VtemViagemTemperatura) object;
        if ((this.vtemCodigo == null && other.vtemCodigo != null) || (this.vtemCodigo != null && !this.vtemCodigo.equals(other.vtemCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.VtemViagemTemperatura[vtemCodigo=" + vtemCodigo + "]";
    }

}
