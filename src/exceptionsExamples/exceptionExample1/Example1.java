package exceptionsExamples.exceptionExample1;

public class Example1 {
    public static void main(String[] args) {
        String email = "example@gmail.com";
        try {
           boolean isValid = validEmail(email);
            System.out.println(email + " is a valid email address.");
        } catch (IllegalArgumentException e) {
            System.out.println(email + " is not a valid email address: "+ e.getMessage());
        }
    }

    public static boolean validEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }

        int index = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');

        if (index < 1 || dotIndex + 2 >= email.length() || dotIndex < index + 2) {
            throw new IllegalArgumentException("Invalid email address " + email);
        }

        return true;
    }
}
