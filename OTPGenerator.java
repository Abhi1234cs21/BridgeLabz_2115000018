import java.util.HashSet;
import java.util.Set;

public class OTPGenerator {

    public static String generateOTP() {
        int otp = (int) (Math.random() * 900000) + 100000;
        return String.valueOf(otp);
    }

    public static boolean areOTPsUnique(String[] otps) {
        Set<String> otpSet = new HashSet<>();
        for (String otp : otps) {
            if (!otpSet.add(otp)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] otpArray = new String[10];

        for (int i = 0; i < 10; i++) {
            otpArray[i] = generateOTP();
        }

        System.out.println("Generated OTPs:");
        for (String otp : otpArray) {
            System.out.println(otp);
        }

        boolean unique = areOTPsUnique(otpArray);
        System.out.println("Are all OTPs unique? " + unique);
    }
}
