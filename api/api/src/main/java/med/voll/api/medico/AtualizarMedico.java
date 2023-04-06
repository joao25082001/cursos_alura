package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;
import org.jetbrains.annotations.NotNull;

public record AtualizarMedico(
        @NotNull
        Long id,
        String nome,
        DadosEndereco endereco

) {


}
