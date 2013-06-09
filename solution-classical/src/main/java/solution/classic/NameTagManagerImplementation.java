package solution.classic;

import java.awt.Image;

import com.squeed.kata.nametag.NameTagManager;
import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.entities.Event;
import com.squeed.kata.nametag.services.PhotoDownloadResult;
import com.squeed.kata.nametag.services.PhotoDownloadService;
import com.squeed.kata.nametag.services.PhotoDownloadServiceManager;
import com.squeed.kata.nametag.services.PrintingService;

public class NameTagManagerImplementation implements NameTagManager {

	private final PhotoDownloadServiceManager downloadManager;
	private final PrintingService printingService;

	public NameTagManagerImplementation(PhotoDownloadServiceManager downloadManager, PrintingService printingService) {
		this.downloadManager = downloadManager;
		this.printingService = printingService;
	}

	@Override
	public void printNameTagsForEvent(Event event) {
		for (Attendee attendee : event.getExpectedAttendees()) {
			Image image = getImageForAttendee(attendee, event.getDefaultImage());
			printingService.printNameTagFor(attendee, image);
		}
	}

	private Image getImageForAttendee(Attendee attendee, Image defaultImage) {
		for (PhotoDownloadService d : downloadManager.getDownloadServices()) {
			PhotoDownloadResult downloadResult = d.downloadPhotoOf(attendee);
			if (downloadResult.photoWasDownloaded()) {
				return downloadResult.get().getImageData();
			}
		}
		return defaultImage;
	}

}
