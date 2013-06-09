package solution;

import com.squeed.kata.nametag.NameTagManager;
import com.squeed.kata.nametag.entities.Event;
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
		// FIXME: implement this
	}

}
