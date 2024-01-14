using System.ComponentModel.DataAnnotations;

namespace EaglesAirlines.Models
{
    public class Passageiros
    {
        [Key]
        public string CPF { get; set; }

        [Required(ErrorMessage = "Nome é obrigatório")]
        [MaxLength (40, ErrorMessage = "Max de 40 caracteres")]
        public string nome_passageiro { get; set; }
        public string passaporte { get; set; }
        public string email { get; set; }
        public string telefone { get; set; }


    }
}
