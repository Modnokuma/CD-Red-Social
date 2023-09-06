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
         Usuario userAux;

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Post> listaPosts = new ArrayList<>();
        ArrayList<Comentario> listaComentarios = new ArrayList<>();

        Usuario Dani = new Usuario("Dani");
        Usuario Xenxo = new Usuario("Xenxo");
        Usuario David = new Usuario("David");
        listaUsuarios.add(Dani);
        listaUsuarios.add(Xenxo);
        listaUsuarios.add(David);

        Imagen imagen = new Imagen("Dani","3x3");
        Video video = new Video("Daniprogramando", "media",100);
        Date date = new Date();

        /*Post post1 = new Post(date,imagen,Dani);
        Post post2 = new Post(date,video,Dani);
        Post post3 = new Post(date,"post 33",Dani);
        listaPosts.add(post1);
        listaPosts.add(post2);
        listaPosts.add(post3);
        Dani.añadirPost(post1);
        Dani.añadirPost(post2);
        Dani.añadirPost(post3);


        Comentario c1 = new Comentario("Hola, buenos dias", date, Dani,post1);
        Comentario c2 = new Comentario("Callate", date, Xenxo,post1);
        Comentario c3 = new Comentario("Perdon....", date, Dani,post1);
        Comentario c4 = new Comentario("Helloooooo", date, Dani,post2);
        post1.añadirComentario(c1);
        post1.añadirComentario(c2);
        post1.añadirComentario(c3);
        post2.añadirComentario(c4);
        listaComentarios.add(c1);
        listaComentarios.add(c2);
        listaComentarios.add(c3);
        listaComentarios.add(c4);*/

        //Login
        miUsuario= logearse( listaUsuarios);
         while((continuar=='S') || (continuar=='s')){

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
                     System.out.println("Prueba añadir usuario");
                     añadirUsuarios(listaUsuarios);
                     System.out.println("Prueba añadir post");
                     añadirPosts(listaPosts,listaUsuarios);

                     break;
                 case 2:
                     añadirComentarios(listaComentarios,listaPosts,miUsuario);
                     break;
                 case 3:
                     System.out.println("A que usuario quieres seguir?: ");
                     userAux=getUsuario(listaUsuarios);
                     miUsuario.seguirUsuario(userAux);

                     break;
                 case 4:
                     userAux=getUsuario(listaUsuarios);
                     miUsuario.unfollowUsuario(userAux);
                     break;
                 case 5:
                     miUsuario.listarPosts();
                     break;
                 case 6:
                     miUsuario.listarComentarios();
                     break;
                 case 7:
                    Iterator<Post>it =listaPosts.iterator();
                     System.out.println(listaPosts.size());
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


        /*System.out.println("Oh baby!!");
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

    public  static void añadirPosts(ArrayList<Post> listaPosts, ArrayList<Usuario> listaUsuarios){
        Usuario creador;
        Post nuevoPost;
        System.out.println("########  Crear Post  ########");
        System.out.println("Introduce el Usuario creador del Post....");
        creador =getUsuario(listaUsuarios);
        Date fecha = new Date();
        String tipo = Input.string(" Introduce el tipo de Post que quieres crear (Texto, Imagen o Video): ");

        switch (tipo.toLowerCase()) {
            case "texto":
                String contenido = Input.string("\n Contenido en texto del post:");
                nuevoPost=new Post(fecha,contenido,creador);
                listaPosts.add(nuevoPost);
                creador.añadirPost(nuevoPost);
                System.out.println("Post introducido con éxito...");
                break;
            case "imagen":
                String titulo = Input.string("\n Introduce el titulo de la imagen: ");
                String dimensiones = Input.string("\n Introduce las dimensiones de la imagen: ");
                nuevoPost=new Post(fecha,new Imagen(titulo,dimensiones),creador);
                listaPosts.add(nuevoPost);
                creador.añadirPost(nuevoPost);
                System.out.println("Post introducido con éxito...");
                break;
            case "video":
                titulo = Input.string("\n Introduce el titulo del video: ");
                String calidad = Input.string("\n Introduce las calidad del video: ");
                int duracion = Input.integer("\n Introduce la duracion del video: ");
                nuevoPost =new Post(fecha,new Video(titulo,calidad, duracion),creador);
                listaPosts.add(nuevoPost);
                creador.añadirPost(nuevoPost);
                System.out.println("Post introducido con éxito...");
                break;
            default:
                System.out.println("Se ha introducido un tipo no valido....");

        }
    }

    public static void añadirComentarios(ArrayList<Comentario>listaComentarios,ArrayList<Post> listaPosts, Usuario miUsuario){
        System.out.println(listaPosts.toString());
        System.out.println("\nSelecciona en que post comentar....");
        Post post = getPost(listaPosts);
        String texto = Input.string("Introduce el texto del comentario: ");
        Date fecha = new Date();
        //System.out.println("Quien introduce el comentario?...");
        //Usuario dueño = getUsuario(listaUsuarios);


        Comentario nuevo = new Comentario(texto,fecha,miUsuario,post);
        post.añadirComentario(nuevo);
        listaComentarios.add(nuevo);
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
                System.out.println(aux.nombre);
                if(aux.nombre.equals(input)){


                    usuario=aux;

                }
                if(usuario!=null){
                    continuar='n';
                }
            }

        }
        return usuario;

    }

    public static Post getPost(ArrayList <Post> listaPosts){

        char continuar = 's';
        int input;
        Post post = null;
        Post aux;

        while((continuar=='S') || (continuar=='s')){

            Iterator <Post> it = listaPosts.iterator();
            System.out.println("\n");
            input = Input.integer("Introduce el id del post: ");
            while (it.hasNext()){
                aux = it.next();
                if(aux.id== input){
                    post=aux;

                }
            }
            if(post!=null){
                continuar='n';
            }
        }
        return post;

    }
    public static Usuario getUsuario(ArrayList <Usuario> listaUsuarios){

        char continuar = 's';
        String input;
        Usuario usuario = null;
        Usuario aux;

        while((continuar=='S') || (continuar=='s')){
            input = Input.string("Introduce el nombre del usuario: ");

            Iterator <Usuario> it = listaUsuarios.iterator();

            while (it.hasNext()){
                aux = it.next();
                if(aux.nombre.equals(input)){
                    usuario=aux;

                }
            }
            if(usuario!=null){
                continuar='n';
            }
        }
        return usuario;

    }


    /*public static void seguir(Usuario miUsuario, String anotherUserInput, ArrayList<Usuario> listaUsuarios ){
        Usuario anotherUser = getUsuario(listaUsuarios);
        Usuario aux;
        Iterator <Usuario> it = listaUsuarios.iterator();

        while (it.hasNext()){
            aux = it.next();
            if(aux.nombre.equals(anotherUserInput)){
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

    }*/
}


