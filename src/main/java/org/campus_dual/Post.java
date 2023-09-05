package org.campus_dual;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Post {
    protected Date fecha;
    protected ArrayList <Comentario> comentarios;
    protected String contenido;
    protected Imagen imagen;
    protected Video video;

    public Post (Date fecha, Imagen imagen){
        this.fecha= fecha;
        this.imagen=imagen;
        comentarios = new ArrayList<>();
    }
    public Post (Date fecha,  Video video){
        this.fecha= fecha;
        this.video=video;
        comentarios = new ArrayList<>();
    }
    public Post (Date fecha, String contenido){
        this.fecha= fecha;
        this.contenido=contenido;
        comentarios = new ArrayList<>();
    }

    public int numeroComentarios(){
        return comentarios.size();
    }

    @Override
    public String toString() {
       String toRet;
       Iterator<Comentario> it = comentarios.iterator();
       toRet = "##########  Post  ########\n";
       toRet += "Numero de Comentarios: " + numeroComentarios() +"\n";
       toRet += "Fecha: " +  fecha + "\n";
       if(imagen != null){
       toRet += "Imagen: " + imagen.toString() + "\n";
       }
        if(video != null){
            toRet += "Video: " + video.toString() + "\n";
        }
        if(contenido != null){
            toRet += "Texto: " + contenido.toString() + "\n";
        }
        toRet += "Comentarios: ";
       while(it.hasNext()){
           toRet += it.toString() + ", ";
       }

       toRet +=  "\n" + "########## Fin Post ########";

       return toRet;
    }
}
