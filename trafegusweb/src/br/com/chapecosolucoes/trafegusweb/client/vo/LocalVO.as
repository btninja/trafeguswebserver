package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import br.com.chapecosolucoes.trafegusweb.client.enum.LocaisEnum;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.utils.MyDateFormatter;
	
	import com.google.maps.LatLng;
	
	import mx.utils.ObjectUtil;

	[Bindable]
	public class LocalVO
	{
		public function LocalVO()
		{
		}
		public function setLocalVO(obj:Object):void
		{
			this.codigo = obj.refe_codigo.toString();
			this._vlocCodigo = obj.vloc_codigo.toString();
			this.vlocSequencia = obj.vloc_sequencia.toString();
			this.vlocTparCodigo = obj.vloc_tpar_codigo.toString();
			this._vlocRaio = obj.vloc_raio.toString();
			this._vlocDataCadastro = obj.vloc_data_cadastro.toString();
			this._vlocUsuarioAdicionou = obj.vloc_usuario_adicionou.toString();
			//this.vlocUsuarioAlterou = obj.vloc_usuario_alterou.toString();
			this.descricao = obj.refe_descricao.toString();
			gpsLatitudeString = obj.refe_latitude.toString().replace(",", ".");
			gpsLongitudeString = obj.refe_longitude.toString().replace(",", ".");
			var gpsLatitude:Number = Number(gpsLatitudeString);
			var gpsLongitude:Number = Number(gpsLongitudeString);
			this.latLong = new LatLng(gpsLatitude, gpsLongitude);
			this.codigoGrupo = obj.cref_codigo.toString();
			this.descricaoGrupo = obj.cref_descricao.toString();
		}
		public function set vlocSequencia(vlocSequencia:String):void
		{
			this._vlocSequencia = vlocSequencia;
		}
		public function get vlocSequencia():String
		{
			if(vlocTparCodigo != null && vlocTparCodigo == LocaisEnum.ORIGEM.toString())
			{
				return "1";
			}
			else if(vlocTparCodigo != null && vlocTparCodigo == LocaisEnum.DESTINO.toString())
			{
				return ObjectUtil.toString(MainModel.getInstance().smVO.paradas.length+1);
			}
			return "-1";
		}
		public function set vlocRaio(vlocRaio:String):void
		{
			this._vlocRaio = vlocRaio;
		}
		public function get vlocRaio():String
		{
			return this._vlocRaio==""?"NULL":this._vlocRaio;
		}
		public function set vlocCodigo(vlocCodigo:String):void
		{
			this._vlocCodigo = vlocCodigo;
		}
		public function get vlocCodigo():String
		{
			return this._vlocCodigo==""?"nextval('s_vloc_viagem_local')":this._vlocCodigo;
		}
		public function get vlocDescricao():String
		{
			return "'"+this.descricao+"'";
		}
		public function set vlocDataCadastro(vlocDataCadastro:String):void
		{
			this._vlocDataCadastro = vlocDataCadastro;
		}
		public function get vlocDataCadastro():String
		{
			return "'"+(this._vlocDataCadastro==""?MyDateFormatter.getInstance().parse(new Date()):this._vlocDataCadastro)+"'";
		}
		public function set vlocUsuarioAdicionou(vlocUsuarioAdicionou:String):void
	    {
			this._vlocUsuarioAdicionou = vlocUsuarioAdicionou;									 
    	}
		public function get vlocUsuarioAdicionou():String
		{
			return "'"+(this._vlocUsuarioAdicionou==""?ObjectUtil.toString(MainModel.getInstance().codUsuario):this._vlocUsuarioAdicionou)+"'";
		}
		public function get vlocUsuarioAlterou():String
		{
			return "'"+ObjectUtil.toString(MainModel.getInstance().codUsuario)+"'";
		}
		public function set vlocTparCodigo(vlocTparCodigo:String):void
		{
			this._vlocTparCodigo = vlocTparCodigo;
		}
		public function get vlocTparCodigo():String
		{
			return this._vlocTparCodigo==""?"NULL":this._vlocTparCodigo;
		}
		public var codigo:String;
		public var descricao:String;
		public var latLong:LatLng;
		public var codigoGrupo:String;
		public var descricaoGrupo:String;
		public var gpsLatitudeString:String;
		public var gpsLongitudeString:String;
		private var _vlocSequencia:String;
		private var _vlocTparCodigo:String;
		private var _vlocRaio:String = "";
		private var _vlocCodigo:String;
		private var _vlocDataCadastro:String = "";
		private var _vlocUsuarioAdicionou:String = "";
		private var _vlocUsuarioAlterou:String = "";
	}
}