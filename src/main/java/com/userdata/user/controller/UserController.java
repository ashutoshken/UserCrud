package com.userdata.user.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userdata.user.UserDao.UserDao;
import com.userdata.user.model.User;
import com.userdata.user.model.MobileUpdate;
import com.userdata.user.model.Response;
import com.userdata.user.model.User;

@RestController
@Validated
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/hello")
	public String Hello() {
		System.out.println("its running");
		return "Hello";
	}

	@GetMapping("/count")
	public int count() {
		
        return userDao.count();
        
     }
	
	@GetMapping("/all")
	public List<User> findAllUser() {
		return userDao.findAll();
	}
	  
	@GetMapping("/user/{id}")
	public Response findAllUserById(@PathVariable Integer id){
		Response response = new Response();
		System.out.println(id);
		try {
			if (id!=null) {
				List<User> result = userDao.findAllById(id);
				System.out.println("what is result :" + result);
				if(result != null && result.size() > 0) {
					response.setResponseCode(200);
					response.setResponseMessage("Success!");
					response.setResponseOfUserList(result);
					
				}else {
					response.setResponseMessage("Given Id Is Not Found!");
					response.setResponseOfUserList(new ArrayList<>());
				}
				
				return response;
			
			} else {
				response.setResponseCode(404);
				response.setResponseMessage("INVALID INPUT !!");
				return response;
				
			}
		}catch(NumberFormatException e) {
			response.setResponseCode(400);
			response.setResponseMessage("INVALID INPUT !!");
			return response;
			
		}
		
		
	}
	@PostMapping("/addPersons")
	public User addPersons(@RequestBody User user) {
		try {
			return userDao.addPersons(user);
		} catch (Exception e) {
			e.getMessage();
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		//return null;
	}
	
//	@PutMapping("/mobileUpdate/{id}"){
//	public MobileUpdate updateUsersMobileById(Integer id){
//		return userDao.updateUserMobileById(id);
//	}
	
	@PutMapping("/update")
	public User updateUsersMobile(@RequestBody User user){
		return userDao.updateUserMobile(user);
	}
	
	@PutMapping("/userUpdate/{id}")
	public String UserUpdate(@RequestBody User user, @PathVariable int id) {
		return userDao.getUserUpdate(user, id)+" User updated successfully";
	}
	
	@DeleteMapping("/userDeleted/{id}")
	public String deleteById(@PathVariable int id) {
		return userDao.deleteById(id)+" User delete from the database";
	}
	
	@PutMapping("/userDeletedTrue/{id}")
	public String deleteByIdTrue(@RequestBody User user, @PathVariable int id) {
		return userDao.deleteByIdTrue(user, id)+" User delete from the database";
	}
	
//	@PutMapping("/update/{id}")
//	public User getUserMobileById(@RequestBody User user){
//		return userDao.updateUserMobile(user);
//	}
	
//	@PutMapping("/mobile")
//	public MobileUpdate updateUserMobile(MobileUpdate mobileUpdate){
//		return userDao.updateUserMobile(mobileUpdate);
//	}
//	
	

	
}


