architectury {
    fabric()
}

val common: Configuration by configurations.creating {
    configurations.compileClasspath.get().extendsFrom(this)
    configurations.runtimeClasspath.get().extendsFrom(this)
    configurations["developmentFabric"].extendsFrom(this)
}

dependencies {
    common(project(":common", configuration = "namedElements")) {
        isTransitive = false
    }
    shadowCommon(project(path = ":common", configuration = "transformProductionFabric")) {
        isTransitive = false
    }

    val minecraftVersion: String by project
    val fabricLoaderVersion: String by project
    val fabricApiVersion: String by project
    val modMenuVersion: String by project
    val trinketsVersion: String by project

    modImplementation(group = "net.fabricmc", name = "fabric-loader", version = fabricLoaderVersion)
    modApi(group = "net.fabricmc.fabric-api", name = "fabric-api", version = "$fabricApiVersion+$minecraftVersion")

    modApi(group = "com.terraformersmc", name = "modmenu", version = modMenuVersion)
    modApi("dev.onyxstudios.cardinal-components-api:cardinal-components-base:5.4.0")
    modApi("dev.onyxstudios.cardinal-components-api:cardinal-components-entity:5.4.0")

    modImplementation(group = "dev.emi", name = "trinkets", version = trinketsVersion)
}
