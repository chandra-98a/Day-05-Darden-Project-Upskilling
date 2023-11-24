package com.capgemini.SpringBootRest.Entity;

import org.hibernate.annotations.Tables;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="BioData")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="f_name",nullable=false)
	private String fName;
	@Column(name="l_name",nullable=false)
	private String lName;
	@Column(name="email",nullable=false, unique=true)
	private String email;
	
}
