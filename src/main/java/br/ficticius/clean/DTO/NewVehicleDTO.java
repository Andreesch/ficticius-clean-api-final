package br.ficticius.clean.DTO;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.ficticius.clean.model.Vehicle;
import lombok.Data;

@Data
public class NewVehicleDTO {
	@NotBlank(message = "{vehicle.name.not.blank}")
	private String name;
	
	private String brand;
	
	private String model;
	
	private Integer manufactureYear;
	
	@NotNull(message = "{vehicle.kmInsideCity.not.empty}")
	@DecimalMin(value= "1", message="{vehicle.kmInsideCity.invalidValue}")
	private Double kmInsideCity;
	
	@NotNull(message = "{vehicle.kmOutsideCity.not.empty}")
	@DecimalMin(value= "1", message="{vehicle.kmOutsideCity.invalidValue}")
	private Double kmOutsideCity;
	
	/*
		Método responsável pelo parser de um veículo-obj provindo da request API Level.
		Optei pelo padrão DTO pois há campos que não são necessários na resposta da request.
		Utilizei o campo lastUpdate como exemplo.
	*/
	public static Vehicle parseToPersist(NewVehicleDTO vehicleDTO) {
		Vehicle newVehicle = new Vehicle();
		newVehicle.setName(vehicleDTO.getName());
		newVehicle.setBrand(vehicleDTO.getBrand());
		newVehicle.setModel(vehicleDTO.getModel());
		newVehicle.setManufactureYear(vehicleDTO.getManufactureYear());
		newVehicle.setKmInsideCity(vehicleDTO.getKmInsideCity());
		newVehicle.setKmOutsideCity(vehicleDTO.getKmOutsideCity());
		newVehicle.setLastUpdate(new Date());
		
		return newVehicle;
		
	}

}
