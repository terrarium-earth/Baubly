rootProject.name = "Baubly"

pluginManagement {
    repositories {
        maven(url = "https://maven.msrandom.net/repository/cloche")
        maven(url = "https://maven.msrandom.net/repository/root")
        maven(url = "https://maven.resourcefulbees.com/repository/maven-public/")
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    versionCatalogs.create("libs") {
        from(files("libs.versions.toml"))
    }
}