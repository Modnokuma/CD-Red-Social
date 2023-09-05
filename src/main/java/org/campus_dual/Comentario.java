package org.campus_dual;

import java.util.Date;

public class Comentario {
    protected String textoComentario;
    protected Date fechaComentario;
    protected Usuario propietario;

    public Comentario(String texto, Date fecha, Usuario dueño){
        this.textoComentario= texto;
        this.fechaComentario = fecha;
        this.propietario = dueño;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "textoComentario='" + textoComentario + '\'' +
                ", fechaComentario=" + fechaComentario +
                ", propietario=" + propietario.nombre +
                '}';
    }
}
