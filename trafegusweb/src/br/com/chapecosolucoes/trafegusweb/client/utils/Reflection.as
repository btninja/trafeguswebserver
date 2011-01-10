package br.com.chapecosolucoes.trafegusweb.client.utils
{
    import mx.utils.ObjectUtil;

    public class Reflection
    {
        public function Reflection()
        {
        }


        public static function getObjectProperty(obj:Object, propName:String):*
        {
            var result:* = null;
            if (objectHasProperty(obj, propName))
            {
                result = obj[propName];
            }
        }

        public static function setObjectProperty(obj:Object, propName:String, value:*, validateProperty:Boolean = true):void
        {
            if (validateProperty == true)
            {
                if (objectHasProperty(obj, propName))
                {
                    obj[propName] = value;
                }
            }
            else
            {
                obj[propName] = value;
            }
        }

        public static function objectHasProperty(obj:Object, propName:String):Boolean
        {
            var propriedades:Object = ObjectUtil.getClassInfo(obj);
            for each (var prop:Object in propriedades.properties)
            {
                if (prop.toString().toLowerCase() == propName.toLowerCase())
                {
                    return true;
                }
            }
            return false;
        }

        public static function getAllObjectProperties(obj:Object):Array
        {
            var result:Array = new Array();
            var propriedades:Object = ObjectUtil.getClassInfo(obj);
            for each (var prop:Object in propriedades.properties)
                result.push(prop.toString());
            return result;
        }

        public static function copyObjectToObject(objFrom:Object, objTo:Object):void
        {
            var prop:Array = getAllObjectProperties(objFrom);
            for each (var nameProp:String in prop)
            {
                setObjectProperty(objTo, nameProp, objFrom[nameProp]);
            }
        }

    }
}