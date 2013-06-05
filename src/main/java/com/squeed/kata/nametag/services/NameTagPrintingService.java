package com.squeed.kata.nametag.services;

import com.squeed.kata.nametag.entities.Attendee;
import com.squeed.kata.nametag.entities.Image;

public interface NameTagPrintingService {

	void printTagFor(Attendee visitor, Image image);
	
}
