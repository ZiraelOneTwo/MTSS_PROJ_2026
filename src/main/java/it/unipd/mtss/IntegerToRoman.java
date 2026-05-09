////////////////////////////////////////////////////////////////////
// [ALEX] [SINGH] [BHO]
// [ALESSANDRO] [PADURET] [BHO]
////////////////////////////////////////////////////////////////////


package it.unipd.mtss;
import java.lang.IllegalArgumentException;

public class IntegerToRoman {
        private static String[] units           = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        private static String[] tens            = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        private static String[] hundreds        = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        private static String[] thousand        = {"", "M"};

        public static String convert(int number){
                if (number <= 0 || number > 1000) {
                       throw new IllegalArgumentException("Invalid conversion, bad input " + number);
                }

                return  thousand        [ number / 1000 ] +
                        hundreds        [ (number / 100) % 10 ] +
                        tens            [ (number / 10) % 10 ] +
                        units           [ number % 10 ];
        }
}
