package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import com.google.maps.LatLng;
	[Bindable]
	public class PosicaoVeiculoVO
	{
		public function PosicaoVeiculoVO(obj:Object=null)
		{
			if(obj!=null)
			{
				var gpsLatitudeString:String = obj.upos_latitude.toString().replace(",", ".");
				var gpsLongitudeString:String = obj.upos_longitude.toString().replace(",", ".");
				var gpsLatitude:Number = Number(gpsLatitudeString);
				var gpsLongitude:Number = Number(gpsLongitudeString);
				
				this.codVeic = obj.veic_oras_codigo.toString();
				this.vehiclePlate = obj.veic_placa.toString();
				this.latLong = new LatLng(gpsLatitude, gpsLongitude);
				this.gpsDescSis = obj.posicao;
				this.ignition = int(obj.ignicao);
				this.versaoTecnologia = obj.versaotecnologia.toString();
				this.numeroTerminal = obj.numeroterminal.toString();
				this.tipoVeiculo = obj.tipoveiculo.toString();
				this.statusViagem = obj.statusviagem.toString();
				this.statusAtraso = obj.statusatraso.toString();
				this.codigoMotoristaPrincipal = obj.codigo_motorista.toString();
				this.motoristaPrincipal = obj.nome_motorista.toString();
				this.cpfMotoristaPrincipal = obj.cpf_motorista.toString();
				this.embarcador = obj.embarcador.toString();
				this.dataEHora = obj.upos_data_comp_bordo.toString();
			}
		}
		public function setPosicaoVeiculoVO(obj:Object):void
		{
			var gpsLatitudeString:String = obj.upos_latitude.toString().replace(",", ".");
			var gpsLongitudeString:String = obj.upos_longitude.toString().replace(",", ".");
			var gpsLatitude:Number = Number(gpsLatitudeString);
			var gpsLongitude:Number = Number(gpsLongitudeString);
			
			this.codVeic = obj.veic_oras_codigo.toString();
			this.vehiclePlate = obj.placa.toString();
			this.latLong = new LatLng(gpsLatitude, gpsLongitude);
			this.gpsDescSis = obj.posicao;
			this.ignition = int(obj.ignicao);
			this.versaoTecnologia = obj.versaotecnologia.toString();
			this.numeroTerminal = obj.numeroterminal.toString();
			this.tipoVeiculo = obj.tipoveiculo.toString();
			this.statusViagem = obj.statusviagem.toString();
			this.statusAtraso = obj.statusatraso.toString();
			this.codigoMotoristaPrincipal = obj.codigo_motorista.toString();
			this.motoristaPrincipal = obj.nome_motorista.toString();
			this.cpfMotoristaPrincipal = obj.cpf_motorista.toString();
			this.embarcador = obj.embarcador.toString();
			this.dataEHora = obj.upos_data_comp_bordo.toString();
		}
		public var codVeic:String;
		public var vehiclePlate:String;
		public var latLong:LatLng;
		public var gpsDescSis:String;
		public var ignition:int;
		public var versaoTecnologia:String;
		public var numeroTerminal:String;
		public var tipoVeiculo:String;
		public var statusViagem:String;
		public var statusAtraso:String;
		public var codigoMotoristaPrincipal:String;
		public var motoristaPrincipal:String;
		public var cpfMotoristaPrincipal:String;
		public var embarcador:String;
		public var dataEHora:String;
	}
}