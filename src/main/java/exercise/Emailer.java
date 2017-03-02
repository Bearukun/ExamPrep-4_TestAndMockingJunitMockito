package exercise;

public class Emailer {

    private final String mailTo = "admin@jokes.com";

    /**
     * This sends an email to the receiver given in: mailTo. IMPORTANT if you
     * see the output below, you should interpret is as a REAL EMAIL was sent
     *
     * @param text Text to include in the mail
     */
    public void sendEmailInternal(String text) {
        System.out.println("#####################################################################################");
        System.out.println("This simulates that a REAL EMAIL was sent to: " + mailTo + " with this text:\n" + text);
        System.out.println("#####################################################################################");
    }

}
