/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacion;

import javax.swing.JOptionPane;

/**
 *
 * @author ivann
 */
public class Lista {

    public Coche lista;

    public Lista() {
        lista = null;
    }

    public void Agregar(String nombre, boolean placas, int capacidad, String marca, String tipo, int cilandraje) {
        Coche nuevo = new Coche(nombre, placas, capacidad, marca, tipo, cilandraje);
        if (lista == null) {
            lista = nuevo;
        } else {
            nuevo.setSiguiente(lista);
            lista = nuevo;
        }
        JOptionPane.showMessageDialog(null, "Coche " + nuevo.getNombre() + " agregado a la lista.", "Bien", JOptionPane.INFORMATION_MESSAGE);
    }

    public void Recorrer() {
        Coche aux = lista;
        if (lista == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            StringBuilder valores = new StringBuilder();
            while (aux != null) {
                valores.append("Nombre: ").append(aux.getNombre()).append("\n");
                valores.append("Ubicación: ").append(aux.getPlacas()).append("\n");
                valores.append("Entrada: ").append(aux.getCapacidad()).append("\n");
                valores.append("Capacidad: ").append(aux.getMarca()).append("\n");
                valores.append("Tiene sombrillas: ").append(aux.getTipo()).append("\n");
                valores.append("Restaurante: ").append(aux.getCilindraje()).append("\n\n\n");
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, valores.toString());
        }
    }

    public void buscar() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de la playa a buscar:");
        Coche aux = lista;
        boolean encontrado = false;
        while (aux != null) {
            StringBuilder valores = new StringBuilder();
            if (aux.getNombre().equalsIgnoreCase(nombre)) {
                valores.append("Nombre: ").append(aux.getNombre()).append("\n");
                valores.append("Ubicación: ").append(aux.getPlacas()).append("\n");
                valores.append("Entrada: ").append(aux.getCapacidad()).append("\n");
                valores.append("Capacidad: ").append(aux.getMarca()).append("\n");
                valores.append("Tiene sombrillas: ").append(aux.getTipo()).append("\n");
                valores.append("Restaurante: ").append(aux.getCilindraje()).append("\n\n\n");
                JOptionPane.showMessageDialog(null, valores.toString());
                encontrado = true;
                break;
            }
            aux = aux.getSiguiente();
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Playa " + nombre + " no encontrada en la pila.", "Resultado de la búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void borrar() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del carro a borrar");
        Coche tope = lista;
        Coche anterior = null;
        boolean encontrado = false;

        while (tope != null) {
            if (tope.getNombre().equalsIgnoreCase(nombre)) {
                if (anterior == null) {
                    lista = tope.getSiguiente();
                } else {
                    anterior.setSiguiente(tope.getSiguiente());
                }
                JOptionPane.showMessageDialog(null, "Coche " + nombre + " eliminado de la lista.", "Borrado exitoso", JOptionPane.INFORMATION_MESSAGE);
                encontrado = true;
                break;
            }
            anterior = tope;
            tope = tope.getSiguiente();
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Coche " + nombre + " no encontrado en la lista", "Lo siento bb", JOptionPane.ERROR_MESSAGE);
        }
    }

}
