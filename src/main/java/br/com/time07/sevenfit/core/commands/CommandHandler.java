package br.com.time07.sevenfit.core.commands;

public interface CommandHandler<T extends Command> {
    CommandResult handle(T command);
}
