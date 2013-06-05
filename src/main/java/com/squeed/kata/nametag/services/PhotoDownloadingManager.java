package com.squeed.kata.nametag.services;

import java.util.List;

/**
 * Manages photo download service instances (keeps them in a pool, creates new
 * as needed etc).
 */
public interface PhotoDownloadingManager {

	/**
	 * Returns a list of downloaders that can be used for downloading photos of
	 * attendees. The list is sorted in "preferred" order.
	 * 
	 * @return a list of downloaders.
	 */
	List<PhotoDownloadingService> getDownloaders();

}
