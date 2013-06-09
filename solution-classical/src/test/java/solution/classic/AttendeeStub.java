package solution.classic;

import com.squeed.kata.nametag.entities.Attendee;

public class AttendeeStub implements Attendee {

	private String name;

	public AttendeeStub(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "-" + name;
	}

	@Override
	public String getEmailAddress() {
		return null;
	}

	@Override
	public String getTwitterHandle() {
		return null;
	}

	@Override
	public String getLinkedInProfileId() {
		return null;
	}

	@Override
	public String getFacebookProfileId() {
		return null;
	}

}
