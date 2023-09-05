package org.campus_dual;

public class Imagen {
    protected String titulo;
    protected String dimensiones;

    public Imagen(String titulo, String dimensiones) {
        this.titulo = titulo;
        this.dimensiones = dimensiones;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    @Override
    public String toString(){
        String toRet;
        toRet ="Imagen{ " + getTitulo() + ", " + getDimensiones() + " }";
        return toRet;
    }
}
