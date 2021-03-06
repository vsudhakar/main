package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_APPOINT;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.AppointCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Appoint;
//@@author risashindo7
/**
 * Parser class for the Appoint feature
 */
public class AppointCommandParser implements Parser<AppointCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the AppointCommand
     * and returns an AppointCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public AppointCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_APPOINT);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AppointCommand.MESSAGE_USAGE));
        }

        String appoint = argMultimap.getValue(PREFIX_APPOINT).orElse("");
        return new AppointCommand(index, new Appoint(appoint));

    }
}
//@@author
