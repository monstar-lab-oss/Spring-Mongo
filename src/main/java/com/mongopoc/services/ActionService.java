package com.mongopoc.services;

import com.mongopoc.models.Action;
import com.mongopoc.models.User;
import com.mongopoc.repositories.ActionRepository;
import com.mongopoc.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/** Provide user related functionality. */
@Service
@RequiredArgsConstructor
public class ActionService {

  private final ActionRepository actionRepository;

  public List<Action> findAllActionsByUserId(String id) {
    return actionRepository
          .findByUserId(id);
  }

    public List<Action> findAllActionsByParentIdAndType(String parentId, String type) {
        return actionRepository
                .findByParentIdAndType(parentId, type);
    }

    public List<Action> findAllActionsByPostId(String parentId) {
        return actionRepository
                .findByPostId(parentId);
    }

    public Integer countByTypeAndParentId(String type, String parentId) {
        return actionRepository
                .countByTypeAndParentId(type, parentId);
    }

    public Action createAction(Action action) {
        return actionRepository.save(action);
    }
}
