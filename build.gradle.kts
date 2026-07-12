@file:Suppress("UnstableApiUsage")

import groovy.json.StringEscapeUtils

plugins {
    java
    id("maven-publish")
    id("com.teamresourceful.resourcefulgradle") version "0.0.+"
    alias(libs.plugins.cloche)
}

repositories {
    cloche {
        librariesMinecraft()
        mavenNeoforged()
        mavenFabric()
        mavenNeoforgedMeta()
        mavenParchment()
    }
    maven(url = "https://central.sonatype.com/artifact")
    maven(url = "https://maven.resourcefulbees.com/repository/maven-public/")
    maven(url = "https://maven.ladysnake.org/releases")
    maven(url = "https://maven.terraformersmc.com/")
    maven(url = "https://maven.msrandom.net/repository/root")
    mavenCentral()
}

val modID = project.property("modId").toString()
val modVersion = project.property("version").toString()

cloche {
    minecraftVersion = libs.versions.minecraft

    metadata {
        modId = modID
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
        accessWideners.from(file("src/main/baubly.accesswidener"))

        dependencies {
            compileOnly(libs.annotations)
        }
    }

    fabric {
        loaderVersion = libs.versions.fabric

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

            modLocalRuntime(libs.modmenu)
        }
    }

    neoforge {
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
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            pom {
                url.set("https://github.com/terrarium-earth/$modID")

                scm {
                    connection.set("git:https://github.com/terrarium-earth/$modID.git")
                    developerConnection.set("git:https://github.com/terrarium-earth/$modID.git")
                    url.set("https://github.com/terrarium-earth/$modID")
                }

                licenses {
                    license {
                        name.set("MIT")
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
            val version = project.property("version").toString()
            val changelog: String = file("changelog.md").readText(Charsets.UTF_8)

            source.set(file("templates/embed.json.template"))
            injectedValues.set(mapOf(
                    "minecraft" to libs.versions.minecraft.get(),
                    "version" to version,
                    "changelog" to StringEscapeUtils.escapeJava(changelog),
            ))
        }
    }
}