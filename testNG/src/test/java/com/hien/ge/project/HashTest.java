package com.hien.ge.project;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HashTest {

	private HashMap<Integer,String> hm;

	@BeforeClass(alwaysRun = true)
	public void setup(){
		hm = new HashMap<Integer, String>();
	}

	@AfterMethod(alwaysRun = true)
	public void cleantask(){//clean task
		hm.clear();
	}

	@Test(groups = "Smoke1")
	public void verifyMapSize(){
		Assert.assertEquals(hm.size(), 0);
		hm.put(1, "first");
		hm.put(2, "second");
		hm.put(3, "third");
		Assert.assertEquals(hm.size(), 3);
	}

	@Test(groups = "Smoke")
	public void verifyMapNotNull(){
		Assert.assertNotNull(hm);

	}


	@Test(groups = "Integration")
	public void addEvenNumbers(){
		hm.put(2, "second");
		hm.put(4, "fourth");
		Assert.assertEquals(hm.size(), 2);
	}


}
