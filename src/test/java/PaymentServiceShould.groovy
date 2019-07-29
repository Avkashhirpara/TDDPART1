import User
import mockit.Mock
import spock.lang.Specification

class PaymentServiceShould  extends  Specification{
    def userValidator = Mock(UserValidator.class)
    def user = new User("temp","temp")
    def paymentGateway = Mock(PaymentGateway.class)
    def paymentDetails = new PaymentDetails()

    def "throw exception when user is not valid"(){
        given:
        userValidator.isValid(user) >> false;
        def paymentService = new PaymentService(userValidator,paymentGateway)
        when:
            paymentService.processPayment(user,paymentDetails)
        then:
            1* userValidator.isValid(user) >> false
            0* paymentGateway.payWith(paymentDetails)
            thrown(InvalidUserException)

    }
    def "process payment for valid user"(){
        given:
        userValidator.isValid(user) >> true;
        def paymentService = new PaymentService(userValidator,paymentGateway)
        when:
        paymentService.processPayment(user,paymentDetails)
        then:
        1* userValidator.isValid(user) >> true
        1* paymentGateway.payWith(paymentDetails)
        notThrown(InvalidUserException)

    }
    def cleanupSpec(){

    }
}
