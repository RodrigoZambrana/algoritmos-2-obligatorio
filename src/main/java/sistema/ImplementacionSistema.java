package sistema;

import dominio.ABBGenerico;
import dominio.Contador;
import dominio.ListaGenerica;
import dominio.Mercaderia;
import dominio.MercaderiaPorCodigo;
import dominio.MercaderiaPorId;
import dominio.ValidadorMercaderia;
import interfaz.*;

public class ImplementacionSistema implements Sistema  {

    private boolean inicializado;
    private int maxCentros;
    private ABBGenerico<MercaderiaPorId> mercaderiasPorId;
    private ABBGenerico<MercaderiaPorCodigo> mercaderiasPorCodigo;

    @Override
    public Retorno inicializarSistema(int maxCentros) {
        if (maxCentros <= 3) {
            return Retorno.error1("");
        }

        this.inicializado = true;
        this.maxCentros = maxCentros;
        this.mercaderiasPorId = new ABBGenerico<>();
        this.mercaderiasPorCodigo = new ABBGenerico<>();

        return Retorno.ok();
    }

    @Override
    public Retorno registrarMercaderia(String id, String codigo, String descripcion, boolean fragil, Categoria categoria) {
        if (ValidadorMercaderia.hayParametrosVaciosONull(id, codigo, descripcion, categoria)) {
            return Retorno.error1("");
        }

        if (!ValidadorMercaderia.codigoTieneFormatoValido(codigo)) {
            return Retorno.error2("");
        }

        Mercaderia buscada = new Mercaderia(id, codigo, descripcion, fragil, categoria);

        if (mercaderiasPorId.obtener(new MercaderiaPorId(buscada)) != null) {
            return Retorno.error3("");
        }

        if (mercaderiasPorCodigo.obtener(new MercaderiaPorCodigo(buscada)) != null) {
            return Retorno.error4("");
        }

        mercaderiasPorId.insertar(new MercaderiaPorId(buscada));
        mercaderiasPorCodigo.insertar(new MercaderiaPorCodigo(buscada));

        return Retorno.ok();
    }

    @Override
    public Retorno buscarMercaderiaPorId(String id) {
        if (id == null || id.trim().isEmpty()) {
            return Retorno.error1("");
        }

        Contador contador = new Contador();
        MercaderiaPorId mercaderiaPorId = mercaderiasPorId.obtenerConPasos(
                new MercaderiaPorId(new Mercaderia(id, "", "", false, Categoria.OTROS)),
                contador
        );

        if (mercaderiaPorId == null) {
            return Retorno.error2("");
        }

        return Retorno.ok(contador.getValor(), mercaderiaPorId.getMercaderia().toValorString());
    }

    @Override
    public Retorno listarMercaderiasPorIdAscendente() {
        ListaGenerica<MercaderiaPorId> lista = mercaderiasPorId.aplanarAscendente();
        return Retorno.ok(lista.serializarConSeparador("|"));
    }

    @Override
    public Retorno listarMercaderiasPorIdDescendente() {
        ListaGenerica<MercaderiaPorId> lista = mercaderiasPorId.aplanarDescendente();
        return Retorno.ok(lista.serializarConSeparador("|"));
    }

    @Override
    public Retorno buscarMercaderiaPorCodigo(String codigo) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarMercaderiasPorCodigoAscendente() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarMercaderiasPorCategoria(Categoria unaCategoria) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarCentroLogistico(String codigo, String nombre, String departamento, String direccion) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarConexion(String codigoOrigen, String codigoDestino, int distancia, int tiempo) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno redCentrosPorCantidadDeConexiones(String codigoOrigen, int cantidad) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno viajeCostoMinimoDistancia(String codigoOrigen, String codigoDestino) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno viajeCostoMinimoTiempo(String codigoOrigen, String codigoDestino) {
        return Retorno.noImplementada();
    }
}
