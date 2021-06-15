# Enum Lookups

Set of utility functions to get enums from their ordinal, name or any custom value defined

### Functions

- `lookup<MyEnum>(value, defaultEnum)` returns the enum by its ordinal (order in which it is defined). If no enum was found, returns the default enum defined. If not specified, the first enum is returned.

- `lookupByName<MyEnum>(name, defaultEnum, ignoreCase)` returns the enum by its name. If no enum was found, returns the default enum defined. Name case can also be ignored.

- `lookupFilter<MyEnum>(predicate)` returns a list of enums verifying the predicate.

- `MyEnum::myValue.lookupByValue(value)` returns the enum by its custom value. If no enum was found, returns the default enum defined.

- `MyEnum::myValue from value` infix notation for `lookupByValue`, with default params.

### How to use

Include this in your build.gradle:

`implementation 'io.github.zahichemaly:enumlookups:1.0.0'`
