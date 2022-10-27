package com.se.onlinemoviebooking;

import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.se.onlinemoviebooking.application.database.service.UserService;
import com.se.onlinemoviebooking.application.dto.AddressDTO;
import com.se.onlinemoviebooking.application.dto.CustomerDTO;
import com.se.onlinemoviebooking.application.dto.Status;
import com.se.onlinemoviebooking.application.dto.UserDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
class OnlinemoviebookingApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}

	//@Test
	public void whenSerializeAndDeserializeUsingJackson_thenCorrect() throws IOException {

		CustomerDTO user = new CustomerDTO();
		AddressDTO add = new AddressDTO();
		add.setStreet("2838 barnett shoals dr");
		add.setApt("505");
		add.setCity("Athens");
		add.setState("GA");
		add.setZipcode("30605");
		user.setAddress(add);
		user.setUserID(123);
		user.setStatus(Status.ACTIVE);
		user.setEmail("myemail@gmail.com");
		user.setFirstName("jay");
		user.setLastName("kurri");
		user.setIsSubscribed(false);
		user.setNumber("999999");
		user.setPassword("mypassword");
		System.out.println(user.toJSONString());
		UserDTO saveduser = userService.saveUser(user);
		System.out.println(saveduser.getFirstName());
		System.out.println(saveduser.toJSONString());
//		String jsonStr = user.toJSONString();
//		System.out.println(jsonStr);
//		UserDTO result = UserDTO.getObject(jsonStr);
//		System.out.println("oject status are " + user.getAddress().getStreet() + "result status "
//				+ result.getAddress().getStreet());
	}
	
	@Test
	public void mailservice() {
		final String username = "moviebookingproject@gmail.com";
        final String password = "Teamb3@uga";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("bobbyjri157@gmail.com")
            );
            message.setSubject("Testing Gmail SSL");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
