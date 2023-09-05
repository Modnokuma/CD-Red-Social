package org.campus_dual;
import util.Input;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
         char continuar = 'S';
         int opcion;
         String myUserInput, anotherUserInput;
         Usuario miUsuario;

         while((continuar=='S') || (continuar=='s')){
             ArrayList<Usuario> listaUsuarios = new ArrayList<>();
             ArrayList<Post> listaPosts = new ArrayList<>();
             ArrayList<Comentario> listaComentarios = new ArrayList<>();

             //Login
             miUsuario= logearse( listaUsuarios);

             // Menu
             System.out.println("########  MENU  ###############");
             System.out.println("1. Añadir Usuarios/Posts/Comentarios");
             System.out.println("2. Eliminar Usuarios/Posts/Comentarios");
             System.out.println("3. Seguir a un Usuario");
             System.out.println("4. Dejar de seguir a un Usuario");
             System.out.println("5. Listar todos los posts de un Usuario");
             System.out.println("6. Listar todos los comentarios de un Usuario");
             System.out.println("7. Número de comentarios en un Post");
             System.out.println("8. Salir");
             opcion = Input.integer("Selecciona una opcion: ");
             switch (opcion) {
                 case 1:

                     break;
                 case 2:

                     break;
                 case 3:
                     anotherUserInput = Input.string("A que usuario quieres seguir?: ");
                     seguir(miUsuario,anotherUserInput, listaUsuarios);
                     break;
                 case 4:
                     anotherUserInput = Input.string("A que usuario quieres dejar de seguir?: ");
                     unFollow( miUsuario,  anotherUserInput,  listaUsuarios );
                     break;
                 case 5:
                     miUsuario.listarPosts();
                     break;
                 case 6:
                     miUsuario.listarComentarios(listaComentarios);
                     break;
                 case 7:
                    Iterator<Post>it =listaPosts.iterator();
                    while (it.hasNext()){
                        it.next().toString();
                    }
                     break;
                 case 8:
                        continuar = 'n';
                     break;
                 default:
                     System.out.println("Se ha introducido una opción no valida....");

             }
          //   añadirUsuarios(listaUsuarios);
          //   añadirPosts(listaPosts);
         }

         /*Imagen nueva = new Imagen("Dani","3x3");
        Video video = new Video("Daniprogramando", "media",100);
        Date date = new Date();
        Post post = new Post(date,nueva);
        Post post2 = new Post(date,video);
        Post post3 = new Post(date,"post 33");

        Usuario Dani = new Usuario("Dani");
        Comentario c1 = new Comentario("Hola, buenos dias", date, Dani);
        System.out.println("Oh baby!!");
        System.out.println(nueva.toString());
        System.out.println(video.toString());
        System.out.println(post.toString());
        System.out.println(post2.toString());
        System.out.println(post3.toString());
        System.out.println(c1.toString());*/

    }

    public static void añadirUsuarios( ArrayList<Usuario> listaUsuarios) {
            String nombre = Input.string(" Introduce el nombre del usuario: ");
            Usuario aux = new Usuario(nombre);
            listaUsuarios.add(aux);
        System.out.println("Usuario creado...");
    }

    public  static void añadirPosts(ArrayList<Post> listaPosts){
        System.out.println("########  Crear Post  ########");
        String tipo = Input.string(" Introduce el tipo de Post que quieres crear (Texto, Imagen o Video): ");
        Date fecha = new Date();
        switch (tipo.toLowerCase()) {
            case "texto":
                listaPosts.add(new Post(fecha,tipo));
                System.out.println("Post introducido con éxito...");
                break;
            case "imagen":
                String titulo = Input.string("\n Introduce el titulo de la imagen: ");
                String dimensiones = Input.string("\n Introduce las dimensiones de la imagen: ");
                listaPosts.add(new Post(fecha,new Imagen(titulo,dimensiones)));
                System.out.println("Post introducido con éxito...");
                break;
            case "video":
                titulo = Input.string("\n Introduce el titulo de la imagen: ");
                String calidad = Input.string("\n Introduce las calidad de la imagen: ");
                int duracion = Input.integer("\n Introduce la duracion del video: ");
                listaPosts.add(new Post(fecha,new Video(titulo,calidad, duracion)));
                System.out.println("Post introducido con éxito...");
                break;
            default:
                System.out.println("Se ha introducido un tipo no valido....");

        }
    }

    public static void añadirComentarios(ArrayList<Comentario>listaComentarios, ArrayList<Usuario> listaUsuarios,ArrayList<Post> listaPosts){
        String texto = Input.string("\n Introduce el texto del comentario: ");
        Date fecha = new Date();
        String usuario = Input.string("\n Quien es el usuario creador?: ");
        Iterator <Usuario> it = listaUsuarios.iterator();
        while(it.hasNext()){
            Usuario aux = it.next();
            if(aux.nombre==usuario){
                listaComentarios.add(new Comentario(texto,fecha,aux));
            }
        }

    }

    public static void seguir(Usuario miUsuario, String anotherUserInput, ArrayList<Usuario> listaUsuarios ){
        Usuario anotherUser = null;
        Usuario aux;
        Iterator <Usuario> it = listaUsuarios.iterator();

        while (it.hasNext()){
            aux = it.next();
            if(aux.nombre== anotherUserInput){
                anotherUser=aux;
            }
        }
        if(anotherUser!=null){
            miUsuario.seguirUsuario(anotherUser);
            System.out.println("Ahora sigues a " + anotherUser.nombre);
        }

        System.out.println("Ese usuario no existe");

    }

    public static void unFollow(Usuario miUsuario, String anotherUserInput, ArrayList<Usuario> listaUsuarios ){
        Usuario anotherUser = null;
        Usuario aux;
        Iterator <Usuario> it = listaUsuarios.iterator();

        while (it.hasNext()){
            aux = it.next();

            if(aux.nombre== anotherUserInput){
                anotherUser=aux;
            }
        }
        if( anotherUser!=null){
            miUsuario.unfollowUsuario(anotherUser);
            System.out.println("Ya no sigues a " + anotherUser.nombre);
        }
        System.out.println("Ese usuario no existe");

    }

    public static Usuario logearse(ArrayList <Usuario> listaUsuarios){
        // Nos logeamos
        char continuar = 's';
        String input;
        Usuario usuario = null;
        Usuario aux;

        while((continuar=='S') || (continuar=='s')){
            input = Input.string("Cual es el nombre de tu usuario?: ");

            Iterator <Usuario> it = listaUsuarios.iterator();

            while (it.hasNext()){
                aux = it.next();
                if(aux.nombre== input){
                    usuario=aux;

                }
            }
            if(usuario!=null){
                continuar='n';
            }
        }
        return usuario;

    }
}


