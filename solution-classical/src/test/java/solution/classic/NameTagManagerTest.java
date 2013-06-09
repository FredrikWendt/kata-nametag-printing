package solution.classic;

import static org.junit.Assert.assertEquals;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Map;

import org.junit.Test;

import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.entities.Event;
import com.squeed.kata.nametag.services.PhotoDownloadService;

public class NameTagManagerTest {

	private NameTagManagerImplementation testee;

	private Image defaultImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
	private Image downloadedImage1 = new BufferedImage(2, 2, BufferedImage.TYPE_INT_RGB);
	private Image downloadedImage2 = new BufferedImage(3, 3, BufferedImage.TYPE_INT_RGB);

	private PrintingServiceStub printingService = new PrintingServiceStub();

	private Attendee attendee1 = new AttendeeStub("1");
	private Attendee attendee2 = new AttendeeStub("2");
	private Attendee attendee3 = new AttendeeStub("3");

	@Test
	public void use_default_image_when_there_are_zero_downloaders() throws Exception {
		testee = new NameTagManagerImplementation(new DownloadManagerRealStub(), printingService);
		Event event = new EventStub(defaultImage, attendee1);

		testee.printNameTagsForEvent(event);

		Map<Attendee, Image> printedPairs = printingService.getPrintedPairs();
		assertEquals(defaultImage, printedPairs.get(attendee1));
	}

	@Test
	public void one_tag_is_printed_for_each_attendee() throws Exception {
		testee = new NameTagManagerImplementation(new DownloadManagerRealStub(), printingService);
		Event event = new EventStub(defaultImage, attendee1, attendee2, attendee3);

		testee.printNameTagsForEvent(event);

		Map<Attendee, Image> printedPairs = printingService.getPrintedPairs();
		assertEquals(defaultImage, printedPairs.get(attendee1));
		assertEquals(defaultImage, printedPairs.get(attendee2));
		assertEquals(defaultImage, printedPairs.get(attendee3));
	}

	@Test
	public void will_use_downloaded_photo_when_possible() throws Exception {
		PhotoDownloadService service1 = new PhotoDownloadServiceStub(attendee1, downloadedImage1);
		testee = new NameTagManagerImplementation(new DownloadManagerRealStub(service1), printingService);
		Event event = new EventStub(defaultImage, attendee1);

		testee.printNameTagsForEvent(event);

		Map<Attendee, Image> printedPairs = printingService.getPrintedPairs();
		assertEquals(downloadedImage1, printedPairs.get(attendee1));
	}

	@Test
	public void test_mix_of_default_and_downloaded_images() throws Exception {
		PhotoDownloadService service1 = new PhotoDownloadServiceStub(attendee1, downloadedImage1);
		PhotoDownloadService service2 = new PhotoDownloadServiceEmptyStub();
		PhotoDownloadService service3 = new PhotoDownloadServiceStub(attendee3, downloadedImage2);
		DownloadManagerRealStub downloadManager = new DownloadManagerRealStub(service1, service2, service3);
		testee = new NameTagManagerImplementation(downloadManager, printingService);
		Event event = new EventStub(defaultImage, attendee1, attendee2, attendee3);

		testee.printNameTagsForEvent(event);

		Map<Attendee, Image> printedPairs = printingService.getPrintedPairs();
		assertEquals(downloadedImage1, printedPairs.get(attendee1));
		assertEquals(defaultImage, printedPairs.get(attendee2));
		assertEquals(downloadedImage2, printedPairs.get(attendee3));
	}
}
