package solution.classic;

import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.services.PhotoDownloadResult;
import com.squeed.kata.nametag.services.PhotoDownloadService;

public class PhotoDownloadServiceEmptyStub implements PhotoDownloadService {

	@Override
	public PhotoDownloadResult downloadPhotoOf(Attendee attendee) {
		return new PhotoDownloadResult(null);
	}

}
