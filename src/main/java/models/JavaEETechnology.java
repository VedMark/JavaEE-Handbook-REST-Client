package models;

import org.json.JSONObject;

public class JavaEETechnology {
    private Integer id = null;
    private String name;
    private JavaEETechnologyVersions versions;
    private String description;

    public JavaEETechnology() {
        versions = new JavaEETechnologyVersions();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersionForJava4() {
        return versions.getVersionForJava4();
    }

    public void setVersionForJava4(String v4) {
        this.versions.setVersionForJava4(v4);
    }

    public String getVersionForJava5() {
        return versions.getVersionForJava5();
    }

    public void setVersionForJava5(String v5) {
        this.versions.setVersionForJava5(v5);
    }

    public String getVersionForJava6() {
        return versions.getVersionForJava6();
    }

    public void setVersionForJava6(String v6) {
        this.versions.setVersionForJava6(v6);
    }

    public String getVersionForJava7() {
        return versions.getVersionForJava7();
    }

    public void setVersionForJava7(String v7) {
        this.versions.setVersionForJava7(v7);
    }

    public String getVersionForJava8() {
        return versions.getVersionForJava8();
    }

    public void setVersionForJava8(String v8) {
        this.versions.setVersionForJava8(v8);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String rDescription) {
        this.description = rDescription;
    }

    public JSONObject toJSON() {
        return new JSONObject("{" + "\"id\": " + getId() +
                ", \"name\": \"" + getName() + '\"' +
                ", \"versionForJava4\": \"" + getVersionForJava4() + '\"' +
                ", \"versionForJava5\": \"" + getVersionForJava5() + '\"' +
                ", \"versionForJava6\": \"" + getVersionForJava6() + '\"' +
                ", \"versionForJava7\": \"" + getVersionForJava7() + '\"' +
                ", \"versionForJava8\": \"" + getVersionForJava8() + '\"' +
                ", \"description\": \"" + getDescription() + '\"' + '}');
    }

    public void fromJSON(JSONObject json) {
        this.setId(json.getInt("id"));
        this.setName(json.getString("name"));
        this.setVersionForJava4(json.getString("versionForJava4"));
        this.setVersionForJava5(json.getString("versionForJava5"));
        this.setVersionForJava6(json.getString("versionForJava6"));
        this.setVersionForJava7(json.getString("versionForJava7"));
        this.setVersionForJava8(json.getString("versionForJava8"));
        this.setDescription(json.getString("description"));
    }
}
