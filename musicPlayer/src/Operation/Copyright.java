package Operation;

/**
 * Lưu trữ thông tin bản quyền cho bài hát, album, hoặc playlist.
 */
public class Copyright {
    private String owner;
    private String year;
    private String description;

    public Copyright(String owner, String year, String description) {
        this.owner = owner;
        this.year = year;
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Copyright © " + year + " by " + owner + ". " + description;
    }
}
