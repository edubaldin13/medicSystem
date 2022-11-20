package projectApi.api.paciente;

import jakarta.validation.constraints.NotNull;
import projectApi.api.endereco.DadosEndereco;

public record DadosAtualizacaoPacientes(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
