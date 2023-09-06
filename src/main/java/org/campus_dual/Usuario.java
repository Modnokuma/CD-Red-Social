package org.campus_dual;

import java.util.ArrayList;
import java.util.Iterator;

public class Usuario {
    protected String nombre;
    protected ArrayList <Post>posts;
    protected ArrayList <Usuario> siguiendo;

    public Usuario (String nombreUsuario){
        this.nombre = nombreUsuario;
        posts = new ArrayList<>();
        siguiendo = new ArrayList<>();
    }

    public void seguirUsuario(Usuario aux){
        if(!siguiendo.contains(aux)) {
            siguiendo.add(aux);
            System.out.println("Siguiendo " + aux.nombre);
        } else {
            System.out.println("Ya sigues a este usuario...");
        }

    }

    public void unfollowUsuario(Usuario aux){
        if(!siguiendo.contains(aux)){
            System.out.println("No sigues a este usuario..");
        } else {
            System.out.println("Has dejado de seguir a " + aux.nombre);
        }
    }
    public void añadirPost(Post nuevo){
        posts.add(nuevo);
    }

   public void listarPosts(){
       Post aux;
        Iterator <Post> it = posts.iterator();

        while (it.hasNext()) {
            aux = it.next();
            System.out.println(aux.toString());
        }
    }

    public void listarComentarios(){
        Iterator <Post> it = posts.iterator();

        while(it.hasNext()){
            it.next().listarComentarios();

        }
    }

}
