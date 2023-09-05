package org.campus_dual;

public class Video {
    protected String titulo;
    protected String calidad;
    protected int duracion;

    public Video(String titulo, String calidad, int duracion) {
        this.titulo = titulo;
        this.calidad = calidad;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCalidad() {
        return calidad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Video{" +
                "titulo='" + titulo + '\'' +
                ", calidad='" + calidad + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}
