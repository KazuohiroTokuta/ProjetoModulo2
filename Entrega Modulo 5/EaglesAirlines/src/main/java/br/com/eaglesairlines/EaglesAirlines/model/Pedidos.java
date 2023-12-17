package br.com.eaglesairlines.EaglesAirlines.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedidos {
	
	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num_pedido;
	private String dt_pedido;
	private String forma_pgmto;
	
	@ManyToOne
	@JoinColumn(name = "passageiro_id")
	private Passageiros passageiro;

	//toString
	@Override
	public String toString() {
		return "Pedidos [num_pedido=" + num_pedido + ", dt_pedido=" + dt_pedido + ", forma_pgmto=" + forma_pgmto
				+ ", passageiro=" + passageiro + "]";
	}
	
	

}
