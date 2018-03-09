package pl.pw.vhacks.interfaith_parent_connection.repositories;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;
import pl.pw.vhacks.interfaith_parent_connection.entities.Post;

import java.util.List;

@Repository
public interface SolrPostRepository extends SolrCrudRepository<Post, String> {
    List<Post> findByTextOrTopic(String text, String topic);
    List<Post> findByText(String text);
}
