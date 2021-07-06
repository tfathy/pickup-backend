package com.pickup.sysowner.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickup.sysowner.entity.GnCountry;
import com.pickup.sysowner.entity.GnCurrency;
import com.pickup.sysowner.entity.GnItem;
import com.pickup.sysowner.entity.GnItemCategory;
import com.pickup.sysowner.entity.GnLocationType;
import com.pickup.sysowner.entity.GnPayMethod;
import com.pickup.sysowner.entity.GnService;
import com.pickup.sysowner.entity.GnUom;
import com.pickup.sysowner.entity.GnVehicleSize;
import com.pickup.sysowner.entity.HrEmployee;
import com.pickup.sysowner.service.GnCountryService;
import com.pickup.sysowner.service.GnCurrencyService;
import com.pickup.sysowner.service.GnItemCategoryService;
import com.pickup.sysowner.service.GnItemService;
import com.pickup.sysowner.service.GnItemServiceService;
import com.pickup.sysowner.service.GnLocationTypeService;
import com.pickup.sysowner.service.GnPayMethodService;
import com.pickup.sysowner.service.GnServiceService;
import com.pickup.sysowner.service.GnUomService;
import com.pickup.sysowner.service.GnVehicleSizeService;
import com.pickup.sysowner.service.HrEmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/def")
public class SysOwnerDefController {

	final Logger logger = LoggerFactory.getLogger(SysOwnerDefController.class);

	@Autowired
	private GnCountryService countryService;

	@Autowired
	private GnCurrencyService currencyService;

	@Autowired
	private GnItemService gnItemService;

	@Autowired
	private GnItemCategoryService gnItemCategoryService;

	@Autowired
	private GnItemServiceService gnItemServiceService;

	@Autowired
	private GnLocationTypeService gnLocationTypeService;

	@Autowired
	private GnPayMethodService gnPayMethodService;

	@Autowired
	private GnServiceService gnServiceService;

	@Autowired
	private GnUomService gnUomService;

	@Autowired
	private GnVehicleSizeService gnVehicleSizeService;

	@Autowired
	private HrEmployeeService hrEmployeeService;

	/***********************************************
	 * Country API
	 ******************************************************************/

	@GetMapping(value = "/country", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "List of countries", notes = "The Api Returns List of Countries", response = GnCountry.class)
	public ResponseEntity<List<GnCountry>> findAllCountry() {
		List<GnCountry> lst = this.countryService.findAll();
		if (lst == null) {
			logger.warn("No Data Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/country/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Country", notes = "The Api Returns a country object of id", response = GnCountry.class)
	public ResponseEntity<GnCountry> findByIdCountry(@ApiParam(value="Country Id",required=true)
			@PathVariable Integer id) {
		GnCountry entity = this.countryService.findById(id);
		if (entity == null) {
			logger.warn("Record Not Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@PostMapping(value = "/country", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnCountry> createCountry(@RequestBody GnCountry entity) {
		GnCountry body = this.countryService.create(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}

	@PutMapping(value = "/country/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnCountry> updateCountry(@RequestBody GnCountry body, @PathVariable Integer id) {
		body.setId(id);
		this.countryService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@DeleteMapping(value = "/country/{id}")
	public ResponseEntity<String> deleteCountry(@PathVariable Integer id) {
		GnCountry country = this.countryService.findById(id);
		if (country == null) {
			logger.warn("Cannot delete.Record Not Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Country Not Found");
		}
		String result = this.countryService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/***********************************************
	 * Currency API
	 ******************************************************************/
	@GetMapping(value = "/currency", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<GnCurrency>> findAllCurrency() {
		List<GnCurrency> lst = this.currencyService.findAll();
		if (lst == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/currency/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnCurrency> findByIdCurrency(@PathVariable Integer id) {
		GnCurrency body = this.currencyService.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@PostMapping(value = "/currency", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnCurrency> createCurrency(@RequestBody GnCurrency body) {
		GnCurrency entity = this.currencyService.create(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@PutMapping(value = "/currency/{id}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnCurrency> updateCurrency(@RequestBody GnCurrency body, @PathVariable Integer id) {
		GnCurrency entity = this.currencyService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@DeleteMapping(value = "/currency/{id}")
	public ResponseEntity<String> deleteCurrency(@PathVariable Integer id) {
		String result = this.currencyService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/***********************************************
	 * Item API
	 ******************************************************************/
	@GetMapping(value = "/item", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<GnItem>> findAllItem() {
		List<GnItem> lst = this.gnItemService.findAll();
		if (lst == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/item/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnItem> findByIdItem(@PathVariable Integer id) {
		GnItem body = this.gnItemService.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@PostMapping(value = "/item", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnItem> createItem(@RequestBody GnItem body) {
		GnItem entity = this.gnItemService.create(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@PutMapping(value = "/item/{id}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnItem> updateItem(@RequestBody GnItem body, @PathVariable Integer id) {
		GnItem entity = this.gnItemService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@DeleteMapping(value = "/item/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable Integer id) {
		String result = this.gnItemService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/***********************************************
	 * Item Category API
	 ******************************************************************/
	@GetMapping(value = "/item-category", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<GnItemCategory>> findAllItemCategory() {
		List<GnItemCategory> lst = this.gnItemCategoryService.findAll();
		if (lst == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/item-category/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnItemCategory> findByIdItemCategory(@PathVariable Integer id) {
		GnItemCategory body = this.gnItemCategoryService.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@PostMapping(value = "/item-category", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnItemCategory> createItemCategory(@RequestBody GnItemCategory body) {
		GnItemCategory entity = this.gnItemCategoryService.create(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@PutMapping(value = "/item-category/{id}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnItemCategory> updateItemCategory(@RequestBody GnItemCategory body,
			@PathVariable Integer id) {
		GnItemCategory entity = this.gnItemCategoryService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@DeleteMapping(value = "/item-category/{id}")
	public ResponseEntity<String> deleteItemCategory(@PathVariable Integer id) {
		String result = this.gnItemCategoryService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/***********************************************
	 * Item Service API
	 ******************************************************************/
	@GetMapping(value = "/item-service", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<com.pickup.sysowner.entity.GnItemService>> findAllItemService() {
		List<com.pickup.sysowner.entity.GnItemService> lst = this.gnItemServiceService.findAll();
		if (lst == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}
	@GetMapping(value = "/item-service/item/{itemId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<com.pickup.sysowner.entity.GnItemService>> findItemServiceByItemId(@PathVariable Integer itemId) {
		List<com.pickup.sysowner.entity.GnItemService> lst = this.gnItemServiceService.findByItemId(itemId);
		if (lst == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}


	@GetMapping(value = "/item-service/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<com.pickup.sysowner.entity.GnItemService> findByIdItemService(@PathVariable Integer id) {
		com.pickup.sysowner.entity.GnItemService body = this.gnItemServiceService.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@PostMapping(value = "/item-service", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<com.pickup.sysowner.entity.GnItemService> createItemService(
			@RequestBody com.pickup.sysowner.entity.GnItemService body) {
		com.pickup.sysowner.entity.GnItemService entity = this.gnItemServiceService.create(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@PutMapping(value = "/item-service/{id}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<com.pickup.sysowner.entity.GnItemService> updateItemCategory(
			@RequestBody com.pickup.sysowner.entity.GnItemService body, @PathVariable Integer id) {
		com.pickup.sysowner.entity.GnItemService entity = this.gnItemServiceService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@DeleteMapping(value = "/item-service/{id}")
	public ResponseEntity<String> deleteItemService(@PathVariable Integer id) {
		String result = this.gnItemServiceService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/***********************************************
	 * Item Location Type API
	 ******************************************************************/
	@GetMapping(value = "/location-type", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<GnLocationType>> findAllLocationType() {
		List<GnLocationType> lst = this.gnLocationTypeService.findAll();
		if (lst == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/location-type/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnLocationType> findByIdLocationType(@PathVariable Integer id) {
		GnLocationType body = this.gnLocationTypeService.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@PostMapping(value = "/location-type", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnLocationType> createLocationType(@RequestBody GnLocationType body) {
		GnLocationType entity = this.gnLocationTypeService.create(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@PutMapping(value = "/location-type/{id}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnLocationType> updateLocationType(@RequestBody GnLocationType body,
			@PathVariable Integer id) {
		GnLocationType entity = this.gnLocationTypeService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@DeleteMapping(value = "/location-type/{id}")
	public ResponseEntity<String> deleteLocationType(@PathVariable Integer id) {
		String result = this.gnLocationTypeService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/***********************************************
	 * Item Pay method API
	 ******************************************************************/
	@GetMapping(value = "/pay-method", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<GnPayMethod>> findAllPayMethod() {
		List<GnPayMethod> lst = this.gnPayMethodService.findAll();
		if (lst == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/pay-method/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnPayMethod> findByIdPayMethod(@PathVariable Integer id) {
		GnPayMethod body = this.gnPayMethodService.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@PostMapping(value = "/pay-method", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnPayMethod> createPayMethod(@RequestBody GnPayMethod body) {
		GnPayMethod entity = this.gnPayMethodService.create(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@PutMapping(value = "/pay-method/{id}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnPayMethod> updateLocationType(@RequestBody GnPayMethod body, @PathVariable Integer id) {
		GnPayMethod entity = this.gnPayMethodService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@DeleteMapping(value = "/pay-method/{id}")
	public ResponseEntity<String> deletePayMethod(@PathVariable Integer id) {
		String result = this.gnPayMethodService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/***********************************************
	 * Service definition API
	 ******************************************************************/
	@GetMapping(value = "/service", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<GnService>> findAllService() {
		List<GnService> lst = this.gnServiceService.findAll();
		if (lst == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/service/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnService> findByIdService(@PathVariable Integer id) {
		GnService body = this.gnServiceService.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@PostMapping(value = "/service", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnService> createService(@RequestBody GnService body) {
		GnService entity = this.gnServiceService.create(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@PutMapping(value = "/service/{id}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnService> updateService(@RequestBody GnService body, @PathVariable Integer id) {
		GnService entity = this.gnServiceService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@DeleteMapping(value = "/service/{id}")
	public ResponseEntity<String> deleteService(@PathVariable Integer id) {
		String result = this.gnServiceService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/***********************************************
	 * UOM Unit of measuring API
	 ******************************************************************/
	@GetMapping(value = "/uom", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<GnUom>> findAllUom() {
		List<GnUom> lst = this.gnUomService.findAll();
		if (lst == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/uom/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnUom> findByIdUom(@PathVariable Integer id) {
		GnUom body = this.gnUomService.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@PostMapping(value = "/uom", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnUom> createUom(@RequestBody GnUom body) {
		GnUom entity = this.gnUomService.create(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@PutMapping(value = "/uom/{id}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnUom> updateService(@RequestBody GnUom body, @PathVariable Integer id) {
		GnUom entity = this.gnUomService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@DeleteMapping(value = "/uom/{id}")
	public ResponseEntity<String> deleteUom(@PathVariable Integer id) {
		String result = this.gnUomService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/***********************************************
	 * Vehicle size API
	 ******************************************************************/
	@GetMapping(value = "/vehicle-size", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<GnVehicleSize>> findAllVehicleSize() {
		List<GnVehicleSize> lst = this.gnVehicleSizeService.findAll();
		if (lst == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/vehicle-size/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnVehicleSize> findByIdVehicleSize(@PathVariable Integer id) {
		GnVehicleSize body = this.gnVehicleSizeService.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@PostMapping(value = "/vehicle-size", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnVehicleSize> createVehicleSize(@RequestBody GnVehicleSize body) {
		GnVehicleSize entity = this.gnVehicleSizeService.create(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@PutMapping(value = "/vehicle-size/{id}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GnVehicleSize> updateVehicleSize(@RequestBody GnVehicleSize body, @PathVariable Integer id) {
		GnVehicleSize entity = this.gnVehicleSizeService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@DeleteMapping(value = "/vehicle-size/{id}")
	public ResponseEntity<String> deleteVehicleSize(@PathVariable Integer id) {
		String result = this.gnVehicleSizeService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	/***********************************************
	 * HR Employee API
	 ******************************************************************/
	@GetMapping(value = "/employee", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<HrEmployee>> findAllEmployee() {
		List<HrEmployee> lst = this.hrEmployeeService.findAll();
		if (lst == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lst);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lst);
	}

	@GetMapping(value = "/employee/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<HrEmployee> findByIdEmployee(@PathVariable Integer id) {
		HrEmployee body = this.hrEmployeeService.findById(id);
		if (body == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
		}
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

	@PostMapping(value = "/employee", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<HrEmployee> createEmployee(@RequestBody HrEmployee body) {
		HrEmployee entity = this.hrEmployeeService.create(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@PutMapping(value = "/employee/{id}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<HrEmployee> updateEmployee(@RequestBody HrEmployee body, @PathVariable Integer id) {
		HrEmployee entity = this.hrEmployeeService.update(body, id);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@DeleteMapping(value = "/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
		String result = this.hrEmployeeService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
