package com.squeed.kata.nametag.services;

import java.util.List;

/**
 * Manages photo download service instances (keeps them in a pool, creates new
 * as needed etc).
 */
public interface PhotoDownloadServiceManager {

	/**
	 * Returns a list of download services that can be used for downloading photos of
	 * attendees. The list is sorted in "preferred" order.
	 * 
	 * @return a list of download services.
	 */
	List<PhotoDownloadService> getDownloadServices();

}
