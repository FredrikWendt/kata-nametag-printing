package solution.mockito;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import solution.mockito.NameTagManagerImplementation;

import com.squeed.kata.nametag.NameTagManager;
import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.entities.Event;
import com.squeed.kata.nametag.entities.Photo;
import com.squeed.kata.nametag.services.PhotoDownloadResult;
import com.squeed.kata.nametag.services.PhotoDownloadService;
import com.squeed.kata.nametag.services.PhotoDownloadServiceManager;
import com.squeed.kata.nametag.services.PrintingService;

@RunWith(MockitoJUnitRunner.class)
public class NameTagManagerImplementationTest {

	private NameTagManager testee;

	@Mock
	private PrintingService printer;
	@Mock
	private PhotoDownloadServiceManager downloadManager;
	@Mock
	private Image defaultImage;
	@Mock
	private Image downloadedImage;
	@Mock
	private Attendee attendee;
	@Mock
	private PhotoDownloadService downloadService1;
	@Mock
	private PhotoDownloadService downloadService2;

	@Before
	public void setup() {
		testee = new NameTagManagerImplementation(downloadManager, printer);
	}

	@Test
	public void withNoAttendees_NothingIsPrinted() throws Exception {
		Event event = givenAnEventWithZeroAttendees();

		testee.printNameTagsForEvent(event);

		verifyZeroInteractions(printer);
	}

	@Test
	public void withOneAttendee_AndZeroDownloaders_TheEventDefaultImageIsPrinted() throws Exception {
		Attendee attendee = mock(Attendee.class);
		Event event = givenAnEventWith(defaultImage, attendee);

		testee.printNameTagsForEvent(event);

		verify(printer).printNameTagFor(attendee, defaultImage);
	}

	@Test
	public void withOneAttendee_AndOneSuccessfulDownloader_TheDownloadedImageIsPrinted() throws Exception {
		Event event = givenAnEventWith(defaultImage, attendee);
		given(downloadManager.getDownloadServices()).willReturn(Arrays.asList(downloadService1));
		PhotoDownloadResult downloadResult = downloadResult(downloadedImage);
		given(downloadService1.downloadPhotoOf(attendee)).willReturn(downloadResult);

		testee.printNameTagsForEvent(event);

		verify(printer).printNameTagFor(attendee, downloadedImage);
	}

	@Test
	public void withOneAttendee_AndOneFailedOneSuccessfullDownloader_TheDownloadedImageIsPrinted() throws Exception {
		Event event = givenAnEventWith(defaultImage, attendee);
		given(downloadManager.getDownloadServices()).willReturn(Arrays.asList(downloadService1, downloadService2));
		given(downloadService1.downloadPhotoOf(attendee)).willReturn(emptyDownloadResult());
		givenDownloadServiceWillSucessfullyDownload(downloadService2, attendee, downloadedImage);

		testee.printNameTagsForEvent(event);

		verify(printer).printNameTagFor(attendee, downloadedImage);
		verifyNoMoreInteractions(printer);
	}

	private Event givenAnEventWithZeroAttendees() {
		Event event = mock(Event.class);
		given(event.getExpectedAttendees()).willReturn(new ArrayList<Attendee>());
		return event;
	}

	private Event givenAnEventWith(Image defaultImage, Attendee attendee) {
		Event event = mock(Event.class);
		given(event.getDefaultImage()).willReturn(defaultImage);
		given(event.getExpectedAttendees()).willReturn(Arrays.asList(attendee));
		return event;
	}

	private void givenDownloadServiceWillSucessfullyDownload(PhotoDownloadService downloadService, Attendee attendee2,
			Image image) {
		PhotoDownloadResult downloadResult = downloadResult(image);
		given(downloadService.downloadPhotoOf(attendee2)).willReturn(downloadResult);
	}

	private PhotoDownloadResult downloadResult(Image image) {
		Photo photo = mock(Photo.class);
		given(photo.getImageData()).willReturn(image);
		PhotoDownloadResult result = new PhotoDownloadResult(photo);
		return result;
	}

	private PhotoDownloadResult emptyDownloadResult() {
		PhotoDownloadResult result = new PhotoDownloadResult(null);
		return result;
	}

}
