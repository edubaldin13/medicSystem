package projectApi.api.medico;

import jakarta.validation.constraints.NotNull;
import projectApi.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedicos(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {}