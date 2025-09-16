package entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Articulo {
    @EqualsAndHashCode.Include
    protected Long id;
    protected String denominacion;
    protected Double precioVenta;
    protected Categoria categoria;
    protected UnidadMedida unidadMedida;
    protected List<Imagen> imagenes = new ArrayList<>();
}
