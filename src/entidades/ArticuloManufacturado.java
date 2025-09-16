package entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class ArticuloManufacturado extends Articulo {
    private Integer tiempoEstimadoMinutos;
    private String preparacion;
    private List<ArticuloManufacturadoDetalle> detalles = new ArrayList<>();

    public void addDetalle(ArticuloManufacturadoDetalle detalle){
        this.detalles.add(detalle);
    }
}
