package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import lombok.NoArgsConstructor;

import med.voll.api.endereco.Endereco;

import med.voll.api.paciente.ListaPacientes;
import med.voll.api.paciente.paciente;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Table(name = "medico")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "idmedico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmedico;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private boolean ativo;
    @OneToMany
    @JoinColumn
    @NotNull
    private List<paciente> pacientes;
    public List<paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<paciente> pacientes) {
        this.pacientes = pacientes;
    }


    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.crm = dados.crm();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());

    }


    public void atualizarInformacoes(AtualizarMedico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInfo(dados.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }


}