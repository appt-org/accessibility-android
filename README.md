# Accessibility

The purpose of this library is to provide a unified way for accessibility features on Android on iOS.

All accessibility methods are available through the `Accessibility` class. Additionally, an `accessibility` property is added to all classes which inherit from `View`, `Activity` and `Fragment`.

Example:

Providing an accessibility label:
- on Android you would set `contentDescription`
- on iOS you would set `accessibilityLabel`

With this library you can can use `accessibility.label` on Android and iOS. The library calls the native methods.

## Features
- View
	- `label`: set the accessibility label
	- `action`: set the accessibility action to announce
	- `elements`: set the order of accessibility elements
	- `focus()`: moves the accessibility focus to this view 
- Activity/Fragment
	- `elements`: set the order of accessibility elements
	- `announce(message)`: announces the provided message

## Requirements

Minimum supported Android version is 5.0 (API 21)

## Example

To run the example project, clone the repo, and open the project in Android Studio.

## Adding to your project

To start using this library, add these lines to the `build.gradle` of your project:

```groovy
repositories {
    jcenter()
}

dependencies {
    compile 'nl.appt.accessibility:accessibility:<latest-version>'
}
```

Note: in the near future the library will be made migrated to Maven Central.

## Author

Jan Jaap de Groot, janjaap@appt.nl

## License

Accessibility is available under the MIT license. See the LICENSE file for more info.