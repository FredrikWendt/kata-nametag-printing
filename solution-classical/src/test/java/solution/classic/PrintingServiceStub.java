package solution.classic;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.services.PrintingService;

public class PrintingServiceStub implements PrintingService {

	private Map<Attendee, Image> imagePrinted = new HashMap<Attendee, Image>();

	@Override
	public void printNameTagFor(Attendee attendee, Image image) {
		imagePrinted.put(attendee, image);
	}

	public Map<Attendee, Image> getPrintedPairs() {
		return imagePrinted;
	}

}
