package med.voll.api.medico;

public record DadosListaMedico(Long idmedico, String nome, String email,String crm, Especialidade especialidade) {
    public DadosListaMedico(Medico medico){
        this(
                medico.getIdmedico(),
                medico.getNome(),
                medico.getCrm(),
                medico.getEmail(),
                medico.getEspecialidade()
        );
    }

}
