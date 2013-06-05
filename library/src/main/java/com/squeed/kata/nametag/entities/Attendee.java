package com.squeed.kata.nametag.entities;

/**
 * A person registered to attend an {@link Event}.
 */
public interface Attendee {

	String getName();
	String getEmailAddress();
	String getTwitterHandle();
	String getLinkedInProfileId();
	String getFacebookProfileId();
	
}
