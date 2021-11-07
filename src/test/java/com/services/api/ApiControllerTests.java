package com.services.api;

import com.services.api.dto.PriceInput;
import com.services.api.dto.PriceOutPut;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiControllerTests {

	@LocalServerPort
	int port;

	TestRestTemplate testRestTemplate = new TestRestTemplate();

	/*
		Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA).
	 */
	@Test
	void test_1(){
		PriceInput priceInput = new PriceInput();
		priceInput.setInput_date("2020-06-14 10:00:00.000");
		priceInput.setBrand_id(1);
		priceInput.setProduct_id(35455);

		ResponseEntity<PriceOutPut> response = this.componentBuild(priceInput);

		PriceOutPut priceOutPut = response.getBody();

	}

	/*
		Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA).
	 */
	@Test
	void test_2(){
		PriceInput priceInput = new PriceInput();
		priceInput.setInput_date("2020-06-14 16:00:00.000");
		priceInput.setBrand_id(1);
		priceInput.setProduct_id(35455);

		ResponseEntity<PriceOutPut> response = this.componentBuild(priceInput);

		PriceOutPut priceOutPut = response.getBody();
	}

	/*
		Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA).
	 */
	@Test
	void test_3(){
		PriceInput priceInput = new PriceInput();
		priceInput.setInput_date("2020-06-14 21:00:00.000");
		priceInput.setBrand_id(1);
		priceInput.setProduct_id(35455);

		ResponseEntity<PriceOutPut> response = this.componentBuild(priceInput);

		PriceOutPut priceOutPut = response.getBody();
	}

	/*
		Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA).
	 */
	@Test
	void test_4(){
		PriceInput priceInput = new PriceInput();
		priceInput.setInput_date("2020-06-15 10:00:00.000");
		priceInput.setBrand_id(1);
		priceInput.setProduct_id(35455);

		ResponseEntity<PriceOutPut> response = this.componentBuild(priceInput);

		PriceOutPut priceOutPut = response.getBody();
	}

	/*
		Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA).
	 */
	@Test
	void test_5(){
		PriceInput priceInput = new PriceInput();
		priceInput.setInput_date("2020-06-16 21:00:00.000");
		priceInput.setBrand_id(1);
		priceInput.setProduct_id(35455);

		ResponseEntity<PriceOutPut> response = this.componentBuild(priceInput);

		PriceOutPut priceOutPut = response.getBody();
	}

	private ResponseEntity<PriceOutPut> componentBuild(PriceInput priceInput) {
		UriComponentsBuilder paramBuilder = this.queryParamBuilder(priceInput.getProduct_id(),
				priceInput.getBrand_id(), priceInput.getInput_date());

		ResponseEntity<PriceOutPut> response = this.doGetRequest(paramBuilder);
		return response;
	}

	private UriComponentsBuilder queryParamBuilder(Integer product_id, Integer brand_id, String start_date) {
		return UriComponentsBuilder.fromHttpUrl("http://localhost:" + port + "/prices")
				.queryParam("product_id", product_id)
				.queryParam("brand_id", brand_id)
				.queryParam("start_date", start_date);
	}

	private ResponseEntity<PriceOutPut> doGetRequest(UriComponentsBuilder builder) {
		URI uri = builder.build()
				.encode()
				.toUri();
		return testRestTemplate.exchange(uri, HttpMethod.GET, null, PriceOutPut.class);
	}
}
