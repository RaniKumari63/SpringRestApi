package com.suchiit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="officer")
public class Officer {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
private String name;
@JoinColumn(name="department_id")
@OneToOne
private Department department;
}
