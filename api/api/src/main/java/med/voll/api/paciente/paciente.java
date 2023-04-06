package med.voll.api.paciente;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.Medico;
import org.aspectj.apache.bcel.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Table(name = "paciente")
@Entity(name = "paciente")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;


    @ManyToOne
    @JoinColumn(name = "Medico")
    private Medico medico;

    public Medico getmedico() {
        return medico;
    }

    public void setmedico(Medico medico) {
        this.medico = medico;
    }
    public paciente(DadosCadastroPaciente dadospaciente) {

        this.nome = dadospaciente.nome();
        this.email = dadospaciente.email();
        this.telefone = dadospaciente.telefone();
        this.cpf = dadospaciente.cpf();
        this.endereco = new Endereco(dadospaciente.endereco());
        this.medico = dadospaciente.medico();
    }


    public void atualizarInfo(DadosAtualizarPaciente dadospaciente) {
        if (dadospaciente.email() != null) {
            this.email = dadospaciente.email();
        }
    }

}
