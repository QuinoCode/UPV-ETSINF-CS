package practica2;


/**
 * class WrapperClassesUse.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class WrapperClassesUse {        
    public static void main(String[] args) {            
        // Assignment of wrapper variables to elementary types 
         
        
        char c = new Character('c');
        byte b = new Byte((byte)10);
        short s = new Short((short) 129); //Estos dos hay que castearlos porque java por defecto 
                                        //los trata como ints
        int i = new Integer(123456);
        long l = new Long(2);
        float f = new Float(12.3f); //Sufijo f porque por defecto un número con ',' es double
        double d = new Double(123.456d);//Sufijo 'd' por consistencia con el float
        //Esto de arriba no se usa jamás en la vida, pero es la respuesta y yo lo pongo
        //Solo hace falta int, double y char.
        
        
        // Writing elementary variables
        System.out.println("int i = " + i);
        // TO COMPLETE ...
        System.out.println("double d = " + d);
        System.out.println("char c = " + c);
        // Assignment of elementary values to wrapper variables
        Byte eB = (byte)128;
        Short eS = 129;
        Integer eI = 123456; 
        Long eL = (long) 12345678;
        Float eF = (float) 1233.47;
        Double doble = 1233434.45;
        Character charr = 'h';

        // TO COMPLETE ...
            
        // Writing wrapper variables
        System.out.println("Integer I = " + eI);
        // TO COMPLETE ...
        System.out.println("Double d = " + doble);
        System.out.println("Character charr = " + charr);
    }    
}