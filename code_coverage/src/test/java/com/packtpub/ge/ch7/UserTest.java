package com.hien.ge.project;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest {


  @Test
  public void userNameTest(){
    User user1 = new User("User1", "User user", "user@abc.com");
    Assert.assetEquals(user1.getName(),"User user")

  }

	@Test
	public void userEmailTest() {
		User user1 = new User("User2", "User2 user2", "user2@abc.com");
		Assert.assertEquals(user1.getEmail(), "user2@abc.com");
	}

	@Test
	public void userIdTest() {
		User user1 = new User();
		user1.setUserId("User3");
		user1.setName("User3 user3");
		user1.setEmail("user3@abc.com");
		Assert.assertEquals(user1.getName(), "User3 user3");
		Assert.assertEquals(user1.getUserId(), "User3");
	}

	@Test
	public void userTest() {
		User user1 = new User();
		user1.setUserId("User4");
		user1.setName("User4 user4");
		user1.setEmail("user4@abc.com");
		Assert.assertTrue(user1.toString().contains("User4"));
	}

}
