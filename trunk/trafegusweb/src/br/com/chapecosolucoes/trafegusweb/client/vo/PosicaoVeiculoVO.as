package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import com.google.maps.LatLng;

	public class PosicaoVeiculoVO
	{
		public function PosicaoVeiculoVO(obj:Object=null)
		{
			var gpsLatitudeString:String = obj.gpslatitude.toString().replace(",", ".");
			var gpsLongitudeString:String = obj.gpslongitude.toString().replace(",", ".");
			var gpsLatitude:Number = Number(gpsLatitudeString);
			var gpsLongitude:Number = Number(gpsLongitudeString);
			
			this.vehiclePlate = obj.vehicleplate.toString();
			this.latLong = new LatLng(gpsLatitude, gpsLongitude);
			this.gpsDescSis = obj.gpsdescsis;
			this.ignition = int(obj.ignition);
		}
		public var vehiclePlate:String;
		public var latLong:LatLng;
		public var gpsDescSis:String;
		public var ignition:int;
	}
}