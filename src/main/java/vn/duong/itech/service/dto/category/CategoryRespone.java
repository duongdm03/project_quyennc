package vn.duong.itech.service.dto.category;

public class CategoryRespone {

    private int id;
    private String name;

    public CategoryRespone() {}

    public CategoryRespone(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
