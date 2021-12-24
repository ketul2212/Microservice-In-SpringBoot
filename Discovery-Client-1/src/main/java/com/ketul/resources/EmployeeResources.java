package com.ketul.resources;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.ServiceInstance;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ketul.module.Employee;
import com.ketul.module.Employee2;
import com.ketul.module.Employees;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;



@RestController
public class EmployeeResources {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private DiscoveryClient discoveryClient;

	private static Set<Employee2> userList = new HashSet<Employee2>();

	private static Set<Employees> userLists = new HashSet<Employees>();
	
	private static Set<Employee> userListss = new HashSet<Employee>();
	
	@GetMapping("/usersHttpClient")
	@HystrixCommand(fallbackMethod = "getEmployeesFallBackMethod",
			
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4"),
			        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
			        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			        @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "18000") 
			},
			threadPoolKey = "getOneEmployee",
			threadPoolProperties = {
			        @HystrixProperty(name = "coreSize", value = "30"),
			        @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "18000"),
			        @HystrixProperty(name = "maxQueueSize", value = "10")
			}

	)
	public Set<Employee2> getEmployees(HttpServletRequest request) {

		
//		discoveryClient.getInstances("First-Client").forEach((ServiceInstance s) -> {
//            System.out.println(ToStringBuilder.reflectionToString(s));
//        });
//		
//		System.out.println(discoveryClient.getInstances("First-Client"));
//		System.out.println(restTemplate.getForObject("http://First-Client/users", Employees.class));
		
		Employee2 employee2 = restTemplate.getForObject("http://First-Client/user", Employee2.class);

		userList.add(employee2);
//		HttpClient client = HttpClient.newHttpClient();
//		
//		HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8086/users")).build();
//		
//	
//		client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenApply(EmployeeResources::parse).join();
//		

		return userList;
	}

	public Set<Employee2> getEmployeesFallBackMethod(HttpServletRequest request) {
		Employee2 employee2 = new Employee2(101, "Not Found", "Not Applicable");
		
		userList.add(employee2);
		
		return userList;
		
	}
//	public static String parse(String response) {
//		JSONObject jsonObject = new JSONObject(response);
//		System.out.println(jsonObject);
//		
//		JSONArray jsonArray = jsonObject.getJSONArray("listEmployees");
//		System.out.println(jsonArray);
//
//		for(int i = 0; i < jsonArray.length(); i++) {
//			JSONObject json = jsonArray.getJSONObject(i);
//			int id = json.getInt("id");
//			String name = json.getString("name");
//			userList.add(new Employee(id, name));
////			System.out.println(id + "    " + email);
//		}
//
//		System.out.println(userList);
//		return null;
//	}
	
	
	@GetMapping( value = "/usersHttpClients")
	@HystrixCommand(fallbackMethod = "getAllFallBackMethod")
	public Employees getAll() {
		
		String userStr = restTemplate.getForObject("http://First-Client/users", String.class, userLists);
//		System.out.println(userStr);
	
//		System.out.println(userLists);
//		return userLists;
		JSONObject jsonObject = new JSONObject(userStr);
		JSONArray jsonArray = jsonObject.getJSONArray("listEmployees");
		
		for(int i = 0; i < jsonArray.length(); i++) {
			JSONObject json = jsonArray.getJSONObject(i);
			int id = json.getInt("id");
			String name = json.getString("name");
			userListss.add(new Employee(id, name));
//			System.out.println(id + "    " + email);
		}
			Employees employees = new Employees();
			employees.setListEmployee(new ArrayList<Employee>(userListss));
		System.out.println(jsonObject);
		
		return employees;
	}
	
	public Employees getAllFallBackMethod() {
		Employees employee = new Employees();
		
		employee.setListEmployee(Arrays.asList((new Employee(0 , "default"))));
		return employee;
	}
}
