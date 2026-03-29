package com.esen.presentacion;

import java.util.Scanner;

public abstract class Menu {
    protected boolean continuar = true;
    protected Scanner s = new Scanner(System.in);

    public void mostrar() {
        do {
            imprimirEncabezadoYOpciones();
            System.out.print("Seleccione una opción: ");
            String opcion = s.nextLine().trim();
            procesarOpcion(opcion);
        } while (continuar);
    }

    protected abstract void imprimirEncabezadoYOpciones();
    protected abstract void procesarOpcion(String opcion);
}