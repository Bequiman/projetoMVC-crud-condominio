package sistema.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proprietario {
    private int id;
    private String nome, telefone;
    private List<Apartamento> apart;
}


