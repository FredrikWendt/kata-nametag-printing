package com.squeed.kata.nametag.services;

import com.squeed.kata.nametag.entities.Attendee;

/**
 * A service that may know how to download a photo of an event attendee, such as
 * Facebook, LinkedIn, Twitter or Gravatar for an account or profile photo.
 */
public interface PhotoDownloadService {

	PhotoDownloadResult downloadPhotoOf(Attendee attendee);

}
