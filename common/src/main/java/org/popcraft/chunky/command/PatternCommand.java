package org.popcraft.chunky.command;

import org.popcraft.chunky.Chunky;
import org.popcraft.chunky.platform.Sender;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PatternCommand extends ChunkyCommand {
    private static final List<String> PATTERNS = Arrays.asList("concentric", "loop", "spiral");

    public PatternCommand(Chunky chunky) {
        super(chunky);
    }

    public void execute(Sender sender, String[] args) {
        if (args.length < 2) {
            sender.sendMessage("help_pattern");
            return;
        }
        String pattern = args[1].toLowerCase();
        if (!PATTERNS.contains(pattern.startsWith("chunked_") ? pattern.substring("chunked_".length()) : pattern)) {
            sender.sendMessage("help_pattern");
            return;
        }
        chunky.getSelection().pattern(pattern);
        sender.sendMessagePrefixed("format_pattern", pattern);
    }

    @Override
    public List<String> tabSuggestions(Sender sender, String[] args) {
        if (args.length == 2) {
            return PATTERNS;
        }
        return Collections.emptyList();
    }
}
