package br.com.chapecosolucoes.trafegusweb.client.components.zoom.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.zoom.view.PGRZoom;
	import br.com.chapecosolucoes.trafegusweb.client.events.PGRSelecionadoEvent;
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
	import br.com.chapecosolucoes.trafegusweb.client.vo.PGRVO;
	import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
	
	import flash.events.MouseEvent;
	
	import mx.collections.XMLListCollection;
	import mx.controls.Alert;
	import mx.managers.PopUpManager;
	import mx.rpc.events.ResultEvent;
	
	import org.flexunit.runner.Result;
	
	import spark.components.PopUpAnchor;

	public class PGRZoomController
	{
		public function PGRZoomController()
		{
		}
		public var view:PGRZoom;
		public function pgrFilterFunction(item:Object):Boolean
		{
			return (String(PGRVO(item).codigo).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(PGRVO(item).dataCadastro).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0) ||
				(String(PGRVO(item).descricao).toUpperCase().search(MainModel.getInstance().zoomFilter.toUpperCase()) >= 0);
		}
		public function solicitaListaPGR():void
		{
			if(MainModel.getInstance().pgrArray.length == 0)
			{
				TrafegusWS.getIntance().solicitaListaPGR(solicitaListaPGRResultHandler);
			}
		}
		public function atualizaListaPGR():void
		{
			TrafegusWS.getIntance().solicitaListaPGR(solicitaListaPGRResultHandler);
		}
		private function solicitaListaPGRResultHandler(event:ResultEvent):void
		{
			var xml:XML = XML(event.result);
			var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
			var resultArray:Array = xmlListCollection.toArray();
			MainModel.getInstance().pgrArray.removeAll();
			for each (var obj:Object in resultArray)
			{
				var pgr:PGRVO = new PGRVO();
				pgr.setPGRVO(obj);
				MainModel.getInstance().pgrArray.addItem(pgr);
			}
		}
		public function pgrSelecionado():void
		{
			if(this.view.grid.selectedItem != null)
			{
				var pgrEvent:PGRSelecionadoEvent = new PGRSelecionadoEvent(PGRSelecionadoEvent.PGR_SELECIONADO_EVENT,PGRVO(this.view.grid.selectedItem));
				this.view.dispatchEvent(pgrEvent);
				this.closeHandler();
			}
			else
			{
				Alert.show("Nenhum PGR selecionado.");
			}
		}
		public function closeHandler():void
		{
			PopUpManager.removePopUp(this.view);
		}
	}
}