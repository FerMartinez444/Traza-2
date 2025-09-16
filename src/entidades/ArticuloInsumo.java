package entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)

public class ArticuloInsumo extends Articulo{
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Boolean esParaElaborar;

    public ArticuloInsumo(Object o, String sal, double v, Categoria insumos, UnidadMedida gr, boolean b, int i, int i1, double v1) {
    }
}
