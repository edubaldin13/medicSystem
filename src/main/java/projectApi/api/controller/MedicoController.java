package projectApi.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import projectApi.api.medico.*;

//every function/method that uses db need the @Transactional annotation
@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicos dadosMedicos){
        //using request body to set that the json is the response received from the post call
        repository.save(new Medico(dadosMedicos));
    }
    @GetMapping
    public Page<DadosListagemMedicos> listar(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable pageable){
        return repository.findAll(pageable).map(DadosListagemMedicos::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicos dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }
}
