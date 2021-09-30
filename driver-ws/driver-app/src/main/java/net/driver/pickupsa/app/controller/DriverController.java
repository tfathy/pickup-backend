package net.driver.pickupsa.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import net.driver.pickupsa.app.entity.SlOrder;
import net.driver.pickupsa.app.entity.UserLogin;
import net.driver.pickupsa.app.entity.lookup.Team;
import net.driver.pickupsa.app.service.SlOrderService;
import net.driver.pickupsa.app.service.UserLoginService;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	private UserLoginService userLoginService;

	@Autowired
	private SlOrderService slOrderService;

	@PostMapping(value = "/user-login-info", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Create record in the sysUserLogin table to log the user login date and location and his status")
	public ResponseEntity<UserLogin> create(@RequestBody UserLogin body) {
		UserLogin entity = userLoginService.create(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);

	}

	@PutMapping(value = "/user-login-info/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "update the userlogin of a user.for example update his status")
	public ResponseEntity<UserLogin> update(@RequestBody UserLogin body, Integer id) {
		UserLogin entity = userLoginService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(entity);

	}

	@ApiOperation(value = "return list of avaliable orders that suits the vehcile size.Avaliable orders are those  orders which ord_status=REQUEST")
	@GetMapping(value = "/avaliable-order/{vclSizeId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<SlOrder>> findAvailableOrders(@PathVariable Integer vclSizeId) {
		List<SlOrder> result = slOrderService.findAvaliableOrders(vclSizeId);
		if (result == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}

	// return list of available drivers - used by send notification from the
	// customer app
	@ApiOperation(value = "return list of avaliable drivers that suits the vehcile size of the order.Records are retrived from sys_user_login table for those drivers whose statys=AVALIABLE. oBJCT MUST RETURN A FCMTOKEN")
	@GetMapping(value = "/avaliable/{vclSizeId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<UserLogin>> findAvailabledrivers(@PathVariable Integer vclSizeId) {
		List<UserLogin> result = null;
		result = userLoginService.findAvailabe(vclSizeId);
		if (result == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	@ApiOperation(value = "return the team that the manager manage.parameter is managerid which is SpMember.id attribute")
	@GetMapping(value="/team/{managerId}",produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Team> findTeamByManagerId(@PathVariable Integer managerId){
		Team result = null;
		result = slOrderService.findTeamByManagerId(managerId);
		if(result ==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	
	/*****************************************orders************************************************************/
	@ApiOperation(value = "update order object")
	@PutMapping(value="/order/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<SlOrder> update(@RequestBody SlOrder entity,@PathVariable Integer id){
		SlOrder order = slOrderService.update(entity, id);
		if(order == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(order);
		}
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
}
