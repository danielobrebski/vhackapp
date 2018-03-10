package pl.pw.vhacks.interfaith_parent_connection.repositories;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;
import pl.pw.vhacks.interfaith_parent_connection.entities.Post;
import pl.pw.vhacks.interfaith_parent_connection.entities.SolrPost;

import java.util.List;

@Repository
public interface SolrPostRepository extends SolrCrudRepository<SolrPost, String> {
    List<SolrPost> queryByTextOrTopic(String text, String topic);
    List<SolrPost> queryByText(String text);
}
