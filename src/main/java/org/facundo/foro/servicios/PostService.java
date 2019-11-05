package org.facundo.foro.servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.facundo.foro.repositorios.PostRepository;
import java.sql.Connection;
import org.facundo.foro.estructuradedatos.ListaPosts;
import java.sql.DriverManager;
import org.facundo.foro.modelos.Post;
import java.sql.SQLException;

@Service
public class PostService{
	private PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository){
		this.postRepository = postRepository;

	}
	public ListaPosts<Post> buscarPostsInicio()throws SQLException{
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/foro","postgres","postgres");){
			ListaPosts<Post> lista = this.postRepository.findLasts(conn, 10);
			return lista;
		}

	}
}
