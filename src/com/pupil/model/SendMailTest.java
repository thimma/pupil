package com.pupil.model;

public class SendMailTest {
	 
    public static void main(String[] args) {
 
        String from = "csjobsleads@aggiemail.usu.edu";
        String to = "thimmareddykalva@aggiemail.usu.edu";
        String subject = "Test";
        String message = "A test message" +
        		"" +
        		"https://aggiemail.usu.edu";
 
        SendMail sendMail = new SendMail(from, to, subject, message);
        sendMail.send();
        System.out.println("done");
    }
}
