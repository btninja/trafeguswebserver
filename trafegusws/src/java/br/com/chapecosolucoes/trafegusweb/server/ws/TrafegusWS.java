/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chapecosolucoes.trafegusweb.server.ws;

import br.com.chapecosolucoes.trafegusweb.server.beans.CrefClasseReferencia;
import br.com.chapecosolucoes.trafegusweb.server.beans.MotoMotorista;
import br.com.chapecosolucoes.trafegusweb.server.beans.RotaRota;
import br.com.chapecosolucoes.trafegusweb.server.beans.TranTransportador;
import br.com.chapecosolucoes.trafegusweb.server.beans.UsuaUsuario;
import br.com.chapecosolucoes.trafegusweb.server.beans.VeicVeiculo;
import br.com.chapecosolucoes.trafegusweb.server.jpa.JPAUtil;
import br.com.chapecosolucoes.trafegusweb.server.vo.SolicitaAcessoVO;
import br.com.chapecosolucoes.trafegusweb.server.vo.SolicitaListaVeiculosVO;
import br.com.chapecosolucoes.trafegusweb.server.xml.XMLUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Emerson
 */
@WebService()
public class TrafegusWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaAcesso")
    public String solicitaAcesso(@WebParam(name = "usuario") String usuario, @WebParam(name = "senha") String senha) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT u FROM UsuaUsuario u WHERE u.usuaLogin = :usuaLogin AND u.usuaSenha = :usuaSenha");
        q.setParameter("usuaLogin", usuario);
        q.setParameter("usuaSenha", senha);
        UsuaUsuario usuaUsuario = null;

        try {
            usuaUsuario = (UsuaUsuario) q.getSingleResult();
        } catch (Exception e) {
            usuaUsuario = new UsuaUsuario();
        }

        SolicitaAcessoVO solicitaAcessoVO = new SolicitaAcessoVO();
        solicitaAcessoVO.setCodigo(usuaUsuario.getUsuaPfisPessOrasCodigo());
        solicitaAcessoVO.setLogin(usuaUsuario.getUsuaLogin());
        solicitaAcessoVO.setNome(usuaUsuario.getPessPessoa().getPessNome());
        solicitaAcessoVO.setCodPessoa(usuaUsuario.getPessPessoa().getPessOrasCodigo());

        String result = XMLUtil.getIntance().toXML("SolicitaAcesso", solicitaAcessoVO);

        usuaUsuario = null;
        solicitaAcessoVO = null;

        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaClassesReferencias")
    public String solicitaClassesReferencias(@WebParam(name = "codEmrpesa") String codEmrpesa) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT c FROM CrefClasseReferencia c WHERE c.pessPessoa.pessOrasCodigo = :pessOrasCodigo");
        q.setParameter("pessOrasCodigo", codEmrpesa);

        ArrayList<CrefClasseReferencia> result = null;
        try {
            result = (ArrayList<CrefClasseReferencia>) q.getResultList();
        } catch (Exception e) {
            result = new ArrayList<CrefClasseReferencia>();
        }
        return XMLUtil.getIntance().toXML(result);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosMotorista")
    public String solicitaDadosMotorista(@WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "cpfMotorista") String cpfMotorista) {
        MotoMotorista result = null;
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT m FROM MotoMotorista m WHERE m.pfisPessoaFisica.pfisCpf = :cpfMotorista");
        q.setParameter("cpfMotorista", cpfMotorista);
        try {
            result = (MotoMotorista) q.getSingleResult();
        } catch (Exception e) {
            result = new MotoMotorista();
        }
        em.getTransaction().commit();
        return XMLUtil.getIntance().toXML(result);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaRefencias")
    public String solicitaRefencias(@WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "codClasseReferencia") Integer codClasseReferencia) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT c FROM CrefClasseReferencia c ");
        sb.append(" WHERE ");
        sb.append(" (c.crefCodigo = :crefCodigo)");

        Query q = em.createQuery(sb.toString());
        q.setParameter("crefCodigo", codClasseReferencia);

        ArrayList<CrefClasseReferencia> result = null;
        try {
            result = (ArrayList<CrefClasseReferencia>) q.getResultList();
        } catch (Exception e) {
            result = new ArrayList<CrefClasseReferencia>();
        }
        return XMLUtil.getIntance().toXML(result);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosVeiculo")
    public String solicitaDadosVeiculo(@WebParam(name = "codEmpresa") String codEmpresa, @WebParam(name = "placaVeiculo") String placaVeiculo) {
        VeicVeiculo result = null;
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT v FROM VeicVeiculo v WHERE v.veicPlaca = :veicPlaca");
        q.setParameter("veicPlaca", placaVeiculo);
        try {
            result = (VeicVeiculo) q.getSingleResult();
        } catch (Exception e) {
            result = new VeicVeiculo();
        }
        em.getTransaction().commit();
        return XMLUtil.getIntance().toXML(result);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosTransportador")
    public String solicitaDadosTransportador(@WebParam(name = "codTransportador") String codTransportador) {
        TranTransportador result = null;
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT t FROM TranTransportador t WHERE t.tranPessOrasCodigo = :tranPessOrasCodigo");
        q.setParameter("tranPessOrasCodigo", codTransportador);
        try {
            result = (TranTransportador) q.getSingleResult();
        } catch (Exception e) {
            result = new TranTransportador();
        }
        em.getTransaction().commit();
        return XMLUtil.getIntance().toXML(result);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaDadosRota")
    public String solicitaDadosRota(@WebParam(name = "codEmpresa") Integer codEmpresa, @WebParam(name = "codRota") Integer codRota) {
        RotaRota result = null;
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Query q = em.createQuery("SELECT r FROM RotaRota r WHERE r.rotaCodigo = :rotaCodigo");
        q.setParameter("rotaCodigo", codRota);

        try {
            result = (RotaRota) q.getSingleResult();
        } catch (Exception e) {
            result = new RotaRota();
        }
        em.getTransaction().commit();
        return XMLUtil.getIntance().toXML(result);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "solicitaListaVeiculos")
    public String solicitaListaVeiculos(@WebParam(name = "codEmpresa") Integer codEmpresa) {
        //TODO write your implementation code here:
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        StringBuilder sb = new StringBuilder();

        sb.append(" SELECT ORAS_OBJETO_RASTREADO.ORAS_CODIGO,");
        sb.append("       VEIC_VEICULO.VEIC_PLACA,");
        sb.append("       TVEI_TIPO_VEICULO.TVEI_DESCRICAO");
        sb.append(" FROM VEIC_VEICULO");
        sb.append("     JOIN ORAS_OBJETO_RASTREADO ON (ORAS_CODIGO = VEIC_ORAS_CODIGO AND");
        sb.append("     ORAS_EOBJ_CODIGO = 1)");
        sb.append("     JOIN TVEI_TIPO_VEICULO ON (VEIC_TVEI_CODIGO = TVEI_CODIGO)");
        sb.append("     JOIN VTRA_VEICULO_TRANSPORTADOR ON (VTRA_VEIC_ORAS_CODIGO = VEIC_ORAS_CODIGO)");
        sb.append("     JOIN TRAN_TRANSPORTADOR ON (TRAN_PESS_ORAS_CODIGO = VTRA_TRAN_PESS_ORAS_CODIGO AND TRAN_PESS_ORAS_CODIGO = ?)");
        sb.append("     LEFT JOIN VCAR_VEICULO_CARRETA ON (VEIC_ORAS_CODIGO = VCAR_VEIC_ORAS_CODIGO)");
        sb.append("     LEFT JOIN VCAV_VEICULO_CAVALO ON (VEIC_ORAS_CODIGO = VCAV_VEIC_ORAS_CODIGO)");
        sb.append("     LEFT JOIN VMOT_VEICULO_MOTO ON (VEIC_ORAS_CODIGO = VMOT_VEIC_ORAS_CODIGO)");
        sb.append("     LEFT JOIN VTRU_VEICULO_TRUCK ON (VEIC_ORAS_CODIGO = VTRU_VEIC_ORAS_CODIGO)");
        sb.append("     LEFT JOIN VUCA_VEICULO_UTILITARIO_CARGA ON (VEIC_ORAS_CODIGO = VUCA_VEIC_ORAS_CODIGO)");
        sb.append("     LEFT JOIN VUPA_VEICULO_UTILITARIO_PASSE ON (VEIC_ORAS_CODIGO = VUPA_VEIC_ORAS_CODIGO)");
        sb.append(" ORDER BY VEIC_VEICULO.VEIC_PLACA ");

        Query q = em.createNativeQuery(sb.toString(), "selectVeiculos");
        q.setParameter(1, codEmpresa);
        ArrayList<SolicitaListaVeiculosVO> l = (ArrayList<SolicitaListaVeiculosVO>) q.getResultList();
        return XMLUtil.getIntance().toXML(l);

    }
}
