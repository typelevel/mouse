## Design Process for Adding a Feature

* Check the feature isn't already available or readily achievable with existing operations

* Consider and minimize risk of naming collisions for users who have imported mouse into existing code scopes. Dont use overly
short or generic names if possible.

* Add a test and test the feature manually. Use the simplest test code that covers the added behavior - simple features do not need complex tests.

* Mention in the example section and in the release notes in README.md

## Conventions

* When an operation is provided in two variants that do the same thing, but differ in whether the arguments are evaluated lazily ("by-name") or eagerly, we have used the suffix `L` (for Lazy) to distinguish the names (see #247)[https://github.com/typelevel/mouse/issues/247] for example).

However, for new operations, simply providing a lazy by-name variant is often the best choice unless there are clear reasons (eg performance impact) for needing an eager variant.
 
### Release Process

Mouse uses Github Actions, https://github.com/djspiewak/sbt-github-actions and https://github.com/typelevel/sbt-typelevel for CI releases. Use the Github Create Release feature to tag a release, and it will publish to Sonatype automatically (using @benhutchison credentials).

sbt-release and sbt-ci-release is no longer in use.
