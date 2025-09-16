import entidades.*;
import repositorios.InMemoryRepository;

import java.sql.SQLOutput;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    //Creamos los repositorios
        InMemoryRepository<Categoria> categoriaRepo = new InMemoryRepository<>();
        InMemoryRepository<UnidadMedida> unidadRepo = new InMemoryRepository<>();
        InMemoryRepository<ArticuloInsumo> insumoRepo = new InMemoryRepository<>();
        InMemoryRepository<ArticuloManufacturado> manufacturadoRepo = new InMemoryRepository<>();
        InMemoryRepository<Imagen> imagenRepo = new InMemoryRepository<>();
        InMemoryRepository<ArticuloManufacturadoDetalle> detalleRepo = new InMemoryRepository<>();

        //Creamos las categorias
        Categoria pizzas = categoriaRepo.save(new Categoria(null, "Pizzas"));
        Categoria sandwich = categoriaRepo.save(new Categoria(null, "sandwich"));
        Categoria lomos = categoriaRepo.save(new Categoria(null, "Lomos"));
        Categoria insumos = categoriaRepo.save(new Categoria(null, "Insumos"));

        //Creamos las unidades de medida
        UnidadMedida kg = unidadRepo.save(new UnidadMedida(null, "Kilogramos"));
        UnidadMedida lt = unidadRepo.save(new UnidadMedida(null, "Litros"));
        UnidadMedida gr = unidadRepo.save(new UnidadMedida(null, "Gramos"));

        //Creamos los articulos
        ArticuloInsumo sal = insumoRepo.save (new ArticuloInsumo(null, "Sal", 50.0, insumos, gr, true, 100, 1000, 30.0));
        ArticuloInsumo aceite = insumoRepo.save (new ArticuloInsumo(null, "Aceite", 200.0, insumos, lt, true, 50, 200, 150.0));
        ArticuloInsumo carne = insumoRepo.save(new ArticuloInsumo(null, "Carne", 1200.0, insumos, kg, true, 80, 300, 1000.0));
        ArticuloInsumo harina = insumoRepo.save(new ArticuloInsumo(null, "Harina", 500.0, insumos, kg, true, 150, 1000, 300.0));

        //Creamos las imagenes
        Imagen imgPizza1 = imagenRepo.save(new Imagen(null, "hawaina1.jgp", null));
        Imagen imgPizza2 = imagenRepo.save(new Imagen(null, "hawaina2.jgp", null));
        Imagen imgPizza3 = imagenRepo.save(new Imagen(null, "hawaina3.jpg", null));
        Imagen imgLomo1 = imagenRepo.save(new Imagen(null, "lomo1.jpg", null));
        Imagen imgLomo2 = imagenRepo.save(new Imagen(null,"lomo2.jpg", null));
        Imagen imgLomo3 = imagenRepo.save(new Imagen(null, "lomo3.jpg", null));

        //Creamos los detalles
        ArticuloManufacturadoDetalle detPizza1 = detalleRepo.save(new ArticuloManufacturadoDetalle(null, 1, sal));
        ArticuloManufacturadoDetalle detPizza2 = detalleRepo.save(new ArticuloManufacturadoDetalle(null, 2, harina));
        ArticuloManufacturadoDetalle detPizza3 = detalleRepo.save(new ArticuloManufacturadoDetalle(null, 1, aceite));
        ArticuloManufacturadoDetalle detLomo1 = detalleRepo.save(new ArticuloManufacturadoDetalle(null, 1, sal));
        ArticuloManufacturadoDetalle detLomo2 = detalleRepo.save(new ArticuloManufacturadoDetalle(null, 1, aceite));
        ArticuloManufacturadoDetalle detLomo3 = detalleRepo.save(new ArticuloManufacturadoDetalle(null, 1, carne));

        //Creamos los manufacturados
        ArticuloManufacturado pizzaHawaina = new ArticuloManufacturado();
        pizzaHawaina.setDenominacion("Pizza Hawaina");
        pizzaHawaina.setPrecioVenta(2500.0);
        pizzaHawaina.setCategoria(pizzas);
        pizzaHawaina.setUnidadMedida(kg);
        pizzaHawaina.getImagenes().addAll(List.of(imgPizza1, imgPizza2, imgPizza3));
        pizzaHawaina.getDetalles().addAll(List.of(detPizza1, detPizza2, detPizza3));
        manufacturadoRepo.save(pizzaHawaina);

        ArticuloManufacturado lomoCompleto = new ArticuloManufacturado();
        lomoCompleto.setDenominacion("Lomo Completo");
        lomoCompleto.setPrecioVenta(3000.0);
        lomoCompleto.setCategoria(lomos);
        lomoCompleto.setUnidadMedida(kg);
        lomoCompleto.getImagenes().addAll(List.of(imgLomo1, imgLomo2, imgLomo3));
        lomoCompleto.getDetalles().addAll(List.of(detLomo1, detLomo2, detLomo3));

        //Mostrar
        System.out.println("Categorias: ");
        categoriaRepo.findAll().forEach(System.out :: println);

        System.out.println("\nArtículos insumo: ");
        insumoRepo.findAll().forEach(System.out :: println);

        System.out.println("\nArtículos manufacturados: ");
        manufacturadoRepo.findAll().forEach(System.out :: println);

        System.out.println("\nBuscar manufactorado por ID (1): ");
        manufacturadoRepo.findById(1L).ifPresent(System.out :: println);

        System.out.println("\nActualizar manufacturado por ID (1): ");
        manufacturadoRepo.findById(1L).ifPresent(m -> {
            m.setPrecioVenta(2700.0);
            manufacturadoRepo.genericUpdate(m.getId(), m);
        });
        manufacturadoRepo.findAll().forEach(System.out :: println);

        System.out.println("\nEliminar manufacturado por ID (2): ");
        manufacturadoRepo.genericDelete(2L);
        manufacturadoRepo.findAll().forEach(System.out :: println);

    }
}