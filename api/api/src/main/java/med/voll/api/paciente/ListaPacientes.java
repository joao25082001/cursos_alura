package med.voll.api.paciente;

public record ListaPacientes(Long id,String nome, String email) {
    public ListaPacientes(paciente paciente) {
        this(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail()
        );
    }
}