package com.squeed.kata.nametag;

import com.squeed.kata.nametag.entities.Event;

/**
 * Prints name tags for all attendees of the Event, with a photo from the web of
 * the attendee or with the Event's default image if no photo could be
 * downloaded.
 */
public interface NameTagManager {

	/**
	 * Prints name tags for all attendees of the Event.
	 * 
	 * @param even the event to process
	 */
	void printNameTagsForEvent(Event event);

}
