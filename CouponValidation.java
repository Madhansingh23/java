import java.util.*;

public class CouponValidation{
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<String> result = new ArrayList<>();

        Map<String, Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);

        List<String[]> validCoupons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (
                isActive[i] &&
                priority.containsKey(businessLine[i]) &&
                isValidCode(code[i])
            ) {
                validCoupons.add(new String[]{businessLine[i], code[i]});
            }
        }

        validCoupons.sort((a, b) -> {
            int cmp = Integer.compare(priority.get(a[0]), priority.get(b[0]));
            return cmp != 0 ? cmp : a[1].compareTo(b[1]);
        });

        for (String[] entry : validCoupons) {
            result.add(entry[1]);
        }

        return result;
    }

    // Manual check for alphanumeric or underscore
    private boolean isValidCode(String s) {
        if (s == null || s.isEmpty()) return false;
        for (char c : s.toCharArray()) {
            if (!(Character.isLetterOrDigit(c) || c == '_')) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        CouponValidation coupon=new CouponValidation();

        String[] code = {"SAVE20", "", "PHARMA5", "SAVE@20"};
        String[] businessLine = {"restaurant", "grocery", "pharmacy", "restaurant"};
        boolean[] isActive = {true, true, true, true};

        System.out.println(coupon.validateCoupons(code, businessLine, isActive));
        // Output: [PHARMA5, SAVE20]
    }

}
