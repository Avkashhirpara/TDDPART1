public class PaymentService {
    public UserValidator userValidator;
    public PaymentGateway paymentGateway;

    public PaymentService(UserValidator userValidator, PaymentGateway paymentGateway) {
        this.userValidator = userValidator;
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(User user, PaymentDetails paymentDetails) {
        if(!userValidator.isValid(user)){
            throw new InvalidUserException("User is not valid");
        }
        paymentGateway.payWith(paymentDetails);
    }
}
