package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
    import br.com.chapecosolucoes.trafegusweb.client.components.messagebox.MessageBox;
    import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.LoginComponent;
    import br.com.chapecosolucoes.trafegusweb.client.events.LoginEvent;
    import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;
    import br.com.chapecosolucoes.trafegusweb.client.model.UsuarioLogado;
    import br.com.chapecosolucoes.trafegusweb.client.utils.ParserResult;
    import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoTelasVO;
    import br.com.chapecosolucoes.trafegusweb.client.ws.TrafegusWS;
    
    import flash.events.KeyboardEvent;
    import flash.ui.Keyboard;
    
    import mx.collections.XMLListCollection;
    import mx.controls.Alert;
    import mx.rpc.events.ResultEvent;
    import mx.utils.ObjectUtil;
    
    import org.flexunit.runner.Result;

    public class LoginComponentController
    {
        public function LoginComponentController()
        {
        }

        public var view:LoginComponent;

        public function loginHandler(userName:String, passWord:String):void
        {
            TrafegusWS.getIntance().solicitaAcesso(solicitaAcessoHandler, userName, passWord);
        }

        private function solicitaAcessoHandler(evt:ResultEvent):void
        {
            var resultArray:Array = ParserResult.parserDefault(evt);
            for each (var obj:Object in resultArray)
            {
                MainModel.getInstance().codEmpresa = obj.usua_pess_oras_codigo.toString();
                MainModel.getInstance().codUsuario = obj.usua_pfis_pess_oras_codigo.toString();
				MainModel.getInstance().nomeUsuario = obj.usua_login.toString();
            }
            if (resultArray.length != 0)
            {
				TrafegusWS.getIntance().lerPosicaoTelas(lerPosicaoTelasResultHandler);
				TrafegusWS.getIntance().lerItensPorPagina(lerItensPorPaginaResultHandler);
				TrafegusWS.getIntance().trafegusSetUsuario(trafegusSetUsuarioResultHandler);
            }
            else
            {
                MessageBox.atencao("Usuario ou senha inválidos.");
            }
        }
		private function trafegusSetUsuarioResultHandler(event:ResultEvent):void
		{
			
		}
		private function lerItensPorPaginaResultHandler(e:ResultEvent):void
		{
			var resultArray:Array = ParserResult.parserDefault(e);
			for each (var obj:Object in resultArray)
			{
				MainModel.getInstance().itensPorPaginaVO .setItensPorPaginaVO(obj);
			}
		}
		private function lerPosicaoTelasResultHandler(e:ResultEvent):void {
            this.view.textinput1.text = "";
            this.view.textinput2.text = "";
			var resultArray:Array = ParserResult.parserDefault(e);
			for each (var obj:Object in resultArray)
			{
				UsuarioLogado.getInstance().posicaoTelasVO.setPosicaoTelasVO(obj);
			}
            var loginEvent:LoginEvent = new LoginEvent(LoginEvent.LOGIN_EVENT, true);
            this.view.dispatchEvent(loginEvent);
		}
		public function capslockHandler():void
		{
			if(Keyboard.capsLock)
			{				
				this.view.checkBox1.label = "Capslock on";
			}
			else
			{
				this.view.checkBox1.label = "";
			}
		}
    }
}