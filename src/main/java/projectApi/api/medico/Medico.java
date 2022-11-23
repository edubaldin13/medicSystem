package projectApi.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import projectApi.api.endereco.DadosEndereco;
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

    private Boolean ativo;

    public Medico(DadosCadastroMedicos dadosMedicos) {
            this.ativo = true;
            this.nome = dadosMedicos.nome();
            this.email = dadosMedicos.email();
            this.telefone = dadosMedicos.telefone();
            this.crm = dadosMedicos.crm();
            this.especialidade = dadosMedicos.especialidade();
            this.endereco = new Endereco(dadosMedicos.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedicos dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
