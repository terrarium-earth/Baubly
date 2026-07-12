plugins {
    java
    id("maven-publish")
    id("com.teamresourceful.resourcefulgradle") version "0.0.+"
    alias(libs.plugins.cloche)
}

repositories {
    maven(url = "https://maven.architectury.dev/")
    maven(url = "https://maven.minecraftforge.net/")
    maven(url = "https://maven.resourcefulbees.com/repository/maven-public/")
    maven(url = "https://maven.neoforged.net/releases/")
    maven(url = "https://maven.twelveiterations.com/repository/maven-public/")
    maven(url = "https://maven.ladysnake.org/releases")
    maven(url = "https://maven.terraformersmc.com/")
}

val modID = project.property("modId")
val modVersion = project.property("version")

cloche {
    metadata {
        modId = "baubly"
        name = "Baubly"
        description = "An api to help with registering Curios & Trinkets baubles."
        license = "MIT"
        author("CodexAdrian")
    }

    mappings {
        official()
        parchment(libs.versions.parchment)
    }

    common {

    }

    fabric {
        loaderVersion = libs.versions.fabric
        minecraftVersion = libs.versions.minecraft

        includedClient()
        runs {
            client()
            server()
        }

        metadata {
            entrypoint("client", "earth.terrarium.baubly.fabric.BaublyFabric::init")
        }

        dependencies {
            fabricApi(libs.versions.fapi)
            modApi.bundle(libs.bundles.cardinalComponents)
            modApi(libs.trinkets)
            modImplementation(libs.modmenu)

            modCompileOnly(libs.fabric.jei)
            modCompileOnly(libs.fabric.rei)
        }
    }

    neoforge {
        minecraftVersion = libs.versions.minecraft
        loaderVersion = libs.versions.neoforge

        metadata {
            modLoader = "javafml"
            loaderVersion {
                start = "1"
            }
        }

        runs {
            client()
            server {
                jvmArgs("--nogui")
            }
        }

        dependencies {
            modApi(libs.curios)

            modCompileOnly(libs.neoforge.jei)
            modCompileOnly(libs.neoforge.rei)
        }
    }
}

/*
publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "$modId-$modLoader-$minecraftVersion"
            from(components["java"])

            pom {
                name.set("Baubly $modLoader")
                url.set("https://github.com/terrarium-earth/$modId")

                scm {
                    connection.set("git:https://github.com/terrarium-earth/$modId.git")
                    developerConnection.set("git:https://github.com/terrarium-earth/$modId.git")
                    url.set("https://github.com/terrarium-earth/$modId")
                }

                licenses {
                    license {
                        name.set("ARR")
                    }
                }
            }
        }
    }
    repositories {
        maven {
            setUrl("https://maven.resourcefulbees.com/repository/terrarium/")
            credentials {
                username = System.getenv("MAVEN_USER")
                password = System.getenv("MAVEN_PASS")
            }
        }
    }
}

resourcefulGradle {
    templates {
        register("embed") {
            val minecraftVersion: String by project
            val version: String by project
            val changelog: String = file("changelog.md").readText(Charsets.UTF_8)

            source.set(file("templates/embed.json.template"))
            injectedValues.set(mapOf(
                    "minecraft" to minecraftVersion,
                    "version" to version,
                    "changelog" to StringEscapeUtils.escapeJava(changelog),
            ))
        }
    }
}
*/