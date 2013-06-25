package com.squeed.kata.nametag.services;

import com.squeed.kata.nametag.entities.Attendee;

/**
 * A service that may know how to download a photo of an event attendee, such as
 * Facebook, LinkedIn, Twitter or Gravatar for an account or profile photo.
 */
public interface PhotoDownloadService {

	/**
	 * This method always returns a PhotoDownloadResult (never null).
	 * <p>
	 * If the downloading attempt failed, it returns a PhotoDownloadResult that says so.
	 */
	PhotoDownloadResult downloadPhotoOf(Attendee attendee);

}
