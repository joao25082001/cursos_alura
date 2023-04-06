package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")

public class pacienteController {
    @Autowired
    private pacienteRepository repository;
    @PostMapping
    void Cadastrarpaciente(@RequestBody @Valid DadosCadastroPaciente dadospaciente) {
        System.out.println(dadospaciente);
        repository.save(new paciente(dadospaciente));
    }
    @GetMapping
    public List<ListaPacientes> listaPaciente(){
        return repository.findAll().stream().map(ListaPacientes::new).toList();

    }
    @PutMapping
    @Transactional
    public  void atualizarPaciente(@RequestBody @Valid DadosAtualizarPaciente dadospaciente ){
        var paciente = repository.getReferenceById(dadospaciente.id());
        paciente.atualizarInfo(dadospaciente);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluirPaciente(@PathVariable Long id){
        repository.deleteById(id);

    }
}
