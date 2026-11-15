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
            g.hotkey("alt+m", 1);
        } catch (GoomeException e) {
        }
        Ui ui = g.ui();
        Window menu = new Window(80, 80, 300, 0).open(false);
        boolean fly = false, god = false, running = true;
        double speed = 1;
        while (running) {
            for (Event e : g.events(16)) {
                if (e.type() == Goome.QUIT) running = false;
                if (e.type() == Goome.HOTKEY) menu.open(!menu.open());
                ui.feed(e);
            }
            if (!running) break;
            Canvas c = ui.begin(0);
            if (c == null) continue;
            if (menu.open()) {
                if (ui.window(APP_NAME, menu, Ui.WIN_MOVE | Ui.WIN_CLOSE)) {
                    fly = ui.toggle("Fly", fly);
                    god = ui.checkbox("God mode", god);
                    speed = ui.slider("Speed", speed, 1, 10, "%.1f");
                    if (ui.button("Respawn")) ui.toast("respawned", 2000);
                }
                ui.windowEnd();
            } else {
                c.roundRect(20, 20, 170, 30, 8, 0xC0202838);
                c.text(32, 26, "alt+m opens the menu", 0xFFFFFFFF);
            }
            ui.end();
        }
        ui.close();
        g.close();
    }
}
