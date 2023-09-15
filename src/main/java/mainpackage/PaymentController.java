package mainpackage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
class PaymentsController {
    private static Logger logger = Logger.getLogger(PaymentsController.class.getName());

    @PostMapping("/payment")
    public ResponseEntity<?> createPayment(
            @RequestBody Payment payment,
            @RequestHeader String requestId
    ){
        logger.info("Received request with Id" + requestId + ";Payment amount:" + payment.getAmount());
        payment.setId(requestId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId",requestId)
                .body(payment);
    }
}
