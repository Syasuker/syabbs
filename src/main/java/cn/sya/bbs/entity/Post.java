package cn.sya.bbs.entity;

import java.io.Serializable;

public class Post implements Serializable {
	private static final long serialVersionUID = -6047186406427677813L;
	
	private String post_id;
	private User user;
	private String plate_id;
	//帖子状态1有效0删除
	private String status;
	private String title;
	private String body;
	//帖子创建时间
	private String createTime;
	//贴子最后一次修改时间
	private String lastModifyTime;
	
	public Post() {	}

	public Post(String post_id, User user, String plate_id, String status, String title, String body, String createTime,
			String lastModifyTime) {
		super();
		this.post_id = post_id;
		this.user = user;
		this.plate_id = plate_id;
		this.status = status;
		this.title = title;
		this.body = body;
		this.createTime = createTime;
		this.lastModifyTime = lastModifyTime;
	}

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPlate_id() {
		return plate_id;
	}

	public void setPlate_id(String plate_id) {
		this.plate_id = plate_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((post_id == null) ? 0 : post_id.hashCode());
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
		Post other = (Post) obj;
		if (post_id == null) {
			if (other.post_id != null)
				return false;
		} else if (!post_id.equals(other.post_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", user=" + user + ", plate_id=" + plate_id + ", status=" + status
				+ ", title=" + title + ", body=" + body + ", createTime=" + createTime + ", lastModifyTime="
				+ lastModifyTime + "]";
	}
	
	


}
