package com.squeed.kata.nametag.services;

import com.squeed.kata.nametag.entities.Photo;

public class PhotoDownloadResult {

	private final Photo downloadedPhoto;

	public PhotoDownloadResult(Photo object) {
		this.downloadedPhoto = object;
	}

	public boolean photoWasDownloaded() {
		return downloadedPhoto != null;
	}

	public Photo get() {
		if (downloadedPhoto == null) {
			String message = "There was no photo download - use .photoWasDownloaded() before calling .get()";
			throw new IllegalStateException(message);
		}
		return downloadedPhoto;
	}

}
