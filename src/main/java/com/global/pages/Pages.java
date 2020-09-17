package com.global.pages;

import com.fiserv.framework.utility.cleanup.TearDwon;

public interface Pages {
	LoginPage loginPage = new LoginPage();
	NewCustomerPage newCustomer = new NewCustomerPage();
	TearDwon tearDown=new TearDwon();
}
