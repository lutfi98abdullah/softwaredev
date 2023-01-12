package software.dev.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import software.dev.backend.rep.PostRepository;
import software.dev.backend.model.Posting;

@Service
public class PostingService {
    
    @Autowired
    PostRepository postRepo;

    public void createPost(Posting post) {
		postRepo.addPost(post);
	}
}
