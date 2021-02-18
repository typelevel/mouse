## Design Process for Adding a Feature

* Check the feature isn't already available or readily achievable with existing operations

* Consider and minimize risk of naming collisions for users who have imported mouse into existing code scopes. Dont use overly
short or generic names if possible.

* Add a test and test the feature manually

* Mention in the example section and in the release notes in README.md

## Tests

The tests dont have good descriptive labels as at Dec 2020. I've long believed that the best label for a well written test is the source code itself. The plan is to use [Sourcecode]() to generate labels based on the test code, however Sourcecode isn't published for Scala3+ScalaJS yet. Try again in a month or two.rr

### Release Process

Releases now occur via Github Actions CI. The server uses Ben Hutchison's Sonatype credentials to publish to maven. Push a tag as per https://github.com/olafurpg/sbt-ci-release#git