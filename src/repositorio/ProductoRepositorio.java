/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import modelo.Producto;

public class ProductoRepositorio {

    private List<Producto> listaProductos;
    private Set<String> codigos;
    private Map<String, Integer> categorias;
    private Stack<String> historial;

    public ProductoRepositorio() {
        listaProductos = new ArrayList<>();
        codigos = new HashSet<>();
        categorias = new HashMap<>();
        historial = new Stack<>();
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public Set<String> getCodigos() {
        return codigos;
    }

    public Map<String, Integer> getCategorias() {
        return categorias;
    }

    public Stack<String> getHistorial() {
        return historial;
    }
    
        public void agregar(Producto producto) {
        listaProductos.add(producto);
        codigos.add(producto.getCodigo());

        categorias.put(
                producto.getCategoria(),
                categorias.getOrDefault(producto.getCategoria(), 0) + 1
        );

        historial.push("Producto registrado: " + producto.getNombre());
    }

    public List<Producto> listar() {
        return listaProductos;
    }

    public Producto buscarPorCodigo(String codigo) {
        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equalsIgnoreCase(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public boolean existeCodigo(String codigo) {
        return codigos.contains(codigo);
    }
    public Producto buscarPorNombre(String nombre) {

        for (Producto producto : listaProductos) {

            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }

        return null;
    }
    
    public List<Producto> buscarPorCategoria(String categoria) {

        List<Producto> resultado = new ArrayList<>();

        for (Producto producto : listaProductos) {

            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(producto);
            }
        }

        return resultado;
    }
    
        public void editar(Producto productoActualizado) {
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto producto = listaProductos.get(i);

            if (producto.getId() == productoActualizado.getId()) {

                codigos.remove(producto.getCodigo());

                categorias.put(producto.getCategoria(),
                        categorias.get(producto.getCategoria()) - 1);

                listaProductos.set(i, productoActualizado);

                codigos.add(productoActualizado.getCodigo());

                categorias.put(productoActualizado.getCategoria(),
                        categorias.getOrDefault(productoActualizado.getCategoria(), 0) + 1);

                historial.push("Producto editado: " + productoActualizado.getNombre());

                break;
            }
        }
    }

    public void eliminar(int id) {

        Producto productoEliminar = null;

        for (Producto producto : listaProductos) {
            if (producto.getId() == id) {
                productoEliminar = producto;
                break;
            }
        }

        if (productoEliminar != null) {

            listaProductos.remove(productoEliminar);

            codigos.remove(productoEliminar.getCodigo());

            categorias.put(productoEliminar.getCategoria(),
                    categorias.get(productoEliminar.getCategoria()) - 1);

            historial.push("Producto eliminado: " + productoEliminar.getNombre());
        }
    }

}
