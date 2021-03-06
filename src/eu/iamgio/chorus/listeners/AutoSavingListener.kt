package eu.iamgio.chorus.listeners

import eu.iamgio.chorus.editor.EditorArea
import eu.iamgio.chorus.editor.events.EditorEvent
import eu.iamgio.chorus.util.config
import eu.iamgio.libfx.timing.RepeatingTimer
import javafx.util.Duration
import org.fxmisc.richtext.model.RichTextChange

/**
 * @author Gio
 */
class AutoSavingListener : EditorEvent() {

    private val timer = RepeatingTimer()
    private val areas = ArrayList<EditorArea>()
    private val editedAreas = ArrayList<EditorArea>()

    override fun onChange(change: RichTextChange<Collection<String>, String, Collection<String>>, area: EditorArea) {
        if((area.supportsHighlighting() && config.getBoolean("2.Autosaving.1.Enabled_(YAML)")) ||
                !area.supportsHighlighting() && config.getBoolean("2.Autosaving.2.Enabled_(other_formats)")) {
            editedAreas.add(area)
            if(!areas.contains(area)) {
                timer.start({
                    if(editedAreas.contains(area)) {
                        area.saveFile()
                        editedAreas.remove(area)
                    }
                }, Duration.millis(config.getInt("2.Autosaving.3.Delay_(ms)").toDouble()))
                areas.add(area)
            }
        }
    }
}