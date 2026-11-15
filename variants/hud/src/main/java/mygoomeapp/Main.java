package mygoomeapp;

import io.github.goomeui.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
        DateTimeFormatter clock = DateTimeFormatter.ofPattern("HH:mm:ss");
        long start = Goome.nowMs(), last = start;
        double[] fps = {0};
        boolean hidden = false, running = true;
        try (Pacer pace = new Pacer(30)) {
            while (running) {
                for (Event e : g.events(pace.next())) {
                    if (e.type() == Goome.QUIT) running = false;
                    if (e.type() == Goome.HOTKEY) hidden = !hidden;
                }
                if (!running) break;
                long now = Goome.nowMs();
                if (now > last) fps[0] = fps[0] * 0.9 + 100.0 / (now - last);
                last = now;
                boolean show = !hidden;
                long up = (now - start) / 1000;
                g.frame(0, c -> {
                    if (!show) return;
                    c.roundRect(20, 20, 160, 92, 10, 0xB0141820);
                    c.text(34, 30, LocalTime.now().format(clock), 0xFFFFFFFF, true);
                    c.text(34, 62, "up " + up + "s", 0xFFC0C8D0);
                    c.text(34, 84, String.format("%.0f fps", fps[0]), 0xFF6FDC5F);
                });
            }
        }
        g.close();
    }
}
