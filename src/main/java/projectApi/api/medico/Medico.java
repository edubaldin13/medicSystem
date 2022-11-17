package projectApi.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import projectApi.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private EspecialidadeEnum especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedicos dadosMedicos) {
            this.nome = dadosMedicos.nome();
            this.email = dadosMedicos.email();
            this.telefone = dadosMedicos.telefone();
            this.crm = dadosMedicos.crm();
            this.especialidade = dadosMedicos.especialidade();
            this.endereco = new Endereco(dadosMedicos.endereco());
    }
}
