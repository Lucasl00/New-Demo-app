# Fintech core logic demo

A minimal Java/Gradle project simulating the kind of "core function" logic a
fintech Android app would unit test — transaction validation, fee calculation,
balance checks. No Android SDK or emulator needed; this is exactly the part
of Android CI/CD that runs fast, on every commit, without a device.

## Files

- `src/main/java/.../TransactionValidator.java` — the logic under test
- `src/test/java/.../TransactionValidatorTest.java` — JUnit 4 tests
- `build.gradle` / `settings.gradle` — Gradle project config
- `.github/workflows/ci.yml` — CI pipeline: runs `./gradlew test` on every push/PR

## Before you run anything: generate the Gradle wrapper

This project references `./gradlew` (the Gradle Wrapper), which lets anyone
run the exact right Gradle version without installing it separately — this
is standard practice for every real Android project. I could not generate
the wrapper files myself (they require Gradle to actually run once), so
you'll need to do this one-time step yourself:

1. Install Gradle if you don't have it: https://gradle.org/install/
2. In this project folder, run:
   ```bash
   gradle wrapper
   ```
   This creates `gradlew`, `gradlew.bat`, and a `gradle/` folder — commit
   all of these to your repo. After this, anyone (including GitHub's CI
   runner) can use `./gradlew` without installing Gradle themselves.

## Run locally

```bash
./gradlew test
```

## Push to GitHub

Same flow as before:

```bash
cd fintech-core-demo
git init
git add .
git commit -m "Initial commit: fintech core logic demo"
git branch -M main
git remote add origin <your-empty-github-repo-url>
git push -u origin main
```

Check the Actions tab afterward — same pattern as your Python project.
