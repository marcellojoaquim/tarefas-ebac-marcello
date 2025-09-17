package com.mjsilva.cliente.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name="Cliente", description = "cliente")
public class Cliente {
	
	@Id
	@Schema(description = "Identificador unico")
	private String id;
	
	@NotNull
	@Size(min=5, max=150)
	@Schema(description="Nome", minLength = 5, maxLength = 150, nullable = false)
	private String nome;
	
	
	@NotNull
	@Indexed(unique = true, background = true)
	@Schema(description = "CPF", nullable = false)
	private Long cpf;
	
	
	@NotNull
	@Schema(description = "Telefone", nullable = false)
	private Long telefone;
	
	
	@NotNull
	@Size(min=5, max=150)
	@Indexed(unique = true, background = true)
	@Schema(description="Email", minLength = 5, maxLength = 150, nullable = false)
	@Pattern(regexp = ".+@.+\\..+", message = "Email inválido")
	private String email;
	
	
	@NotNull
	@Size(min = 5, max = 50)
	@Schema(description="Endereco", minLength = 1, maxLength=50, nullable = false)
    private String endereco;
    
	@NotNull
	@Schema(description="Numero residencial", nullable = false) 
    private Integer numero;
    
	@NotNull
	@Size(min = 5, max = 50)
	@Schema(description="Cidade", minLength = 1, maxLength=50, nullable = false)
    private String cidade;
    
	@NotNull
	@Size(min = 5, max = 50)
	@Schema(description="Estado", minLength = 1, maxLength=50, nullable = false)
    private String estado;

}
