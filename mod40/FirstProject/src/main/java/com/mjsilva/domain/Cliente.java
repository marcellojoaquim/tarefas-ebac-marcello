package com.mjsilva.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
	@SequenceGenerator(name = "cliente_seq", sequenceName = "seq_cliente", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "nome", nullable = false, length= 150)
	private String name;
	
	@Column(name = "cpf", nullable = false, unique=true)
	private Long cpf;
	
	@Column(name = "tel", nullable = false, length= 20)
	private Long tel;
	
	@Column(name = "email", nullable = false, length= 50)
	private String email;
	
	@Column(name = "ende", nullable = false, length= 150)
	private String end;
	
	@Column(name = "num", nullable = false)
	private Integer numero;
	
	@Column(name = "cid", nullable = false, length= 150)
	private String cidade;
	
	@Column(name = "estado", nullable = false, length= 150)
	private String estado;
}
