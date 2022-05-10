package com.techgeeknext.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employees")
@NamedQuery(name = "Employee.findById", query = "FROM Employee WHERE id = ?1")
@NamedQuery(name = "Employee.findByName", query = "FROM Employee WHERE name = ?1")
@NamedQuery(name = "Employee.findByRole", query = "SELECT e FROM Employee e WHERE e.role = ?1")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "role")
	private String role;
}
