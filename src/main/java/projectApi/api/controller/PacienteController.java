package projectApi.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import projectApi.api.paciente.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPacientes dadosPacientes){
        repository.save(new Paciente(dadosPacientes));
    }
    @GetMapping
    public Page<DadosListagemPacientes> listar(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable pageable){
        return repository.findAll(pageable).map(DadosListagemPacientes::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPacientes dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacao(dados);
    }
}
