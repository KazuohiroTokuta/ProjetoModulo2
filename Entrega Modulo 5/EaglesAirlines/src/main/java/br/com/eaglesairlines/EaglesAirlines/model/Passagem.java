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
	
		
		
		
		public Passagem(Long id_passagem, Long quantidade, String origem, String destino, double valor_passagem,
				Pedidos pedido) {
			super();
			this.id_passagem = id_passagem;
			this.quantidade = quantidade;
			this.origem = origem;
			this.destino = destino;
			this.valor_passagem = valor_passagem;
			this.pedido = pedido;
		}


		public Passagem() {
			// TODO Auto-generated constructor stub
		}


		@ManyToOne
		@JoinColumn(name = "pedido_id")
		private Pedidos pedido;


		@Override
		public String toString() {
			return "Passagem [id_passagem=" + id_passagem + ", quantidade=" + quantidade + ", origem=" + origem
					+ ", destino=" + destino + ", valor_passagem=" + valor_passagem + ", pedido=" + pedido + "]";
		}


		public Long getId_passagem() {
			return id_passagem;
		}


		public void setId_passagem(Long id_passagem) {
			this.id_passagem = id_passagem;
		}


		public Long getQuantidade() {
			return quantidade;
		}


		public void setQuantidade(Long quantidade) {
			this.quantidade = quantidade;
		}


		public String getOrigem() {
			return origem;
		}


		public void setOrigem(String origem) {
			this.origem = origem;
		}


		public String getDestino() {
			return destino;
		}


		public void setDestino(String destino) {
			this.destino = destino;
		}


		public double getValor_passagem() {
			return valor_passagem;
		}


		public void setValor_passagem(double valor_passagem) {
			this.valor_passagem = valor_passagem;
		}


		public Pedidos getPedido() {
			return pedido;
		}


		public void setPedido(Pedidos pedido) {
			this.pedido = pedido;
		}
		
		
		
		
	
			
		//toString
		
		

}
