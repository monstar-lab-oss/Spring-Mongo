package com.mongopoc.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Document(collection = "actions")
public class Action {
	@Id
	private String id;
	private String type;
	private String userId;
	private String parentId;
	private String body;
	private String postId;

	public Action(String type, String userId, String parentId, String body) {
		this.type = type;
		this.userId = userId;
		this.parentId = parentId;
		this.body = body;
		this.postId = postId;
	}
}
