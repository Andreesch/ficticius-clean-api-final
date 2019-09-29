package br.ficticius.clean.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ficticius.clean.DTO.ListVehicleDTOResponse;
import br.ficticius.clean.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	@Query(name = Vehicle.LIST_VEHICLE_BY_FILTER_OPTIONS)
	public List<ListVehicleDTOResponse> findByPriceOptionAndDistance(
			@Param("price") Double fuelPrice,
			@Param("kmInsideCity") Double kmInsideCity,
			@Param("kmOutsideCity") Double kmOutsideCity);
}
