package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
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

        if (!PaymentData.checkData(method, paymentData)){
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



interface PaymentData {


    public static boolean checkData(String method, HashMap<String, String> param){
        Set<String> paramKeySet = param.keySet();

        return switch (method) {
            case "VOUCHER_CODE" -> {
                Set<String> voucherCodeKeySet = getVoucherCodeKeySet();
                yield paramKeySet.equals(voucherCodeKeySet);
            }
            case "CASH_ON_DELIVERY" -> {
                Set<String> cashOnDeliveryKeySet = getCashOnDeliveryKeySet();
                yield paramKeySet.equals(cashOnDeliveryKeySet);
            }
            default -> false;
        };
    }

    public static Set<String> getVoucherCodeKeySet(){
        Set<String> voucherCodeKeys = new HashSet<>();
        voucherCodeKeys.add("voucherCode");

        return voucherCodeKeys;
    }

    public static Set<String> getCashOnDeliveryKeySet(){
        Set<String> cashOnDeliveryKeys = new HashSet<>();
        cashOnDeliveryKeys.add("address");
        cashOnDeliveryKeys.add("deliveryFee");

        return cashOnDeliveryKeys;
    }


}
