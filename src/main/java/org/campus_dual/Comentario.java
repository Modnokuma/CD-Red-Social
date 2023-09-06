package org.campus_dual;

import java.util.Date;

public class Comentario {
    protected String textoComentario;
    protected Date fechaComentario;
    protected Usuario propietario;
    protected Post publicacion;

    public Comentario(String texto, Date fecha, Usuario dueño, Post publicacion){
        this.textoComentario= texto;
        this.fechaComentario = fecha;
        this.propietario = dueño;
        this.publicacion=publicacion;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "textoComentario='" + textoComentario + '\'' +
                ", fechaComentario=" + fechaComentario +
                ", propietario=" + propietario.nombre +
                ", publicacion=" + publicacion.id+
                '}';
    }
}
