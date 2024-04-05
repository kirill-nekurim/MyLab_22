package Library.Hud;

import Library.RuBook;

public class HudRuBook implements RuBook {
    public String type;
    public int edition;
    public String title;
    public String author;
    public HudRuBook (String type, int edition, String title, String author) {
        this.author = author;
        this.edition = edition;
        this.title = title;
        this.author = author;
    }
    @Override
    public String getInfo() {
        String result = String.join(" ", type, "'",
                title, "'", author, edition + "-е", "издание");
        return result;
    }
}
