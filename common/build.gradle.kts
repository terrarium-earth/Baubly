architectury {
    val enabledPlatforms: String by rootProject
    common(enabledPlatforms.split(","))
}

loom {
    accessWidenerPath = file("src/main/resources/baubly.accesswidener")
}

dependencies {
    modCompileOnly(group = "tech.thatgravyboat", name = "commonats", version = "2.0")
}
