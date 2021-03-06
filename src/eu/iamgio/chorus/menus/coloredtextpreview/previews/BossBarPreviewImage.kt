package eu.iamgio.chorus.menus.coloredtextpreview.previews

import eu.iamgio.chorus.Chorus
import eu.iamgio.chorus.minecraft.chat.ChatParser
import eu.iamgio.chorus.util.toFlowList
import eu.iamgio.chorus.util.withStyleClass
import javafx.scene.image.Image
import javafx.scene.text.TextAlignment
import javafx.scene.text.TextFlow

/**
 * @author Gio
 */
class BossBarPreviewImage(text: String) : ColoredTextPreviewImage(
        Image(Chorus::class.java.getResourceAsStream("/assets/minecraft/previews/bossbar-background.png")),
        listOf(ChatParser(text).toTextFlow().withStyleClass("minecraft-bossbar-preview-flow")).toFlowList()
) {

    override fun initFlow(flow: TextFlow, index: Int) {
        flow.prefWidth = image.width
        flow.textAlignment = TextAlignment.CENTER
    }
}