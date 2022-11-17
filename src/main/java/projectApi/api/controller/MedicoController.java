package projectApi.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import projectApi.api.medico.DadosCadastroMedicos;
import projectApi.api.medico.Medico;
import projectApi.api.medico.MedicoRepository;

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
}
