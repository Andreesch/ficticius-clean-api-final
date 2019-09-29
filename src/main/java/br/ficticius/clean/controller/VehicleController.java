package br.ficticius.clean.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ficticius.clean.DTO.ListVehicleDTOResponse;
import br.ficticius.clean.DTO.NewVehicleDTO;
import br.ficticius.clean.DTO.VehicleFilterOptionsDTO;
import br.ficticius.clean.model.Vehicle;
import br.ficticius.clean.services.VehicleService;

@RestController
@RequestMapping("vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@CrossOrigin
	@PostMapping("/criar-veiculo")
	public ResponseEntity<Vehicle> newVehicle(@RequestBody @Valid NewVehicleDTO vehicle) {
		Vehicle newVehicle = vehicleService.saveNewVehicle(NewVehicleDTO.parseToPersist(vehicle));
		return new ResponseEntity<Vehicle>(newVehicle, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PostMapping("/listar-veiculos")
	public ResponseEntity<List<ListVehicleDTOResponse>> listVehiclesByUserOptions(@RequestBody @Valid VehicleFilterOptionsDTO vehicleOptions) {
		List<ListVehicleDTOResponse> response = vehicleService.findByPriceOptionAndDistance(vehicleOptions);
		return new ResponseEntity<List<ListVehicleDTOResponse>>(response, HttpStatus.OK);
		
	}

}
