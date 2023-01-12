package software.dev.backend.model;

import java.sql.Date;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.*;

public class Posting {
    
    private String postingId;

    private String postingDate;

    private String name;

    private String email;

    private String title;

    private String phone;

    private String description;

    private String image;

    public String getPostingId() {
        return postingId;
    }

    public void setPostingId(String postingId) {
        this.postingId = postingId;
    }

    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String string) {
        this.postingDate = string;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static Posting create(String json) {
		Posting p = new Posting();
		JsonObject obj = Json.createReader(new StringReader(json)).readObject();
        p.setPostingId(obj.getString("postingId"));
		p.setName(obj.getString("name"));
		p.setEmail(obj.getString("email"));
		p.setPhone(obj.getString("phone"));
		p.setTitle(obj.getString("title"));
		p.setDescription(obj.getString("description"));
        p.setImage(obj.getString("image"));
		return p;
	}

    public static Posting create(SqlRowSet rs) {
		Posting p = new Posting();
        p.setPostingId(rs.getString("posting_id"));
        p.setPostingDate(rs.getString("posting_date"));
		p.setName(rs.getString("name"));
		p.setEmail(rs.getString("email"));
		p.setPhone(rs.getString("phone"));
		p.setTitle(rs.getString("title"));
		p.setDescription(rs.getString("description"));
        p.setImage(rs.getString("image"));
		return p;
	}

    public JsonObject toJson() {

		return Json.createObjectBuilder()
                .add("postingId", postingId)
                .add("postingDate", postingDate)
				.add("name", name)
				.add("email", email)
				.add("phone", phone)
				.add("title", title)
				.add("description", description)
				.add("image", image)
				.build();
	}

}
