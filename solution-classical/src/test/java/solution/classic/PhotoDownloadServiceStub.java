package solution.classic;

import java.awt.Image;

import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.entities.Photo;
import com.squeed.kata.nametag.services.PhotoDownloadResult;
import com.squeed.kata.nametag.services.PhotoDownloadService;

public class PhotoDownloadServiceStub implements PhotoDownloadService {

	private Image image;
	private Attendee attendee1;

	public PhotoDownloadServiceStub(Attendee attendee1, Image downloadedImage1) {
		this.attendee1 = attendee1;
		this.image = downloadedImage1;
	}

	@Override
	public PhotoDownloadResult downloadPhotoOf(Attendee attendee) {
		if (this.attendee1.equals(attendee)) {
			return new PhotoDownloadResult(new Photo() {
				@Override
				public Image getImageData() {
					return image;
				}
			});
		}
		return new PhotoDownloadResult(null);
	}

}
