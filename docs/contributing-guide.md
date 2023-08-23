# Contributing guide

### Design Process for Adding a Feature

* Check the feature isn't already available or readily achievable with existing operations

* Consider and minimize risk of naming collisions for users who have imported mouse into existing code scopes. Don't use overly
  short or generic names if possible.

* Add a test and test the feature manually. Use the simplest test code that covers the added behavior - simple features do not need complex tests.

* Mention in the example section and in the release notes in README.md

### Conventions

* When an operation is provided in two variants that do the same thing, but differ in whether the arguments are evaluated lazily ("by-name") or eagerly, we have used the suffix `L` (for Lazy) to distinguish the names (see [#247]) for example).

However, for new operations, simply providing a lazy by-name variant is often the best choice unless there are clear reasons (eg performance impact) for needing an eager variant.

### Release Process

Mouse uses Github Actions, [sbt-github-actions] and [sbt-typelevel] for CI releases. 
Use the Github Create Release feature to tag a release, 
and it will publish to Sonatype automatically (using @benhutchison credentials).

### Choosing an Appropriate Base Branch

There are two options for choosing a base branch for your PRs:

* Use the `main` branch if you would like to deliver changes within the `1.x` series. It's for binary-compatible changes only.

* Use the `series/2.x` branch if you would like to deliver changes within the `2.x` series. It's for non-binary-compatible changes and basically stands for the next major `mouse` release.


[sbt-github-actions]: https://github.com/djspiewak/sbt-github-actions
[sbt-typelevel]: https://github.com/typelevel/sbt-typelevel
[#247]: https://github.com/typelevel/mouse/issues/247