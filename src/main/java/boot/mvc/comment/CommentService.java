package boot.mvc.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements CommentServiceInter {

	@Autowired
	CommentMapperInter mapper;
	
}
