package solution.mockito;

import java.awt.Image;

import com.squeed.kata.nametag.NameTagManager;
import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.entities.Event;
import com.squeed.kata.nametag.entities.Photo;
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
			Image imageToPrint = getImageToPrintFor(attendee, event);
			printingService.printNameTagFor(attendee, imageToPrint);
		}
	}

	private Image getImageToPrintFor(Attendee attendee, Event event) {
		for (PhotoDownloadService downloader : downloadManager.getDownloadServices()) {
			PhotoDownloadResult downloadResult = downloader.downloadPhotoOf(attendee);
			if (downloadResult.photoWasDownloaded()) {
				Photo downloadedImage = downloadResult.get();
				return downloadedImage.getImageData();
			}
		}
		return event.getDefaultImage();
	}

}
