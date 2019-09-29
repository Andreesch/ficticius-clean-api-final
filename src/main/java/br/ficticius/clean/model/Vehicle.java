package br.ficticius.clean.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;
import lombok.NoArgsConstructor;

@NamedQuery(name = Vehicle.LIST_VEHICLE_BY_FILTER_OPTIONS, query = "select new br.ficticius.clean.DTO.ListVehicleDTOResponse("
		+ "o.id, o.name, o.brand, o.model, o.manufactureYear, o.kmInsideCity, o.kmOutsideCity, o.lastUpdate, "
		+ "(((:kmInsideCity / o.kmInsideCity) + (:kmOutsideCity / o.kmOutsideCity)) * :price) as PRICE) "
		+ "FROM Vehicle o "
		+ "ORDER BY PRICE ")
@Data
@Entity
@NoArgsConstructor
public class Vehicle {
	public static final String LIST_VEHICLE_BY_FILTER_OPTIONS = "Vehicle.listVehicleByFilterOptions";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String brand;
	
	private String model;
	
	private Integer manufactureYear;
	
	private Double kmInsideCity;
	
	private Double kmOutsideCity;
	
	private Date lastUpdate;
}
