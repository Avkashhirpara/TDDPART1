import spock.lang.Specification
import spock.lang.Unroll

class StackShould  extends  Specification{


    def "this is the sample feature"(){

        expect:
            true== true

    }
    @Unroll
    def "pop the last object pushed"(){
        given:
        def stack = new Stack()
        stack.push(object)
        when:
            result  = stack.pop()
        then:
        result == object;
        where:
        object | result
        new String("hi") | new String("hi")
        11.00 | 11.00
        "string" | 11
    }
   def "throw execption when if popped when empty"(){
       given:
        def stack = new Stack()
       when:
       def result = stack.pop()
       then:
       thrown(EmptyStackException)
    }
    def "pop elements in reverse ordered the way they pushed"(){

        given:
            def stack = new Stack();
            stack.push("object1")
            stack.push("object2")
        when:
            def result = stack.pop()
            def result2 = stack.pop()
        then:
            result == "object2"
            result2 == "object1"
    }



}
