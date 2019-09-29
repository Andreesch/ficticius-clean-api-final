package br.ficticius.clean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ficticius.clean.DTO.ListVehicleDTOResponse;
import br.ficticius.clean.DTO.VehicleFilterOptionsDTO;
import br.ficticius.clean.model.Vehicle;
import br.ficticius.clean.repository.VehicleRepository;

@Service
public class VehicleService {
	private final VehicleRepository vehicleRepository;
	
	@Autowired
	public VehicleService(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}
	
	public Vehicle saveNewVehicle(Vehicle Vehicle) {
		return vehicleRepository.saveAndFlush(Vehicle);
	}
	
	public List<ListVehicleDTOResponse> findByPriceOptionAndDistance(VehicleFilterOptionsDTO vehicleFilterOptionsVO) {
		return vehicleRepository.findByPriceOptionAndDistance(vehicleFilterOptionsVO.getFuelPrice(), vehicleFilterOptionsVO.getKmInsideCity(), vehicleFilterOptionsVO.getKmOutsideCity());
	}
}
