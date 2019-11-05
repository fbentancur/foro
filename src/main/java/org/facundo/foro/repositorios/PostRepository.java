package org.facundo.foro.repositorios;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import org.facundo.foro.estructuradedatos.ListaPosts;
import org.facundo.foro.modelos.Post;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class PostRepository{

	public ListaPosts<Post> findLasts(Connection conn, int cantidad)
	throws SQLException{
		ListaPosts<Post> posts = new ListaPosts<Post>();
		try(
			PreparedStatement stmt = conn.prepareStatement("select * from posts");
			ResultSet resultSet = stmt.executeQuery();
		){
			while(resultSet.next()== true){
				Post post = new Post(
					resultSet.getString("titulo"),
					resultSet.getString("cuerpo"),
					resultSet.getInt("codigo")
				);
				posts.add(post);
			}

		}
		return posts;

	}
}
