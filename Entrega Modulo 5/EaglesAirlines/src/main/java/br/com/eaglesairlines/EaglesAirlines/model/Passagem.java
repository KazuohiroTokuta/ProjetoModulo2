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
@Table(name = "passagem")
public class Passagem {
	
	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id_passagem;
		private Long quantidade;
		private String origem;
		private String destino;
		private double valor_passagem;
		
		
		@ManyToOne
		@JoinColumn(name = "pedido_id")
		private Pedidos pedido;


		@Override
		public String toString() {
			return "Passagem [id_passagem=" + id_passagem + ", quantidade=" + quantidade + ", origem=" + origem
					+ ", destino=" + destino + ", valor_passagem=" + valor_passagem + ", pedido=" + pedido + "]";
		}
	
			
		//toString
		
		

}
