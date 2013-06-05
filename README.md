Kata Name Tag Printing
======================

With this kata, we practice working with test doubles.  It is suggested that you first try without a stubbing/mocking framework.

The actual task consists of writing a method that prints name tags for `Attendee`s of an `Event`. There's a `NameTagPrintingService` which you should pass an `Attendee` and a `Photo` in order to actually print a name tag. To help you out downloading images for each attendee, there's a list of `PhotoDownloadingService`s which you get from a `PhotoDownloadingServiceManager`. It may give you zero or more service objects, and those may in turn give you zero or one `Photo`s, encapsulated in an `Option<Photo>`. If no photo could be downloaded using the downloading services, you should print the default image/photo setup for the `Event`.
