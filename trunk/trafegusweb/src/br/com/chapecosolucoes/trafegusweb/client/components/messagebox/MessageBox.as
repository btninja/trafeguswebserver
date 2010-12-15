package br.com.chapecosolucoes.trafegusweb.client.components.messagebox
{
    import flash.display.Sprite;

    import mx.controls.Alert;

    public class MessageBox
    {

        [Bindable]
        [Embed(source='./assets/error.png')]
        private static var erroIcone:Class;

        [Bindable]
        [Embed(source='./assets/information.png')]
        private static var inforIcone:Class;

        [Bindable]
        [Embed(source='./assets/warning.png')]
        private static var alertaIcone:Class;

        [Bindable]
        [Embed(source='./assets/question.png')]
        private static var perguntaIcone:Class;

        public static const YES:uint = Alert.YES;

        public static const NO:uint = Alert.NO;


        public function MessageBox()
        {
        }

        public static function atencao(text:String = "", title:String = "", flags:uint = 0x4, parent:Sprite = null, closeHandler:Function = null, iconClass:Class = null, defaultButtonFlag:uint = 0x4):Alert
        {
            title = (title != "" ? "Atenção - " + title : "Atenção");
			var alert:Alert = Alert.show(text, title, flags, parent, closeHandler, iconClass, defaultButtonFlag);
			alert.titleIcon = alertaIcone;
			return alert;
        }

        public static function informacao(text:String = "", title:String = "", flags:uint = 0x4, parent:Sprite = null, closeHandler:Function = null, iconClass:Class = null, defaultButtonFlag:uint = 0x4):Alert
        {
            title = (title != "" ? "Informação - " + title : "Informação");
            var alert:Alert = Alert.show(text, title, flags, parent, closeHandler, iconClass, defaultButtonFlag);
            alert.titleIcon = inforIcone;
            return alert;
        }

        public static function erro(text:String = "", title:String = "", flags:uint = 0x4, parent:Sprite = null, closeHandler:Function = null, iconClass:Class = null, defaultButtonFlag:uint = 0x4):Alert
        {
            title = (title != "" ? "Erro - " + title : "Erro");
			var alert:Alert = Alert.show(text, title, flags, parent, closeHandler, iconClass, defaultButtonFlag);
			alert.titleIcon = erroIcone;
			return alert;
        }

        public static function pergunta(text:String = "", title:String = "", flags:uint = 0x4, parent:Sprite = null, closeHandler:Function = null, iconClass:Class = null, defaultButtonFlag:uint = 0x4):Alert
        {
            title = (title != "" ? "Pergunta - " + title : "Pergunta");
            if (flags == 0x4)
            {
                flags = Alert.YES | Alert.NO;
                if (defaultButtonFlag == 0x4)
                    defaultButtonFlag = Alert.NO;
            }
			var alert:Alert = Alert.show(text, title, flags, parent, closeHandler, iconClass, defaultButtonFlag);
			alert.titleIcon = perguntaIcone;
			return alert;
        }

    }
}