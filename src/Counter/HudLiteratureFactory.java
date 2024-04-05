package Counter;

import Library.EngBook;
import Library.Hud.HudEngBook;
import Library.Hud.HudRuBook;
import Library.RuBook;
import Operations.ReaderCsv;
import static java.lang.Integer.parseInt;
import java.util.List;
import java.util.Random;



public class HudLiteratureFactory {
    private  List<String[]> englishHudList;
    private  List<String[]> russianHudList;
    private static HudLiteratureFactory INSTANCE;

    private HudLiteratureFactory() {
        russianHudList = ReaderCsv.readCsv("data/russian_fiction.csv");
        englishHudList = ReaderCsv.readCsv("data/english_fiction.csv");
    }

    public static HudLiteratureFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HudLiteratureFactory();
        }
        return INSTANCE;
    }

    public RuBook createRuLiterature(){

        Random r = new Random();
        String[] bookInfo = russianHudList.get(r.nextInt(russianHudList.size()-1));
        return new HudRuBook(bookInfo[0], r.nextInt(3) + 1, bookInfo[1], bookInfo[2]);
    }

    public EngBook createEngLiterature() {

        Random r = new Random();
        String[] levels = {
                "A1", "A2", "B1", "B2", "C1", "C2"
        };
        String level = levels[r.nextInt(levels.length - 1)];
        String[] bookInfo = englishHudList.get(r.nextInt(englishHudList.size() - 1));
        return new HudEngBook(bookInfo[0], parseInt(bookInfo[2]), bookInfo[1], level);
    }
}
