## Design Process for Adding a Feature

* Check the feature isn't already available or readily achievable with existing operations

* Consider and minimize risk of naming collisions for users who have imported mouse into existing code scopes. Dont use overly
short or generic names if possible.

* Add a test and test the feature manually. Use the simplest test code that covers the added behavior - simple features do not need complex tests.

* Mention in the example section and in the release notes in README.md

### Release Process

Mouse uses Github Actions, https://github.com/djspiewak/sbt-github-actions and https://github.com/olafurpg/sbt-ci-release for CI releases. Use the Github Create Release feature to tag a release, and it will publish to Sonatype automatically (using @benhutchison credentials).

sbt-release is no longer in use.
