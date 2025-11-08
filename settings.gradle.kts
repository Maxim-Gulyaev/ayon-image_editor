pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("https://androidx.dev/snapshots/builds/13511472/artifacts/repository")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Ayon"
include(":app")
include(":core")
include(":core:ui")
include(":feature_modules")
include(":feature_modules:home")
include(":feature_modules:settings")
include(":core:navigation")
include(":core:datastore")
include(":core:model")
include(":core:domain")
include(":core:data")
include(":core:common")
include(":feature_modules:run")
include(":feature_modules:profile")
include(":core:database")
include(":core:testing")
