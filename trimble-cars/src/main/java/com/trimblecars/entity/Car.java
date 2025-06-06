package com.trimblecars.entity;

	import jakarta.persistence.*;
	import lombok.*;

	@Entity
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
public class Car {

	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String model;

	    @Column(unique = true, nullable = false)
	    private String numberPlate;

	    @Enumerated(EnumType.STRING)
	    private CarStatus status; // IDLE, ON_LEASE, ON_SERVICE

	    @ManyToOne
	    @JoinColumn(name = "owner_id")
	    private User owner;
	

}
