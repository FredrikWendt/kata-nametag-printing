package solution;

import com.squeed.kata.nametag.entities.Event;
import com.squeed.kata.nametag.services.NameTagPrintingService;
import com.squeed.kata.nametag.services.PhotoDownloadingManager;

public class NameTagManager {
	
	private final PhotoDownloadingManager photoDownloadManager;
	private final NameTagPrintingService nameTagPrinter;

	public NameTagManager(PhotoDownloadingManager photoDownloadManager, NameTagPrintingService nameTagPrinter) {
		this.photoDownloadManager = photoDownloadManager;
		this.nameTagPrinter = nameTagPrinter;
	}

	public void printNameTagsForEvent(Event event) {
		throw new RuntimeException("Not implemented - FIXME!");
	}
}
