package musicPlayer;

import java.util.ArrayList;

public class ArtistList {
    ArrayList<Artist> artists = new ArrayList<>();

    public ArrayList<Artist> addArtist(Artist artist) {
        try {
            if (artist != null) {
                artists.add(artist);
            } else {
                System.out.println("Không thể thêm nghệ sĩ, đối tượng artist là null.");
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong addArtist: " + e.getMessage());
        }
        return artists;
    }

    public ArrayList<Artist> editArtist(String newName, String artistID) {
        try {
            boolean found = false;
            for (int i = 0; i < artists.size(); i++) {
                if (artists.get(i).getArtistID().equals(artistID)) {
                    artists.get(i).setName(newName);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy nghệ sĩ với ID: " + artistID);
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong editArtist: " + e.getMessage());
        }
        return artists;
    }

    public ArrayList<Artist> deleteArtist(String artistID) {
        try {
            boolean found = false;
            for (int i = 0; i < artists.size(); i++) {
                if (artists.get(i).getArtistID().equals(artistID)) {
                    artists.remove(i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy nghệ sĩ với ID: " + artistID);
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong deleteArtist: " + e.getMessage());
        }
        return artists;
    }

    public void printArtistList() {
        try {
            if (artists.isEmpty()) {
                System.out.println("Danh sách nghệ sĩ đang trống.");
            } else {
                for (Artist artist : artists) {
                    System.out.println("Artist ID: " + artist.getArtistID() + " Name: " + artist.getName());
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi trong printArtistList: " + e.getMessage());
        }
    }
}
