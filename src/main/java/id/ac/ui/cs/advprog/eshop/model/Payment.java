package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.PaymentData;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
public class Payment {
    String id;
    String method;
    String status;
    HashMap<String, String> paymentData;




    public Payment(String id, String method, String status, HashMap<String, String> paymentData) {
        this(id, method, paymentData);
        if (PaymentStatus.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException();

        }
    }

    public Payment(String id, String method, HashMap<String,String> paymentData){
        this.id = id;
        this.status = PaymentStatus.WAITING.getValue();

        if (PaymentMethod.contains(method)){
            this.method = method;
        } else{
            throw new IllegalArgumentException();
        }



        if (PaymentMethod.contains(method)){
            this.method = method;
        } else{
            throw new IllegalArgumentException();
        }

        if (!(PaymentData.checkData(method, paymentData))){
            throw new IllegalArgumentException();
        } else {
            this.paymentData = paymentData;
        }

    }

    public void setStatus(String status){
        if (PaymentStatus.contains(status)){
            this.status = status;
        } else{
            throw new IllegalArgumentException();
        }
    }

}