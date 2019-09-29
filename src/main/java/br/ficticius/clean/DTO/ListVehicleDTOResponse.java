package br.ficticius.clean.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ListVehicleDTOResponse {
	private Long id;
	private String name;
	private String brand;
	private String model;
	private Integer manufactureYear;
	private Double kmInsideCity;
	private Double kmOutsideCity;
	private Date lastUpdate;
	private Double travelCost;

}
