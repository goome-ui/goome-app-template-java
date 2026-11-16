package mygoomeapp;

import io.github.goomeui.*;

import java.util.List;

public class Main {
    static final String APP_NAME = "My Goome App";

    static int clicks;
    static double volume = 0.5;
    static boolean overlay, shown;
    static Window win;

    static Goome openMode(boolean ov) {
        if (!ov) return Goome.openApp(APP_NAME, 640, 420);
        Goome g = Goome.open(APP_NAME);
        List<Monitor> mons = g.monitors();
        double x = mons.isEmpty() ? 40 : mons.get(0).area.x + mons.get(0).area.w - 340;
        win = new Window(x, 60, 300, 0);
        return g;
    }

    static void contents(Ui ui) {
        overlay = ui.toggle("Overlay mode", overlay);
        ui.separator();
        ui.pushColor(Style.TEXT, ui.animColor("hello", shown ? 0xFFF2F4F8 : 0x00F2F4F8, 600, Theme.EASE_OUT));
        ui.heading("Hello from " + APP_NAME);
        ui.pop();
        shown = true;
        if (ui.button("Click me")) clicks++;
        ui.label("clicked " + clicks + " times");
        volume = ui.slider("Volume", volume, 0, 1, "%.2f");
    }

    public static void main(String[] args) {
        boolean mode = false;
        Goome g;
        try {
            g = openMode(false);
        } catch (GoomeException e) {
            System.err.println("couldnt open a window: " + e.getMessage());
            System.exit(1);
            return;
        }
        Ui ui = g.ui();
        boolean running = true;
        while (running) {
            for (Event e : g.events(16)) {
                if (e.type() == Goome.QUIT || e.type() == Goome.CLOSE) running = false;
                ui.feed(e);
            }
            if (!running) break;
            if (overlay != mode) {
                ui.close();
                g.close();
                try {
                    g = openMode(overlay);
                } catch (GoomeException e) {
                    System.err.println("no overlay here, staying in window mode");
                    overlay = false;
                    g = openMode(false);
                }
                mode = overlay;
                ui = g.ui();
                System.out.println(mode ? "overlay mode" : "window mode");
                continue;
            }
            if (ui.begin(0) == null) continue;
            if (mode) {
                if (ui.window(APP_NAME, win, Ui.WIN_MOVE | Ui.WIN_COLLAPSE)) contents(ui);
                ui.windowEnd();
            } else {
                ui.app(APP_NAME, 0);
                contents(ui);
                ui.appEnd();
            }
            ui.end();
        }
        ui.close();
        g.close();
    }
}
