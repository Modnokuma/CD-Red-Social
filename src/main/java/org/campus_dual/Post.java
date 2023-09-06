package org.campus_dual;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class Post {
    private static final AtomicInteger count = new AtomicInteger(0);
    protected int id;
    protected Date fecha;
    protected ArrayList <Comentario> comentarios;
    protected String contenido;
    protected Imagen imagen;
    protected Video video;

    protected Usuario creador;

    public Post (Date fecha, Imagen imagen, Usuario creador){
        this.fecha= fecha;
        this.imagen=imagen;
        this.id= count.getAndIncrement();
        this.creador=creador;
        comentarios = new ArrayList<>();
    }
    public Post (Date fecha,  Video video, Usuario creador){
        this.fecha= fecha;
        this.video=video;
        this.id= count.getAndIncrement();
        this.creador=creador;
        comentarios = new ArrayList<>();
    }
    public Post (Date fecha, String contenido, Usuario creador){
        this.fecha= fecha;
        this.contenido=contenido;
        this.id= count.getAndIncrement();
        this.creador=creador;
        comentarios = new ArrayList<>();
    }

    public int numeroComentarios(){
        return comentarios.size();
    }

    public void añadirComentario(Comentario nuevo){
        comentarios.add(nuevo);
    }
    public void listarComentarios(){
        System.out.println("## COMENTARIOS DEL POST " + id + " ########");
        for (Comentario aux : comentarios) {
            System.out.println(aux.toString());
        }

    }
    @Override
    public String toString() {
       String toRet;
       Iterator<Comentario> it = comentarios.iterator();
       toRet = "##########  Post  ########\n";
       toRet += "Id: " + id  +"\n";
       toRet += "Numero de Comentarios: " + numeroComentarios() +"\n";
       toRet += "Fecha: " +  fecha + "\n";
       if(imagen != null){
       toRet += "Imagen: " + imagen.toString() + "\n";
       }
        if(video != null){
            toRet += "Video: " + video.toString() + "\n";
        }
        if(contenido != null){
            toRet += "Texto: " + contenido + "\n";
        }
        toRet += "Comentarios: ";
       while(it.hasNext()){
           toRet += it.toString() + ", ";
       }

       toRet +=  "\n" + "########## Fin Post ########";

    return toRet;
    }
}
