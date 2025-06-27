package Operation;

/**
 * Lưu trữ thông tin bản quyền cho bài hát, album, hoặc playlist.
 */
public class Copyright {
    private String owner;
    private String year;
    private String description;

    public Copyright(String owner, String year, String description) {
        try {
            if (owner == null || owner.isEmpty()) {
                throw new IllegalArgumentException("Owner không thể là null hoặc rỗng.");
            }
            if (year == null || year.isEmpty()) {
                throw new IllegalArgumentException("Year không thể là null hoặc rỗng.");
            }
            if (description == null || description.isEmpty()) {
                throw new IllegalArgumentException("Description không thể là null hoặc rỗng.");
            }

            this.owner = owner;
            this.year = year;
            this.description = description;
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi trong constructor Copyright: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi không xác định trong constructor Copyright: " + e.getMessage());
        }
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        try {
            if (owner == null || owner.isEmpty()) {
                throw new IllegalArgumentException("Owner không thể là null hoặc rỗng.");
            }
            this.owner = owner;
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi trong setOwner: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi không xác định trong setOwner: " + e.getMessage());
        }
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        try {
            if (year == null || year.isEmpty()) {
                throw new IllegalArgumentException("Year không thể là null hoặc rỗng.");
            }
            this.year = year;
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi trong setYear: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi không xác định trong setYear: " + e.getMessage());
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        try {
            if (description == null || description.isEmpty()) {
                throw new IllegalArgumentException("Description không thể là null hoặc rỗng.");
            }
            this.description = description;
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi trong setDescription: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi không xác định trong setDescription: " + e.getMessage());
        }
    }

    public String toString() {
        try {
            return "Copyright © " + year + " by " + owner + ". " + description;
        } catch (Exception e) {
            System.out.println("Lỗi trong toString: " + e.getMessage());
            return "Lỗi khi hiển thị thông tin bản quyền.";
        }
    }
}
