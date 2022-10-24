package com.se.onlinemoviebooking;

import java.io.IOException;

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

	@Test
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

}
