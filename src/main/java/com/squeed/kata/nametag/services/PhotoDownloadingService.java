package com.squeed.kata.nametag.services;

import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.entities.Optional;
import com.squeed.kata.nametag.entities.Image;

/**
 * A service that may know how to download a photo of an event attendee, such as
 * Gravatar, or scraping LinkedIn or Twitter for an account or profile photo.
 */
public interface PhotoDownloadingService {

	Optional<Image> downloadPhotoOf(Attendee visitor);

}
