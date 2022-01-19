package com.ecommerce.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.Entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    static final Map<Long, Comment> MAP = new HashMap<>();

	
	public static List<Comment> getComment(){
        List<Comment> list = new ArrayList<>();

        list.addAll(MAP.values());
        return list;
    }

}
