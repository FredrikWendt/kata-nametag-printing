package solution;

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
	
	private final PhotoDownloadServiceManager photoDownloadManager;
	private final PrintingService printingService;

	public NameTagManagerImplementation(PhotoDownloadServiceManager photoDownloadManager, PrintingService nameTagPrinter) {
		this.photoDownloadManager = photoDownloadManager;
		this.printingService = nameTagPrinter;
	}

	@Override
	public void printNameTagsForEvent(Event event) {
		for (Attendee visitor : event.getExpectedAttendees()) {
			Image imageToPrint = getImageToPrintFor(visitor, event);
			printingService.printNameTagFor(visitor, imageToPrint);
		}
	}

	private Image getImageToPrintFor(Attendee visitor, Event event) {
		for (PhotoDownloadService downloader : photoDownloadManager.getDownloadServices()) {
			PhotoDownloadResult downloadResult = downloader.downloadPhotoOf(visitor);
			if (downloadResult.photoWasDownloaded()) {
				Photo downloadedImage = downloadResult.get();
				return downloadedImage.getImageData();
			}
		}
		return event.getDefaultImage();
	}

}
