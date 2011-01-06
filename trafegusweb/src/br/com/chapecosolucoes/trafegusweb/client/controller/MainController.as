package br.com.chapecosolucoes.trafegusweb.client.controller
{
    import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
    import br.com.chapecosolucoes.trafegusweb.client.enum.VehicleEnum;
    import br.com.chapecosolucoes.trafegusweb.client.events.CloseAppEvent;
    import br.com.chapecosolucoes.trafegusweb.client.events.DetailsEvent;
    import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;
    import br.com.chapecosolucoes.trafegusweb.client.events.ReferenciasRecebidasEvent;
    import br.com.chapecosolucoes.trafegusweb.client.events.VehiclesEvent;
    import br.com.chapecosolucoes.trafegusweb.client.events.VehiclesHistoricEvent;
    import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
    import br.com.chapecosolucoes.trafegusweb.client.model.UsuarioLogado;
    import br.com.chapecosolucoes.trafegusweb.client.view.ClassesReferenciaView;
    import br.com.chapecosolucoes.trafegusweb.client.view.MainView;
    import br.com.chapecosolucoes.trafegusweb.client.view.MainView2;
    import br.com.chapecosolucoes.trafegusweb.client.view.MonitoringRequestWiew;
    import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
    import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
    
    import com.google.maps.LatLng;
    
    import flash.display.DisplayObject;
    
    import mx.controls.Alert;
    import mx.core.FlexGlobals;
    import mx.events.CloseEvent;
    import mx.events.MenuEvent;
    import mx.managers.PopUpManager;
    import mx.rpc.events.ResultEvent;
    import mx.utils.ObjectUtil;

    public class MainController
    {
        public function MainController()
        {
        }

        public var view:MainView2;

        public function vehiclesReceivedEventHandler(event:VehiclesEvent):void
        {
            this.view.map.posicaoVeiculosArray(MainModel.getInstance().posVeiculosArray);
        }

        public function vehicleSelectedEventHandler(event:VehiclesEvent):void
        {
            this.view.map.posicaoVeiculoVO();
            this.view.details.posicaoVeiculoVO();
            if (event.enum == VehicleEnum.LIST)
            {
                this.view.details.selectedIndex = event.index;
            }
            else if (event.enum == VehicleEnum.DETAILS)
            {
                this.view.vehiclesView.selectedIndex = event.index;
            }
        }

        public function routeReceivedEventHandler(event:VehiclesHistoricEvent):void
        {
            this.view.map.rotaVeiculo(MainModel.getInstance().historicoPosicoesVeiculosArray);
        }

        public function closeApp(event:CloseEvent):void
        {
            if (event.detail == Alert.OK)
            {
                var closeEvent:CloseAppEvent = new CloseAppEvent(CloseAppEvent.CLOSE_APP_EVENT);
                this.view.dispatchEvent(closeEvent);
				MainModel.getInstance().cleanUp();
				UsuarioLogado.getInstance().cleanUp();
            }
        }

        public function closeEventHandler(event:CloseEvent):void
        {
            if (event.target.id.toString() == "veiculos")
            {
                this.view.veiculos.visible = !this.view.veiculos.visible;
                this.view.myMenuBar.menuBarItems[1].data.menuitem[0].@toggled = "false";
            }
            if (event.target.id.toString() == "mapa")
            {
                this.view.mapa.visible = !this.view.mapa.visible;
                this.view.myMenuBar.menuBarItems[1].data.menuitem[2].@toggled = "false";
            }
            if (event.target.id.toString() == "detalhes")
            {
                this.view.detalhes.visible = !this.view.detalhes.visible;
                this.view.myMenuBar.menuBarItems[1].data.menuitem[1].@toggled = "false";
            }
        }

        public function itemClickedHandler(event:MenuEvent):void
        {
            if (event.label == "Veiculos")
            {
                this.view.veiculos.visible = !this.view.veiculos.visible;
            }
            if (event.label == "Mapa")
            {
                this.view.mapa.visible = !this.view.mapa.visible;
            }
            if (event.label == "Detalhes")
            {
                this.view.detalhes.visible = !this.view.detalhes.visible;
            }
            if (event.label == "Salvar")
            {
                UsuarioLogado.getInstance().posicaoTelasVO.gridVeiculosX = this.view.veiculos.x;
                UsuarioLogado.getInstance().posicaoTelasVO.gridVeiculosY = this.view.veiculos.y;
                UsuarioLogado.getInstance().posicaoTelasVO.gridVeiculosPercentWidth = (100 * this.view.veiculos.width)/FlexGlobals.topLevelApplication.width;
                UsuarioLogado.getInstance().posicaoTelasVO.gridVeiculosPercentHeight = (100 * this.view.veiculos.height)/FlexGlobals.topLevelApplication.height;
                UsuarioLogado.getInstance().posicaoTelasVO.mapaGoogleX = this.view.mapa.x;
                UsuarioLogado.getInstance().posicaoTelasVO.mapaGoogleY = this.view.mapa.y;
                UsuarioLogado.getInstance().posicaoTelasVO.mapaGooglePercentWidth = (100 * this.view.mapa.width)/FlexGlobals.topLevelApplication.width;
                UsuarioLogado.getInstance().posicaoTelasVO.mapaGooglePercentHeight = (100 * this.view.mapa.height)/FlexGlobals.topLevelApplication.width;;
                UsuarioLogado.getInstance().posicaoTelasVO.gridDetalheX = this.view.detalhes.x;
                UsuarioLogado.getInstance().posicaoTelasVO.gridDetalheY = this.view.detalhes.y;
                UsuarioLogado.getInstance().posicaoTelasVO.gridDetalhePercentWidth = (100 * this.view.detalhes.width)/FlexGlobals.topLevelApplication.width;;
                UsuarioLogado.getInstance().posicaoTelasVO.gridDetalhePercentHeight = (100 * this.view.detalhes.height)/FlexGlobals.topLevelApplication.width;

                TrafegusWS.getIntance().salvarPosicaoTelas(salvarPosicaoTelasResultHandler);
            }
            if (event.label == "Sair")
            {
                MessageBox.atencao("Deseja sair da aplicação","",Alert.OK | Alert.CANCEL,this.view,this.closeApp);
                //Alert.show("Deseja sair da aplicação","Sair",Alert.OK | Alert.CANCEL,this.view,this.closeApp);
            }
            if (event.label == "Agendamento")
            {
                var monitoringRequest:MonitoringRequestWiew = new MonitoringRequestWiew();
                PopUpManager.addPopUp(monitoringRequest, DisplayObject(FlexGlobals.topLevelApplication));
                PopUpManager.centerPopUp(monitoringRequest);
            }
            if (event.label == "Referências")
            {
                var referencias:ClassesReferenciaView = new ClassesReferenciaView();
				referencias.addEventListener(ReferenciasRecebidasEvent.REFERENCIAS_RECEBIDAS_EVENT,referenciasRecebidasResultHandler);
                PopUpManager.addPopUp(referencias, DisplayObject(FlexGlobals.topLevelApplication));
                PopUpManager.centerPopUp(referencias);
            }
        }
		
		private function referenciasRecebidasResultHandler(event:ReferenciasRecebidasEvent):void
		{
			this.view.map.carregarReferencias();
		}

        public function pageChangedEventHandler(event:PaginableEvent):void
        {
            if (event.currentTarget == this.view.vehiclesView)
            {
                this.view.details.paginaAtual = event.paginaAtual;
            }
            else
            {
                this.view.vehiclesView.paginaAtual = event.paginaAtual;
            }
        }

        private function salvarPosicaoTelasResultHandler(event:ResultEvent):void
        {
            MessageBox.informacao("As posições atuais, foram salvas");
        }
    }
}