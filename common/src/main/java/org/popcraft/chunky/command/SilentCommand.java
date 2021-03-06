package org.popcraft.chunky.command;

import org.popcraft.chunky.Chunky;
import org.popcraft.chunky.platform.Sender;

import static org.popcraft.chunky.util.Translator.translate;

public class SilentCommand extends ChunkyCommand {
    public SilentCommand(Chunky chunky) {
        super(chunky);
    }

    public void execute(Sender sender, String[] args) {
        chunky.getOptions().setSilent(!chunky.getOptions().isSilent());
        String status = translate(chunky.getOptions().isSilent() ? "enabled" : "disabled");
        sender.sendMessagePrefixed("format_silent", status);
    }
}
