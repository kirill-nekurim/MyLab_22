package Library.Hud;

import Library.EngBook;

public class HudEngBook implements EngBook {
    private String author;
    private int year;
    private String title;
    private String skill;

    public HudEngBook(String author, int year, String title, String skill) {
        this.author = author;
        this.year = year;
        this.title = title;
        this.skill = skill;
    }

    @Override
    public String getInfo() {
        String result = String.join(" ", title, author, year + "ã", skill);
        return result;
    }
}