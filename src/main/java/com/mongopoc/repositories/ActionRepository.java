package com.mongopoc.repositories;

import com.mongopoc.models.Action;
import com.mongopoc.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ActionRepository extends MongoRepository<Action, String> {
	List<Action> findByUserId(String id);
	List<Action> findByPostId(String id);
	List<Action> findByParentIdAndType(String id, String type);
	Integer countByTypeAndParentId(String type, String parentId);
}