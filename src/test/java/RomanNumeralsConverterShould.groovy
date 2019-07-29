import spock.lang.Specification
import spock.lang.Unroll

class RomanNumeralsConverterShould extends Specification {

    @Unroll
    def "convert given numbers to Roman Numerals #number "(){
        given:

            def RomanNumeralConverter converter = new RomanNumeralConverter();
        when:
             def returnValue = converter.convert(number)
        then:
                returnValue == result
        where:
            number     |       result
                1      |        "I"
                2      |        "II"
                3      |        "III"
                5      |        "V"
                6      |        "VI"
                7      |        "VII"
                8      |        "VIII"
                4      |        "IV"
                9      |        "IX"
                10     |       "X"
                17     |       "XVII"
                19     |       "XIX"
                38     |       "XXXVIII"
                225     |       "CCXXV"





    }




}
