package com.udacity.pricing;

import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingServiceApplication.class)
//@SpringBootTest
public class PricingServiceApplicationTests {
	@Test
	public void contextLoads() {
	}
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	PricingService pricingService;

	@Test
	public void getPrice() throws Exception {
		mockMvc.perform(get("/services/price?vehicleId=1"))
		.andExpect(status().isOk());
		verify(pricingService, times(1)).getPrice(10000L);
	}


	//write a test to check whether the application appropriately generates a price for a given vehicle ID
//	@Test
//	public void testGetPrice() {
//		//given
//		 int vehicleId = 1;
//        //when
//        int price = PricingServiceApplication.getPrice(vehicleId);
//        //then
//        assert price == 10000;
//	}

}
