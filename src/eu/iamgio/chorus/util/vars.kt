package eu.iamgio.chorus.util

import eu.iamgio.chorus.Chorus
import eu.iamgio.chorus.configuration.ChorusConfig
import eu.iamgio.chorus.minecraft.entity.Entity
import eu.iamgio.chorus.minecraft.particle.Particle
import javafx.scene.control.Tab
import javafx.scene.image.Image
import java.io.File

val colorPrefix: String
    get() = config.getString("4.Minecraft.1.Color_prefix")

val tabs = HashMap<File, Tab>()
val itemIcons = HashMap<Short, List<Image>>()
val particleIcons = HashMap<Particle, Image>()
val effectIcons = HashMap<Short, Image>()
val entityIcons = HashMap<Entity, Image>()
val config: ChorusConfig = Chorus.getInstance().config