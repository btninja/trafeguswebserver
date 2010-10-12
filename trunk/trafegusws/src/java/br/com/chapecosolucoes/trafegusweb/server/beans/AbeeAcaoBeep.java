/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "abee_acao_beep")
@NamedQueries({
    @NamedQuery(name = "AbeeAcaoBeep.findAll", query = "SELECT a FROM AbeeAcaoBeep a"),
    @NamedQuery(name = "AbeeAcaoBeep.findByAbeeApadCodigo", query = "SELECT a FROM AbeeAcaoBeep a WHERE a.abeeApadCodigo = :abeeApadCodigo"),
    @NamedQuery(name = "AbeeAcaoBeep.findByAbbeFrequencia", query = "SELECT a FROM AbeeAcaoBeep a WHERE a.abbeFrequencia = :abbeFrequencia"),
    @NamedQuery(name = "AbeeAcaoBeep.findByAbeeTempoBeep", query = "SELECT a FROM AbeeAcaoBeep a WHERE a.abeeTempoBeep = :abeeTempoBeep"),
    @NamedQuery(name = "AbeeAcaoBeep.findByAbeeTempoEsperando", query = "SELECT a FROM AbeeAcaoBeep a WHERE a.abeeTempoEsperando = :abeeTempoEsperando")})
public class AbeeAcaoBeep implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "abee_apad_codigo")
    private Integer abeeApadCodigo;
    @Column(name = "abbe_frequencia")
    private Integer abbeFrequencia;
    @Column(name = "abee_tempo_beep")
    private Integer abeeTempoBeep;
    @Column(name = "abee_tempo_esperando")
    private Integer abeeTempoEsperando;
    @JoinColumn(name = "abee_apad_codigo", referencedColumnName = "apad_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private ApadAcaoPadrao apadAcaoPadrao;

    public AbeeAcaoBeep() {
    }

    public AbeeAcaoBeep(Integer abeeApadCodigo) {
        this.abeeApadCodigo = abeeApadCodigo;
    }

    public Integer getAbeeApadCodigo() {
        return abeeApadCodigo;
    }

    public void setAbeeApadCodigo(Integer abeeApadCodigo) {
        this.abeeApadCodigo = abeeApadCodigo;
    }

    public Integer getAbbeFrequencia() {
        return abbeFrequencia;
    }

    public void setAbbeFrequencia(Integer abbeFrequencia) {
        this.abbeFrequencia = abbeFrequencia;
    }

    public Integer getAbeeTempoBeep() {
        return abeeTempoBeep;
    }

    public void setAbeeTempoBeep(Integer abeeTempoBeep) {
        this.abeeTempoBeep = abeeTempoBeep;
    }

    public Integer getAbeeTempoEsperando() {
        return abeeTempoEsperando;
    }

    public void setAbeeTempoEsperando(Integer abeeTempoEsperando) {
        this.abeeTempoEsperando = abeeTempoEsperando;
    }

    public ApadAcaoPadrao getApadAcaoPadrao() {
        return apadAcaoPadrao;
    }

    public void setApadAcaoPadrao(ApadAcaoPadrao apadAcaoPadrao) {
        this.apadAcaoPadrao = apadAcaoPadrao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (abeeApadCodigo != null ? abeeApadCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AbeeAcaoBeep)) {
            return false;
        }
        AbeeAcaoBeep other = (AbeeAcaoBeep) object;
        if ((this.abeeApadCodigo == null && other.abeeApadCodigo != null) || (this.abeeApadCodigo != null && !this.abeeApadCodigo.equals(other.abeeApadCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.AbeeAcaoBeep[abeeApadCodigo=" + abeeApadCodigo + "]";
    }

}