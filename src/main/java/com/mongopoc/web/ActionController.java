package com.mongopoc.web;

import com.mongopoc.models.Action;
import com.mongopoc.models.User;
import com.mongopoc.services.ActionService;
import com.mongopoc.services.UserService;
import com.mongopoc.web.dto.ActionDto;
import com.mongopoc.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
class ActionController {

  private final ActionService actionService;

  @GetMapping("/users/{userId}/actions")
  List<ActionDto> allActions(@PathVariable String userId) {

    List<Action> actions = actionService.findAllActionsByUserId(userId);
    return actions.stream().map(ActionDto::new).toList();
  }

  @GetMapping("/actions/{parentId}/comments")
  public List<ActionDto> allComments(@PathVariable String parentId) {
    List<Action> actions = actionService.findAllActionsByParentIdAndType(parentId, "comment");
    return actions.stream().map(ActionDto::new).toList();
  }

  @GetMapping("/actions/{parentId}/likes")
  public List<ActionDto> allLikes(@PathVariable String parentId) {
    List<Action> actions = actionService.findAllActionsByParentIdAndType(parentId, "like");
    return actions.stream().map(ActionDto::new).toList();
  }

  @GetMapping("/actions/{postId}")
  public List<ActionDto> allActionsForPost(@PathVariable String postId) {
    List<Action> actions = actionService.findAllActionsByPostId(postId);
    return actions.stream().map(ActionDto::new).toList();
  }

  @GetMapping("/actions/{parentId}/count-likes")
  public Integer countLikes(@PathVariable String parentId) {
    return actionService.countByTypeAndParentId("like", parentId);
  }

  @PostMapping("/actions")
  public ActionDto createAction(@RequestBody Action action) {
    Action actionCreated = actionService.createAction(action);
    return new ActionDto(actionCreated);
  }
}
