## Design Process for Adding a Feature

* Check the feature isn't already available or readily achievable with existing operations

* Consider and minimize risk of naming collisions for users who have imported mouse into existing code scopes. Dont use overly
short or generic names if possible.

* Add a test and test the feature manually

* Mention in the example section and in the release notes in README.md

### Release Process

Commit but don't push all changes.

```
> sbt

sbt> release

//manual check of console output looks correct

sbt> sonatypeRelease

> git push


```