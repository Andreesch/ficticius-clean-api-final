package br.ficticius.clean.DTO;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class VehicleFilterOptionsDTO {
	@NotNull(message = "{vehicle.list.fuelPrice.not.empty}")
	private Double fuelPrice;
	
	private Double kmInsideCity;
	
	private Double kmOutsideCity;

}
