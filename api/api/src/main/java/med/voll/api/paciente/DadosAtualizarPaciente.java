package med.voll.api.paciente;


import org.jetbrains.annotations.NotNull;

public record DadosAtualizarPaciente(
@NotNull
        Long id,
        String email) {

}
