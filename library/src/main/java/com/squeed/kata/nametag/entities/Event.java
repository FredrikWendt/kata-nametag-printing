package com.squeed.kata.nametag.entities;

import java.awt.Image;
import java.util.List;

/**
 * An event, such as those announced on Meetup.com.
 */
public interface Event {

	/**
	 * Returns a list of people that have registered for attending the event.
	 * 
	 * @return a list of people that have registered for attending the event.
	 */
	List<Attendee> getExpectedAttendees();
	
	/**
	 * Returns the event's default image.
	 * 
	 * @return the event's default image
	 */
	Image getDefaultImage();
	
}
