package hi1237.hello.boot.spring5boot.dao;

import java.util.List;

public interface GalleryDAO {
    List<Gallery> selectGallery(int stnum);
}
