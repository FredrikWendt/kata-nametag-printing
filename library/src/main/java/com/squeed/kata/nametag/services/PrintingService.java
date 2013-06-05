package com.squeed.kata.nametag.services;

import java.awt.Image;

import com.squeed.kata.nametag.entities.Attendee;

public interface PrintingService {

	void printNameTagFor(Attendee attendee, Image image);
	
}
