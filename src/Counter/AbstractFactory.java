package Counter;

import Library.EngBook;
import Library.RuBook;

public interface AbstractFactory {
    RuBook createRuLiterature();
    EngBook createEngLiterature();
}
