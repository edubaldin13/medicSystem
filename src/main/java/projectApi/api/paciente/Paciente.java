package projectApi.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import projectApi.api.endereco.Endereco;
@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPacientes dadosCadastroPacientes){
        this.nome = dadosCadastroPacientes.nome();
        this.email = dadosCadastroPacientes.email();
        this.telefone = dadosCadastroPacientes.telefone();
        this.cpf = dadosCadastroPacientes.cpf();
        this.endereco = new Endereco(dadosCadastroPacientes.endereco());
    }

    public void atualizarInformacao(DadosAtualizacaoPacientes dados) {
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
}
