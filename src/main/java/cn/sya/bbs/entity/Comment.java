package cn.sya.bbs.entity;

import java.io.Serializable;

public class Comment implements Serializable{
	private static final long serialVersionUID = 9072156221647518313L;
	
	private String id;
	private String postID;
	private User user;
	private String status;
	private String body;
	private String createTime;
	private String modifyTime;

	public Comment() {	}

	/**
	 * @param id
	 * @param postID
	 * @param user
	 * @param status
	 * @param body
	 * @param createTime
	 * @param modifyTime
	 */
	public Comment(String id, String postID, User user, String status, String body, String createTime,
			String modifyTime) {
		super();
		this.id = id;
		this.postID = postID;
		this.user = user;
		this.status = status;
		this.body = body;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPostID() {
		return postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", postID=" + postID + ", user=" + user + ", status=" + status + ", body=" + body
				+ ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
	}
	
	
	
}
