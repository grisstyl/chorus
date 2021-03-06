package eu.iamgio.chorus.listeners

import eu.iamgio.chorus.editor.EditorArea
import eu.iamgio.chorus.editor.events.EditorEvent
import javafx.application.Platform
import org.fxmisc.richtext.model.RichTextChange

/**
 * @author Gio
 */
class AutoTabListener : EditorEvent() {

    override fun onChange(change: RichTextChange<Collection<String>, String, Collection<String>>, area: EditorArea) {
        if(change.inserted.text == "\n") {
            val replacement = area.getInit(area.currentParagraph)
            if(!replacement.isEmpty()) {
                area.insertText(change.position + 1, replacement)
                Platform.runLater {area.moveTo(change.position + replacement.length + 1)}
            }
        }
    }
}