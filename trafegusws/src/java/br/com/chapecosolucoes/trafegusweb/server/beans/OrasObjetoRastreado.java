/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.chapecosolucoes.trafegusweb.server.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emerson
 */
@Entity
@Table(name = "oras_objeto_rastreado")
@NamedQueries({
    @NamedQuery(name = "OrasObjetoRastreado.findAll", query = "SELECT o FROM OrasObjetoRastreado o"),
    @NamedQuery(name = "OrasObjetoRastreado.findByOrasCodigo", query = "SELECT o FROM OrasObjetoRastreado o WHERE o.orasCodigo = :orasCodigo"),
    @NamedQuery(name = "OrasObjetoRastreado.findByOrasDataCadastro", query = "SELECT o FROM OrasObjetoRastreado o WHERE o.orasDataCadastro = :orasDataCadastro"),
    @NamedQuery(name = "OrasObjetoRastreado.findByOrasCodigoGr", query = "SELECT o FROM OrasObjetoRastreado o WHERE o.orasCodigoGr = :orasCodigoGr"),
    @NamedQuery(name = "OrasObjetoRastreado.findByOrasImportado", query = "SELECT o FROM OrasObjetoRastreado o WHERE o.orasImportado = :orasImportado")})
public class OrasObjetoRastreado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "oras_codigo")
    private Integer orasCodigo;
    @Column(name = "oras_data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orasDataCadastro;
    @Column(name = "oras_codigo_gr")
    private Integer orasCodigoGr;
    @Column(name = "oras_importado")
    private Character orasImportado;
    @OneToMany(mappedBy = "orasObjetoRastreado", fetch = FetchType.EAGER)
    private List<TermTerminal> termTerminalList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orasObjetoRastreado", fetch = FetchType.EAGER)
    private VeicVeiculo veicVeiculo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orasObjetoRastreado", fetch = FetchType.EAGER)
    private PessPessoa pessPessoa;
    @OneToMany(mappedBy = "orasObjetoRastreado", fetch = FetchType.EAGER)
    private List<HtpgHistoricoTrocaPg> htpgHistoricoTrocaPgList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orasObjetoRastreado", fetch = FetchType.EAGER)
    private ContContainer contContainer;
    @JoinColumn(name = "oras_pgpg_codigo", referencedColumnName = "pgpg_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private PgpgPg pgpgPg;
    @JoinColumn(name = "oras_eobj_codigo", referencedColumnName = "eobj_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private EobjEstatusObjeto eobjEstatusObjeto;
    @OneToMany(mappedBy = "orasObjetoRastreado", fetch = FetchType.EAGER)
    private List<OrobObjetoRastreadoObs> orobObjetoRastreadoObsList;
    @OneToMany(mappedBy = "orasObjetoRastreado", fetch = FetchType.EAGER)
    private List<OrteObjetoRastreadoTermina> orteObjetoRastreadoTerminaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orasObjetoRastreado", fetch = FetchType.EAGER)
    private MaloMalote maloMalote;

    public OrasObjetoRastreado() {
    }

    public OrasObjetoRastreado(Integer orasCodigo) {
        this.orasCodigo = orasCodigo;
    }

    public Integer getOrasCodigo() {
        return orasCodigo;
    }

    public void setOrasCodigo(Integer orasCodigo) {
        this.orasCodigo = orasCodigo;
    }

    public Date getOrasDataCadastro() {
        return orasDataCadastro;
    }

    public void setOrasDataCadastro(Date orasDataCadastro) {
        this.orasDataCadastro = orasDataCadastro;
    }

    public Integer getOrasCodigoGr() {
        return orasCodigoGr;
    }

    public void setOrasCodigoGr(Integer orasCodigoGr) {
        this.orasCodigoGr = orasCodigoGr;
    }

    public Character getOrasImportado() {
        return orasImportado;
    }

    public void setOrasImportado(Character orasImportado) {
        this.orasImportado = orasImportado;
    }

    public List<TermTerminal> getTermTerminalList() {
        return termTerminalList;
    }

    public void setTermTerminalList(List<TermTerminal> termTerminalList) {
        this.termTerminalList = termTerminalList;
    }

    public VeicVeiculo getVeicVeiculo() {
        return veicVeiculo;
    }

    public void setVeicVeiculo(VeicVeiculo veicVeiculo) {
        this.veicVeiculo = veicVeiculo;
    }

    public PessPessoa getPessPessoa() {
        return pessPessoa;
    }

    public void setPessPessoa(PessPessoa pessPessoa) {
        this.pessPessoa = pessPessoa;
    }

    public List<HtpgHistoricoTrocaPg> getHtpgHistoricoTrocaPgList() {
        return htpgHistoricoTrocaPgList;
    }

    public void setHtpgHistoricoTrocaPgList(List<HtpgHistoricoTrocaPg> htpgHistoricoTrocaPgList) {
        this.htpgHistoricoTrocaPgList = htpgHistoricoTrocaPgList;
    }

    public ContContainer getContContainer() {
        return contContainer;
    }

    public void setContContainer(ContContainer contContainer) {
        this.contContainer = contContainer;
    }

    public PgpgPg getPgpgPg() {
        return pgpgPg;
    }

    public void setPgpgPg(PgpgPg pgpgPg) {
        this.pgpgPg = pgpgPg;
    }

    public EobjEstatusObjeto getEobjEstatusObjeto() {
        return eobjEstatusObjeto;
    }

    public void setEobjEstatusObjeto(EobjEstatusObjeto eobjEstatusObjeto) {
        this.eobjEstatusObjeto = eobjEstatusObjeto;
    }

    public List<OrobObjetoRastreadoObs> getOrobObjetoRastreadoObsList() {
        return orobObjetoRastreadoObsList;
    }

    public void setOrobObjetoRastreadoObsList(List<OrobObjetoRastreadoObs> orobObjetoRastreadoObsList) {
        this.orobObjetoRastreadoObsList = orobObjetoRastreadoObsList;
    }

    public List<OrteObjetoRastreadoTermina> getOrteObjetoRastreadoTerminaList() {
        return orteObjetoRastreadoTerminaList;
    }

    public void setOrteObjetoRastreadoTerminaList(List<OrteObjetoRastreadoTermina> orteObjetoRastreadoTerminaList) {
        this.orteObjetoRastreadoTerminaList = orteObjetoRastreadoTerminaList;
    }

    public MaloMalote getMaloMalote() {
        return maloMalote;
    }

    public void setMaloMalote(MaloMalote maloMalote) {
        this.maloMalote = maloMalote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orasCodigo != null ? orasCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrasObjetoRastreado)) {
            return false;
        }
        OrasObjetoRastreado other = (OrasObjetoRastreado) object;
        if ((this.orasCodigo == null && other.orasCodigo != null) || (this.orasCodigo != null && !this.orasCodigo.equals(other.orasCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.chapecosolucoes.trafegusweb.server.beans.OrasObjetoRastreado[orasCodigo=" + orasCodigo + "]";
    }

}