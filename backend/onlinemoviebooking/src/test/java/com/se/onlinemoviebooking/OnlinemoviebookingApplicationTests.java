package com.se.onlinemoviebooking;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.se.onlinemoviebooking.application.database.service.UserService;
import com.se.onlinemoviebooking.application.dto.AddressDTO;
import com.se.onlinemoviebooking.application.dto.MovieCategory;
import com.se.onlinemoviebooking.application.dto.MovieDTO;
import com.se.onlinemoviebooking.application.dto.MovieRating;
import com.se.onlinemoviebooking.application.dto.PaymentcardDTO;
import com.se.onlinemoviebooking.application.dto.PromotionDTO;
import com.se.onlinemoviebooking.application.dto.ShowRoom;
import com.se.onlinemoviebooking.application.dto.ShowTimeDTO;
import com.se.onlinemoviebooking.application.dto.ShowTimeSlot;
import com.se.onlinemoviebooking.application.dto.Status;
import com.se.onlinemoviebooking.application.dto.UserDTO;
import com.se.onlinemoviebooking.application.dto.UserType;

@RunWith(SpringRunner.class)
@SpringBootTest
class OnlinemoviebookingApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}

	@Test
	public void printShowTimeDTO() {

		ShowTimeDTO showTimeDTO = new ShowTimeDTO();
		showTimeDTO.setShowID(Long.parseLong("1"));
		showTimeDTO.setMovieID(Long.parseLong("3"));
		showTimeDTO.setShowRoom(ShowRoom.MAXRELAX);
		try {
			showTimeDTO.setShowDate(new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-20"));
		} catch (java.text.ParseException e) {
		}
		showTimeDTO.setShowTimeSlot(ShowTimeSlot.SHOW1);
		
		System.out.println(showTimeDTO.toJSONString());
	}

	//@Test
	public void printPromotionDTO() {

		PromotionDTO promotionDTO = new PromotionDTO();

		promotionDTO.setPromoID(Long.parseLong("124"));
		promotionDTO.setPromotionName("thanksgiving-promotion");
		promotionDTO.setPromocode("THANKS15");
		try {
			promotionDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-20"));
		} catch (java.text.ParseException e) {
		}
		try {
			promotionDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-25"));
		} catch (java.text.ParseException e) {
		}

		promotionDTO.setIsSent(false);
		promotionDTO.setDiscount(Float.parseFloat("15.0"));

		System.out.println(promotionDTO.toJSONString());

	}

	// @Test
	public void printmoviedto() {
		MovieDTO movieDTO = new MovieDTO();

		movieDTO.setMovieID(Long.parseLong("124"));
		movieDTO.setTitle("RRR");
		movieDTO.setCategory(MovieCategory.ACTION);
		movieDTO.setRating(MovieRating.PG13);
		try {
			movieDTO.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01"));
		} catch (java.text.ParseException e) {

		}
		movieDTO.setDirector("Rajamouli");
		movieDTO.setProducer("Danayya");
		movieDTO.setCast("Ramcharan, NTR, AliaBhatt, rajiv kanakala");
		movieDTO.setSynopsis("Action packed indian movie");
		movieDTO.setPosterURL("https://assets-prd.ignimgs.com/2022/07/11/rrr-button-ver-1657577923010.jpg");
		movieDTO.setTrailerURL("https://www.youtube.com/watch?v=NgBoMJy386M");

		System.out.println(movieDTO.toJSONString());
	}

	// @Test
	public void whenSerializeAndDeserializeUsingJackson_thenCorrect() throws IOException {

		UserDTO user = new UserDTO();
		AddressDTO add = new AddressDTO();
		add.setStreet("2838 barnett shoals dr");
		add.setApt("505");
		add.setCity("Athens");
		add.setState("GA");
		add.setZipcode("30605");

		user.setAddress(add);
		user.setUserID(123);
		user.setStatus(Status.ACTIVE);
		user.setFirstName("jay");
		user.setLastName("kurri");
		user.setEmail("kurri@gmail");
		user.setUserType(UserType.ADMIN);
		user.setIsSubscribed(false);
		user.setNumber("999999");
		user.setPassword("mypassword");

		String jsonStr = user.toJSONString();
		System.out.println(jsonStr);

		JSONParser parser = new JSONParser();
		JSONObject json;
		try {
			json = (JSONObject) parser.parse(jsonStr);
		} catch (ParseException e) {
			json = new JSONObject();
		}
		json.remove("lastName");
		json.remove("email");
		json.remove("userID");

		System.out.println(json);

		UserDTO result = UserDTO.getObject(json);
		System.out.println(result.toJSONString());
		System.out.println((new PaymentcardDTO()).toJSONString());

		// UserDTO saveduser = userService.saveUser(user);

//		String jsonStr = user.toJSONString();
//		System.out.println(jsonStr);
//		UserDTO result = UserDTO.getObject(jsonStr);
//		System.out.println("oject status are " + user.getAddress().getStreet() + "result status "
//				+ result.getAddress().getStreet());
	}

	// @Test
	public void mailservice() {

		try {
			String to = "bobbyjri157@gmail.com";
			String from = "b3onlinemoviebooking@outlook.com";

			Properties props = new Properties();
//            props.put("mail.smtp.socketFactory.port", "587");
//            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//            props.put("mail.smtp.socketFactory.fallback", "true");
			props.put("mail.smtp.host", "smtp-mail.outlook.com");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("b3onlinemoviebooking@outlook.com", "Teamb3@uga");
				}
			});

//            Session emailSession = Session.getDefaultInstance(props, null);

			String msgBody = "Sending email using JavaMail API...";

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from, "NoReply"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to, "Mr. Recipient"));
			msg.setSubject("Welcome To Java Mail API");
			msg.setText(msgBody);
			Transport.send(msg);
			System.out.println("Email sent successfully...");
		} catch (AddressException e) {
			System.out.println("exception");
		} catch (MessagingException e) {
			System.out.println("exception");
		} catch (UnsupportedEncodingException e) {
			System.out.println("exception");
		}

//		
//		final String username = "moviebookingproject@gmail.com";
//        final String password = "Teamb3@uga";
//
//        Properties prop = new Properties();
//		prop.put("mail.smtp.host", "smtp.gmail.com");
//        prop.put("mail.smtp.port", "465");
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.socketFactory.port", "465");
//        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        
//        Session session = Session.getInstance(prop,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//
//        try {
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("from@gmail.com"));
//            message.setRecipients(
//                    Message.RecipientType.TO,
//                    InternetAddress.parse("bobbyjri157@gmail.com")
//            );
//            message.setSubject("Testing Gmail SSL");
//            message.setText("Dear Mail Crawler,"
//                    + "\n\n Please do not spam my email!");
//
//            Transport.send(message);
//
//            System.out.println("Done");
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
	}

}
