package projectApi.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import projectApi.api.endereco.DadosEndereco;

public record DadosCadastroPacientes(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotNull
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{9,12}")
        String cpf,
        @NotNull
        @Valid
        DadosEndereco endereco){}
