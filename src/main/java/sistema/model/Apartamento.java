package sistema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apartamento {
    private int id, nroDaPorta, qtdeQuartos;    
    private String tipo;    
}