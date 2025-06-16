package app.usuario;

import java.util.ArrayList;
import java.util.Random;

public class ControladorUsuarios {

    private ArrayList<Usuario> listaUsuarios;

    public ControladorUsuarios() {
        listaUsuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public int totalUsuarios() {
        return listaUsuarios.size();
    }

    public double promedioEdad() {
        if (listaUsuarios.isEmpty()) return 0;
        int suma = 0;
        for (Usuario u : listaUsuarios) {
            suma += u.getEdad();
        }
        return (double) suma / listaUsuarios.size();
    }

    public String nombreMasLargo() {
        String largo = "";
        for (Usuario u : listaUsuarios) {
            if (u.getNombre().length() > largo.length()) {
                largo = u.getNombre();
            }
        }
        return largo;
    }

    // Método sobrecargado para buscar por nombre
    public Usuario buscarUsuario(String nombre) {
        for (Usuario u : listaUsuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                return u;
            }
        }
        return null;
    }

    // Método sobrecargado para buscar por ciudad
    public ArrayList<Usuario> buscarUsuarioPorCiudad(String ciudad) {
        ArrayList<Usuario> encontrados = new ArrayList<>();
        for (Usuario u : listaUsuarios) {
            if (u.getCiudad().equalsIgnoreCase(ciudad)) {
                encontrados.add(u);
            }
        }
        return encontrados;
    }

    public Usuario usuarioDestacado() {
        if (listaUsuarios.isEmpty()) return null;
        Random random = new Random();
        int indice = random.nextInt(listaUsuarios.size());
        return listaUsuarios.get(indice);
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    // Clase estática anidada para decorar mensajes
    public static class Decorador {
        public static void mostrarLineaDecorativa() {
            System.out.println("=======================================");
        }
    }
}
