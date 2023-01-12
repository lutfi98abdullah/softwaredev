package software.dev.backend.rep;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import java.io.ByteArrayInputStream;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


import software.dev.backend.model.Posting;


@Repository
public class PostRepository {
    
    private static final String SQL_POST_POSTING 
            = "insert into postings (posting_id, posting_date, name, email, phone, title, description, image) values(?,?,?,?,?,?,?,?)";

    @Autowired
    JdbcTemplate template;

    @Autowired @Qualifier("post")
    private RedisTemplate<String, String> redisTemplate;
    

    public Boolean addPost(Posting p) {
        int added = template.update(SQL_POST_POSTING, p.getPostingId(), p.getPostingDate(), p.getName(), p.getEmail(), p.getPhone(), p.getTitle(), p.getDescription(), p.getImage());
        return added > 0;
    }

    

    public Set<String> getKeys(String key) {
        return ((RedisOperations<String, String>) template).keys(key);
    }

    public Optional<Posting> getPost(String postingId) {
        String rec = (String)((RedisOperations<String, String>) template).opsForHash().get(postingId, "rec");
        if (null != rec)
            return Optional.of(Posting.create(rec));
        return Optional.empty();
    }



        
}
