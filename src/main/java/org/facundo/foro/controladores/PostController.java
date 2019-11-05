package org.facundo.foro.controladores;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.sql.SQLException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.facundo.foro.modelos.Post;
import org.facundo.foro.estructuradedatos.ListaPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.facundo.foro.servicios.PostService;

@RestController
public class PostController{
	private PostService postService;
	@Autowired
	public PostController(PostService postService){
		this.postService = postService;
	}

	@GetMapping("/posts")
	public ResponseEntity<Object> devolverPost(){

		try{
			ListaPosts<Post> lista = this.postService.buscarPostsInicio();

			ResponseEntity<Object> respuesta = new ResponseEntity<Object>(lista, HttpStatus.OK);
			return respuesta;
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			ResponseEntity<Object> respuesta = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return respuesta;
		}

	}
}
