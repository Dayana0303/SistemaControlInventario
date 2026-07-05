/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import excepciones.DatoInvalidoException;
import excepciones.ProductoDuplicadoException;
import modelo.Producto;
import repositorio.ProductoRepositorio;

public class ProductoNegocio {

    private ProductoRepositorio repositorio;
    private int siguienteId;

    public ProductoNegocio() {
        repositorio = new ProductoRepositorio();
        siguienteId = 1;
    }

    public ProductoRepositorio getRepositorio(){
        return repositorio;
    }
    
    public void agregarProducto(Producto producto)
            throws DatoInvalidoException, ProductoDuplicadoException{

        if(producto.getCodigo() == null|| producto.getCodigo().trim().isEmpty()){
            throw new DatoInvalidoException("El código es obligatorio.");
        }

        if(producto.getNombre() == null|| producto.getNombre().trim().isEmpty()){
            throw new DatoInvalidoException("El nombre es obligatorio.");
        }

        if(producto.getNombre().trim().length()<3){
            throw new DatoInvalidoException("El nombre debe tener mínimo 3 caracteres.");
        }

        if(producto.getCantidad()< 0) {
            throw new DatoInvalidoException("La cantidad debe ser mayor o igual a cero.");
        }

        if(producto.getPrecio()<=0){
            throw new DatoInvalidoException("El precio debe ser mayor que cero.");
        }

        if(producto.getCategoria()==null|| producto.getCategoria().trim().isEmpty()){
            throw new DatoInvalidoException("Debe seleccionar una categoría.");
        }

        if(repositorio.existeCodigo(producto.getCodigo())){
            throw new ProductoDuplicadoException("Ya existe un producto con ese código.");
        }

        producto.setId(siguienteId++);

        repositorio.agregar(producto);
    }
    public Producto buscarProducto(String codigo){

        return repositorio.buscarPorCodigo(codigo);
    }    
    public Producto buscarPorNombre(String nombre) {
        
        return repositorio.buscarPorNombre(nombre);
    }
    
    public void eliminarProducto(String codigo)throws DatoInvalidoException{

        Producto producto = repositorio.buscarPorCodigo(codigo);

        if(producto ==null){
            throw new DatoInvalidoException("El producto no existe.");
        } 

        repositorio.eliminar(producto.getId());
    }
    public void editarProducto(Producto producto)
            throws DatoInvalidoException {

        if(producto.getCodigo()==null||producto.getCodigo().trim().isEmpty()){
            throw new DatoInvalidoException("El código es obligatorio.");
        }

        if(producto.getNombre()==null|| producto.getNombre().trim().isEmpty()){
            throw new DatoInvalidoException("El nombre es obligatorio.");
        }

        if (producto.getCantidad()<0){
            throw new DatoInvalidoException("La cantidad debe ser mayor o igual a cero.");
        }

        if (producto.getPrecio()<=0){
            throw new DatoInvalidoException("El precio debe ser mayor que cero.");
        }

        repositorio.editar(producto);
    }
    public void ordenarProductos() {

        repositorio.getListaProductos().sort((p1, p2) ->
            p1.getNombre().compareToIgnoreCase(p2.getNombre()));
    }
    public java.util.List<Producto> listarProductos() {
        return repositorio.listar();
    }
    public void ordenarPorPrecio() {

        repositorio.getListaProductos().sort((p1, p2) ->
            Double.compare(p1.getPrecio(), p2.getPrecio()));
    }
    
    public void ordenarPorCantidad() {

        repositorio.getListaProductos().sort((p1, p2) ->
            Integer.compare(p1.getCantidad(), p2.getCantidad()));
    }
    public void exportarInventario(String ruta) throws java.io.IOException {

        java.io.PrintWriter archivo = new java.io.PrintWriter(ruta);

        archivo.println("ID,CODIGO,NOMBRE,CATEGORIA,CANTIDAD,PRECIO,DISPONIBLE");

        for (Producto p : listarProductos()) {

            archivo.println(
                    p.getId() + "," +
                    p.getCodigo() + "," +
                    p.getNombre() + "," +
                    p.getCategoria() + "," +
                    p.getCantidad() + "," +
                    p.getPrecio() + "," +
                    p.isDisponible());
        }

        archivo.close();
    }
    
    public java.util.List<Producto> buscarPorCategoria(String categoria) {
        return repositorio.buscarPorCategoria(categoria);
    }
    public java.util.Stack<String> obtenerHistorial() {
        return repositorio.getHistorial();
    }
}