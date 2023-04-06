package med.voll.api.medico;


public record dadosDetalhamentoMedico(
        Long idmedico,
        String nome,

        String email,

        String telefone,


        String crm,

        Especialidade especialidade,

        med.voll.api.endereco.Endereco endereco
) {
    public  dadosDetalhamentoMedico(Medico medico){

        this(
                medico.getIdmedico(), medico.getNome(), medico.getEmail(),medico.getTelefone(), medico.getCrm(),
                medico.getEspecialidade(), medico.getEndereco()
        );
    }

}
