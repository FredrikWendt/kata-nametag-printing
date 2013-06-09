package solution.classic;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.entities.Event;

public class EventStub implements Event {

	private Image defaultImage;
	private List<Attendee> expectedAttendees = new ArrayList<Attendee>();

	public EventStub(Image defaultImage) {
		this.defaultImage = defaultImage;
	}

	public EventStub(Image defaultImage2, Attendee... attendees) {
		this(defaultImage2);
		this.expectedAttendees = Arrays.asList(attendees);
	}

	@Override
	public List<Attendee> getExpectedAttendees() {
		return expectedAttendees;
	}

	@Override
	public Image getDefaultImage() {
		return defaultImage;
	}

}
