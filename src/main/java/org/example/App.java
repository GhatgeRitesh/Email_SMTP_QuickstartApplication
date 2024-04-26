package org.example;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println("system started");
        GMailSender sender=new GMailSender();
        String to="riteshghatge30@gmail.com";
        String from="riteshghatge5555@gmail.com";
        String subject="Demo email from GMailService_MiniProject";
        String text="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "<title>One Time Password (OTP) Delivery</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div>\n" +
                "    <h2>One Time Password (OTP) Delivery</h2>\n" +
                "    <p>Your OTP is: <span id=\"otp\"></span></p>\n" +
                " <img src='data:images/2.png;base64,[BASE64_ENCODED_IMAGE]' alt='image logo'>"+
                "  </div>\n" +
                "</body>\n" +
                "</html>";
        boolean b=sender.SendEmail(to,from,subject,text);
        if(b){
            System.out.println("Mail sent Successfully");
        }
        else{
            System.out.println("The Error occured while sending the email");
        }

    }
}
