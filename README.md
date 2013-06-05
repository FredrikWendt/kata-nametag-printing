Kata Name Tag Printing
======================

With this kata, we practice working with test doubles.  It is suggested that you first try without a stubbing/mocking framework.

The actual task consists of writing a method that prints name tags for `Attendee`s of an `Event`. There's a `NameTagPrintingService` which you should pass an `Attendee` and a `Photo` in order to actually print a name tag. To help you out downloading images for each attendee, there's a list of `PhotoDownloadingService`s which you get from a `PhotoDownloadingServiceManager`. It may give you zero or more service objects, and those may in turn give you zero or one `Photo`s, encapsulated in an `Option<Photo>`. If no photo could be downloaded using the downloading services, you should print the default image/photo setup for the `Event`.


Requirements
------------

The requirements here are rather small, to allow for repeating the exercise with/without a stubbing/mocking framework.

  * A name tag should be printed for each person (`Attendee`) in the `Event`.
  * If none of the downloaders finds a photo of the `Attendee`, the default image from the `Event` should be used.


Additionals
-----------

  * Only print name tags for attendees that have a LinkedIn profile.
  * Only print name tags for attendees that have a photo/image.
  * Don't print name tags for attendees that are organizers (add a field to `Attendee`).
  * Extend exercise to include `Template` objects and a `TemplateManager`, which takes an `Event` and returns a template. This template should be handed over to the TagNamePrinter.
    * Use a separate template for organizing attendees.
    * Use a separate template for people with/without photo.
