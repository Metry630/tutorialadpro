package id.ac.ui.cs.advprog.eshop.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public interface PaymentData {
    public static boolean checkData(String method, HashMap<String, String> param) {
        Set<String> paramKeySet = param.keySet();

        return switch (method) {
            case "VOUCHER_CODE" -> {
                Set<String> voucherCodeKeySet = getVoucherCodeKeySet();
                if (!paramKeySet.equals(voucherCodeKeySet)){
                    yield false;
                }
                yield checkVoucherCode(param.get("voucherCode"));

            }
            case "CASH_ON_DELIVERY" -> {
                Set<String> cashOnDeliveryKeySet = getCashOnDeliveryKeySet();
                if (!paramKeySet.equals(cashOnDeliveryKeySet)){
                    yield false;
                }
                yield (isStringEmpty(param.get("address")) ||
                        isStringEmpty(param.get("deliveryFee")));

            }
            default -> false;
        };
    }


    public static Set<String> getVoucherCodeKeySet() {
        Set<String> voucherCodeKeys = new HashSet<>();
        voucherCodeKeys.add("voucherCode");

        return voucherCodeKeys;
    }

    public static Set<String> getCashOnDeliveryKeySet() {
        Set<String> cashOnDeliveryKeys = new HashSet<>();
        cashOnDeliveryKeys.add("address");
        cashOnDeliveryKeys.add("deliveryFee");

        return cashOnDeliveryKeys;
    }

    public static HashMap<String, String> getNewVoucherCodeData(String voucherCode) {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("voucherCode", voucherCode);
        return result;
    }

    public static HashMap<String, String> getNewCashOnDeliveryData(String address, String deliveryFee) {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("address", "");
        result.put("deliveryFee", "");
        return result;
    }


    public static boolean checkVoucherCode(String voucherCode) {
        if (voucherCode.length() != 16) {
            return false;
        }

        if (!voucherCode.startsWith("ESHOP")) {
            return false;
        }

        int numberCount = 0;
        for (char character : voucherCode.toCharArray()) {
            if (Character.isDigit(character)) {
                numberCount++;
            }
        }

        return numberCount == 8;


    }

    public static boolean isStringEmpty(String str){
        return (str == null || str.isEmpty());
    }

}