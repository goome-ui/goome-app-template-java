package mygoomeapp;

import io.github.goomeui.*;

public class Main {
    static final String APP_NAME = "My Goome App";

    public static void main(String[] args) {
        Goome g;
        try {
            g = Goome.open(APP_NAME);
        } catch (GoomeException e) {
            System.err.println("couldnt open an overlay: " + e.getMessage());
            System.exit(1);
            return;
        }
        try {
            g.hotkey("alt+h", 1);
        } catch (GoomeException e) {
        }
        Ui ui = g.ui();
        Window win = new Window(60, 60, 280, 0);
        int clicks = 0;
        boolean hidden = false;
        while (win.open()) {
            for (Event e : g.events(16)) {
                if (e.type() == Goome.QUIT) win.open(false);
                if (e.type() == Goome.HOTKEY) hidden = !hidden;
                ui.feed(e);
            }
            if (!win.open() || ui.begin(0) == null) continue;
            if (!hidden) {
                if (ui.window(APP_NAME, win, Ui.WIN_MOVE | Ui.WIN_CLOSE)) {
                    ui.label("im on top of everything");
                    if (ui.button("Click me")) clicks++;
                    ui.label("clicked " + clicks + " times");
                    ui.label("alt+h hides me");
                }
                ui.windowEnd();
            }
            ui.end();
        }
        ui.close();
        g.close();
    }
}
