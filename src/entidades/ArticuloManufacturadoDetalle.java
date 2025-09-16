package entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class ArticuloManufacturadoDetalle {
    private Long id;
    private Integer cantidad;
    private ArticuloInsumo insumo;

    public ArticuloManufacturadoDetalle(Object o, int i, ArticuloInsumo carne) {
    }
}
